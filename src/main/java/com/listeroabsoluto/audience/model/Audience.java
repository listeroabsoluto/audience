package com.listeroabsoluto.audience.model;

import java.util.HashSet;
import java.util.Set;

public class Audience {
    private String name;

    private Set<User> users;

    public Audience(String name) {
        this.name = name;
        this.users = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void rename(String name)
    {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(String id) {
        if (this.containsUser(id)) {
            return;
        }
        users.add(new User(id));
    }

    public void removeUser(String id) {
        users.remove(new User(id));
    }

    public boolean containsUser(String id) {
        return users.contains(new User(id));
    }

    @Override
    public String toString() {
        return name;
    }
}
