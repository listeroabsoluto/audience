package com.listeroabsoluto.audience.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.cassandra.core.mapping.*;

@Table(value = "audiences")
public class Audience {
    @PrimaryKey
    @JsonView(View.Public.class)
    private String name;

    @CassandraType(type = CassandraType.Name.SET, typeArguments = { CassandraType.Name.TEXT })
    @JsonView(View.Internal.class)
    private Set<String> users;

    @Column
    @JsonView(View.ExtendedPublic.class)
    private boolean active;

    public static class View {
        public static class Public { }
        public static class ExtendedPublic extends Public { }
        public static class Internal extends ExtendedPublic { }
    }

    public Audience(String name) {
        this.name = name;
        this.users = new HashSet<>();
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public void rename(String name)
    {
        this.name = name;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void addUser(String id) {
        if (this.containsUser(id)) {
            return;
        }
        users.add(id);
    }

    public void removeUser(String id) {
        if (!this.containsUser(id)) {
            return;
        }
        users.remove(id);
    }

    public boolean containsUser(String id) {
        if (null == users) {
            users = new HashSet<>();
        }

        return users.contains(id);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return name;
    }

}
