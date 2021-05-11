package me.infinity.randomThings.component;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import me.infinity.randomThings.backend.entity.User;

import java.util.concurrent.atomic.AtomicLong;

public class UserCard extends VerticalLayout {
    private final static AtomicLong id = new AtomicLong();

    public UserCard(User user) {
        addClassName("user-card");
        setId(String.valueOf(id.getAndIncrement()));

        final H3 name = new H3(user.firstname + " " + user.lastname);
        final H6 email = new H6("Email : " + user.email);
        final H6 phone = new H6("Phone : " + user.phone);
        final H6 age = new H6("Age : " + user.age);

        final User.Address address = user.address;
        final String addressInString = String.format("%s %s, %s, %s, %s", address.streetNumber, address.streetName, address.city, address.state, address.country);
        final H6 address_ = new H6("Address : " + addressInString);

        add(
                name,
                email,
                phone,
                age,
                address_
        );
    }
}
