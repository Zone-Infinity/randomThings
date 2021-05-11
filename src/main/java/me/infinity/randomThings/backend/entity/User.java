package me.infinity.randomThings.backend.entity;

public class User {
    public String firstname;
    public String lastname;
    public String email;
    public String phone;
    public long age;
    public Address address;

    public User(String firstname, String lastname, String email, String phone, long age, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
    }

    public static class Address {
        public long streetNumber;
        public String streetName;
        public String city;
        public String state;
        public String country;

        public Address(long streetNumber, String streetName, String city, String state, String country) {
            this.streetNumber = streetNumber;
            this.streetName = streetName;
            this.city = city;
            this.state = state;
            this.country = country;
        }
    }
}
