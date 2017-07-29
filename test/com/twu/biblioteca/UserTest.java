package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("000-0001", "Lucy","123456","123@qq.com","123456");
    }

    @Test
    public void shouldReturnUserInformation() throws Exception {
        assertEquals("Name: Lucy\tEmail: 123@qq.com\tPhoneNumber: 123456", user.getInformation("1"));
    }
}