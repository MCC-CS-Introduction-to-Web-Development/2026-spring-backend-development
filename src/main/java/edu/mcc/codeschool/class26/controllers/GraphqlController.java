package edu.mcc.codeschool.class26.controllers;

import edu.mcc.codeschool.class26.models.Author;
import edu.mcc.codeschool.class26.models.Book;
import edu.mcc.codeschool.class26.models.Genre;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class GraphqlController {
    private List<Author> authors = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    @QueryMapping
    public List<Author> getAuthors(){
        return authors;
    }

    @QueryMapping
    public List<Book> getBooks(){
        return books;
    }

    @QueryMapping
    public Author getAuthorById(@Argument UUID authorId){
        Optional<Author> ret = authors.stream().filter(author -> author.getId().equals(authorId)).findFirst();
        return ret.isPresent() ? ret.get() : null;
    }

    @QueryMapping
    public Book getBookById(@Argument UUID bookId){
        Optional<Book> ret = books.stream().filter(book -> book.getId().equals(bookId)).findFirst();
        return ret.isPresent() ? ret.get() : null;
    }

    @MutationMapping
    public Author createAuthor(@Argument String firstName, @Argument String lastName, @Argument Integer booksPublished){
        Author author = new Author();
        author.setId(UUID.randomUUID())
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBooksPublished(booksPublished);

        authors.add(author);

        return author;
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument Integer releaseYear, @Argument Integer pages, @Argument String publisher, @Argument Boolean isHardCover, @Argument UUID authorId, @Argument Genre genre){
        Book book = new Book();
        book.setId(UUID.randomUUID())
                .setTitle(title)
                .setReleaseYear(releaseYear)
                .setPages(pages)
                .setPublisher(publisher)
                .setHardCover(isHardCover)
                .setAuthorId(authorId)
                .setGenre(genre);
        books.add(book);

        return book;
    }

    @MutationMapping
    public String deleteAuthorById(@Argument UUID authorId){
        Optional<Author> ret = authors.stream().filter(author -> author.getId().equals(authorId)).findFirst();
        if(ret.isPresent()){
            authors.remove(ret.get());
            return "Deleted Author " + authorId;
        } else {
            return "ERROR, could not find author";
        }
    }

    @MutationMapping
    public String deleteBookById(@Argument UUID bookId){
        Optional<Book> ret = books.stream().filter(book -> book.getId().equals(bookId)).findFirst();
        if(ret.isPresent()){
            books.remove(ret.get());
            return "Deleted Book " + bookId;
        } else {
            return "ERROR, could not find book";
        }
    }

    @SchemaMapping(typeName = "Author", field = "books")
    public List<Book> getBooksForAuthor(Author author){
        return books.stream().filter(book -> book.getAuthorId().equals(author.getId())).toList();
    }

    @SchemaMapping(typeName = "Book", field = "author")
    public Author getAuthorForBook(Book book){
        Optional<Author> ret = authors.stream().filter(author -> author.getId().equals(book.getAuthorId())).findFirst();
        return ret.isPresent() ? ret.get() : null;
    }

}
