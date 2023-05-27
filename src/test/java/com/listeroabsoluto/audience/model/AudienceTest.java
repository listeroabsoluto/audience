package com.listeroabsoluto.audience.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudienceTest {

    @Test
    void getName() {
        Audience audience = new Audience("name");
        assertEquals("name", audience.getName());
    }

    @Test
    void rename() {
        Audience audience = new Audience("name");
        assertEquals("name", audience.getName());

        audience.rename("rename");
        assertEquals("rename", audience.getName());
    }

    @Test
    void getUsers() {
        Audience audience = new Audience("name");
        audience.addUser("1");
        audience.addUser("2");
        audience.addUser("3");
        assertEquals(3, audience.getUsers().size());
    }

    @Test
    void addUser() {
        Audience audience = new Audience("name");
        audience.addUser("1");
        assertTrue(audience.containsUser("1"));
    }

    @Test
    void removeUser() {
        Audience audience = new Audience("name");
        audience.addUser("1");
        assertTrue(audience.containsUser("1"));

        audience.removeUser("1");
        assertFalse(audience.containsUser("1"));
    }

    @Test
    void testToString() {
        Audience audience = new Audience("name");

        assertEquals("name", audience.toString());
    }

    @Test
    void testNoDuplicateUsers() {
        Audience audience = new Audience("name");
        audience.addUser("1");
        assertEquals(1, audience.getUsers().size());
        audience.addUser("1");
        assertEquals(1, audience.getUsers().size());
    }
}