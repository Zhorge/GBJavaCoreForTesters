package lesson6;


import okhttp3.*;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpExamples {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder() //объект символизирующий клиентскую часть, для подключения к какому то сервису;
                .readTimeout(10, TimeUnit.SECONDS) // 10 сек - таймаут на чтение
                .build();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("geekbrains.ru")
                .addPathSegment("/courses")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.body().string());


    }
}
