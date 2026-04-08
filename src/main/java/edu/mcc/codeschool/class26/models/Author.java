package edu.mcc.codeschool.class26.models;

import java.util.List;
import java.util.UUID;

public class Author {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer booksPublished;

    public UUID getId() {
        return id;
    }

    public Author setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getBooksPublished() {
        return booksPublished;
    }

    public Author setBooksPublished(Integer booksPublished) {
        this.booksPublished = booksPublished;
        return this;
    }
}