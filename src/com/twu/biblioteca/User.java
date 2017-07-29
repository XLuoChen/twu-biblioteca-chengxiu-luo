package com.twu.biblioteca;

public class User {
    private String name;
    private String number;
    private String password;
    private String email;
    private String phoneNumber;

    public User(String number, String name, String password, String email, String phoneNumber) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDetail() {
        return String.format("Number: %s\tPassword: %s", getNumber(), getPassword());
    }
}
