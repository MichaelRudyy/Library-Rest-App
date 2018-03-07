package com.mrudyy.controller;

import com.mrudyy.model.Author;
import com.mrudyy.model.Book;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/authors")
@RestController
public class AuthorController {

    @Autowired
    Session session;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Book> getAuthorsList(){
        List list = session.createQuery("from Author ").list();
        return (ArrayList<Book>) list;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Author getAuthorByID(@PathVariable("id") int id){
        Author author = session.get(Author.class,id);
        return author;
    }
}
