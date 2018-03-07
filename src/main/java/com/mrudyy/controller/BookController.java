package com.mrudyy.controller;

import com.mrudyy.model.Book;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    Session session;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ArrayList<Book> getBooksList(){
        List list = session.createQuery("from Book").list();
        return (ArrayList<Book>) list;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Book getBookByID(@PathVariable("id") int id){
        Book book = session.get(Book.class,id);
        return book;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public Boolean addBook(@RequestBody Book book){
        System.out.println(book);
        return true;
    }
}
