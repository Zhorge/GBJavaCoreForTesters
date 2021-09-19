package homeWorkLesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> directory = new HashMap<>();
    private List<String> phoneNumberList;

    public List<String> get(String surname) {
        return directory.get(surname);
    }

    public void add(String surname, String phoneNumber) {
        if (directory.containsKey(surname)) {
            phoneNumberList = directory.get(surname);
            phoneNumberList.add(phoneNumber);
            directory.put(surname, phoneNumberList);
        } else {
            phoneNumberList = new ArrayList<>();
            phoneNumberList.add(phoneNumber);
            directory.put(surname, phoneNumberList);
        }
    }
}
