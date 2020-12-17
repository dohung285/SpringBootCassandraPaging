package com.sexton.cassandra.pagination.example.models;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.Column;

import java.util.UUID;

@Table("users_test_demo")
public class User {
    @PrimaryKey
    private UUID id;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;

    public User(final String firstName, final String lastName) {
        this.id = UUIDs.timeBased();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("id: %s | firstname: %s | lastname: %s", id, firstName, lastName);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
