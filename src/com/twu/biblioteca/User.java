package com.twu.biblioteca;

public class User {
    private String number;
    private String password;

    public User(String number, String password) {
        this.number = number;
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getDetail() {
        return String.format("Number: %s\tPassword: %s", getNumber(), getPassword());
    }
}
