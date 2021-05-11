package me.infinity.randomThings.backend.service;

import me.infinity.randomThings.backend.entity.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class UserService {
    private final JSONParser parser = new JSONParser();
    private final User defaultUser = new User("Zone", "Infinity", "zoneinfinty1005@discord.com", "000 111 0121", 15, new User.Address(1, "Street", "New Town", "Republic State", "Earth"));

    public User getRandomUser() {
        try {
            URL url = new URL("https://randomuser.me/api");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            StringBuilder lines = new StringBuilder();
            while ((line = in.readLine()) != null) {
                lines.append(line);
            }
            in.close();

            return jsonToUser(lines.toString());
        } catch (IOException e) {
            return defaultUser;
        }
    }

    private User jsonToUser(String lines) {
        try {
            final JSONObject result = (JSONObject) ((JSONArray) ((JSONObject) parser.parse(lines)).get("results")).get(0);

            final JSONObject name = (JSONObject) result.get("name");
            final String firstName = (String) name.get("first");
            final String lastName = (String) name.get("last");

            final JSONObject location = (JSONObject) result.get("location");

            final JSONObject street = (JSONObject) location.get("street");
            final long streetNumber = (long) street.get("number");
            final String streetName = (String) street.get("name");

            final String city = (String) location.get("city");
            final String state = (String) location.get("state");
            final String country = (String) location.get("country");

            final String email = (String) result.get("email");
            final long age = (long) ((JSONObject) result.get("dob")).get("age");
            final String phone = (String) result.get("phone");

            return new User(firstName, lastName, email, phone, age, new User.Address(streetNumber, streetName, city, state, country));
        } catch (ParseException e) {
            return defaultUser;
        }
    }
}
