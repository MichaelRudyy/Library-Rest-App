package com.mrudyy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors", schema = "schema_1")
public class Author {
    private int idAuthor;
    private String name;
    private List<Book> books;

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bookauthor" , joinColumns = {
            @JoinColumn(name = "id_author")
    } , inverseJoinColumns = {
            @JoinColumn(name = "id_book")})
    @JsonIgnoreProperties("authors")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
               "idAuthor=" + idAuthor +
                ", name='" + name + '\'' +
                //", books=" + books +
                '}';
    }
}
