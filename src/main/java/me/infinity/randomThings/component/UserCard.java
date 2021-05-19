package me.infinity.randomThings.component;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import me.infinity.randomThings.backend.entity.User;

import java.util.concurrent.atomic.AtomicLong;

public class UserCard extends VerticalLayout {
    private final static AtomicLong id = new AtomicLong();

    public UserCard(User user) {
        addClassName("user-card");
        setId(String.valueOf(id.getAndIncrement()));

        final User.Address address = user.address;
        final String addressInString = String.format("%s %s, %s, %s, %s", address.streetNumber, address.streetName, address.city, address.state, address.country);

        String html = String.format("""
                        <h3>%s</h3>
                        Email : %s<br>
                        Phone : %s<br>
                        Age : %s<br>
                        Address : %s
                        """,
                user.firstname + " " + user.lastname,
                user.email,
                user.phone,
                user.age,
                addressInString);

        getElement().setProperty("innerHTML", html);
    }
}
