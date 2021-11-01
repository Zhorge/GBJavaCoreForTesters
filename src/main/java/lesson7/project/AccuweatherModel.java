package lesson7.project;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson7.project.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "Gt8i24WcsFGu0LJ1VjlLO3C9FVQF7fHI";
    private static final String API_KEY_QUERY_PROPERTY = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private DateBaseRepository dataBaseRepository = new DateBaseRepository();

    public static void main(String[] args) {
        try {
            new AccuweatherModel().getWeather("Moscow", Period.FIVE_DAYS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getWeather(String city, Period period) throws IOException {
        //http://dataservice.accuweather.com/indices/v1/daily/1day/349727
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PROPERTY, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .get()
                        .addHeader("accept", "application/json")
                        .build();

                Response oneDayForecastResponse = OK_HTTP_CLIENT.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();

                System.out.println(weatherResponse);
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение
                //Например: Погода в городе Москва - 5 градусов по цельсию Expect showers late Monday night
                //dataBaseRepository.saveWeatherToDateBase(new Weather()) - тут после парсинга добавляем данные в БД
                String Temperature = OBJECT_MAPPER.readTree(weatherResponse).at("/DailyForecasts/Temperature/Minimum/Value").asText();
                String ExpectWeather = OBJECT_MAPPER.readTree(weatherResponse).at("/Headline/Text").asText();
                System.out.println("Погода в городе " + city + " - " + Temperature + " градусов по цельсию. " + ExpectWeather);

                break;
            case FIVE_DAYS:
                //TODO*: реализовать вывод погоды на 5 дней
                HttpUrl httpUrlFive = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment(detectCityKey(city))
                        .addQueryParameter(API_KEY_QUERY_PROPERTY, API_KEY)
                        .build();

                Request requestFive = new Request.Builder()
                        .url(httpUrlFive)
                        .get()
                        .addHeader("accept", "application/json")
                        .build();

                Response fiveDayForecastResponse = OK_HTTP_CLIENT.newCall(requestFive).execute();
                String weatherResponseFive = fiveDayForecastResponse.body().string();

                System.out.println(weatherResponseFive);
                break;
        }
    }

    private String detectCityKey(String city) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PROPERTY, API_KEY)
                .addQueryParameter("q", city)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response locationResponse = OK_HTTP_CLIENT.newCall(request).execute();
        String locationResponseString = locationResponse.body().string();

        String citykey = OBJECT_MAPPER.readTree(locationResponseString).get(0).at("/Key").asText();

        return citykey;
    }

    @Override
    public boolean saveWeather(Weather weather) throws SQLException {
        return dataBaseRepository.saveWeather(weather);
    }

    @Override
    public Weather getSavedToDB() {
        return dataBaseRepository.getSavedToDB();
    }

    public void saveWeather(List<Weather> weatherList) {
        dataBaseRepository.saveWeather(weatherList);
    }

    public List<Weather> getSavedToDBList() {
        return dataBaseRepository.getSavedToDBList();
    }
}
