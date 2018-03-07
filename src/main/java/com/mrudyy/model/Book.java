package com.mrudyy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books", schema = "schema_1")
@Component
public class Book {
    private int idBook;
    private String title;
    private List<Author> authors;
    private int year;
    private String genre;

/*    public Book(String title, int year, String genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    Book(){}*/

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "bookauthor", joinColumns = {
            @JoinColumn(name = "id_book")
    }, inverseJoinColumns = {
            @JoinColumn(name = "id_author")})
    @JsonIgnoreProperties("books")
    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", authors=" + authors +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
