package edu.mcc.codeschool.class26.models;

import java.util.UUID;

public class Book {
    private UUID id;
    private UUID authorId;
    private String title;
    private Integer releaseYear;
    private Integer pages;
    private String publisher;
    private Boolean isHardCover;
    private Genre genre;

    public UUID getId() {
        return id;
    }

    public Book setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public Book setAuthorId(UUID authorId) {
        this.authorId = authorId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Book setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public Integer getPages() {
        return pages;
    }

    public Book setPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Boolean getHardCover() {
        return isHardCover;
    }

    public Book setHardCover(Boolean hardCover) {
        isHardCover = hardCover;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }
}
