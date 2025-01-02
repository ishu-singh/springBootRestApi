package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

//interacts with the database layer i.e. DAO
@Service
@Component
public class BookService {

    // private static List<Book> list = new ArrayList<>();
    // static {
    //     // list.add(new Book(1, "Book1", "Name1"));
    //     list.add(new Book(2, "Book2", "Name2"));
    //     list.add(new Book(3, "Book3", "Name3"));
    //     list.add(new Book(4, "Book4", "Name4"));
    //     list.add(new Book(5, "Book5", "Name5"));
    //     list.add(new Book(6, "Book6", "Name6"));
    // }
    @Autowired
    private BookRepository bookRepository;

    // get all books
    public List<Book> getAllBooks() {
        List<Book>list=this.bookRepository.findAll();
        return list;
    }

    // get single book
    public Book getBookById(int id) {
        Book book = null;
        try{
        // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        book=this.bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    // adding a book..
    public Book addABook(Book book) {
        // list.add(book);
        Book result=this.bookRepository.save(book);
        return result;
    }

    // deleting a record ..
    public void deleteABook(int id) {

        // list = list.stream().filter(e -> {
        //     if (e.getId() != id) {
        //         return true;
        //     } else {
        //         return false;
        //     }
        // }).collect(Collectors.toList());
        this.bookRepository.deleteById(id); 
    }
    //updating any data
    public void updateABook(Book book,int id){
    //    list= list.stream().map(e->{
    //         if(e.getId()==id){
    //             e.setTitle(book.getTitle());
    //             e.setAuthor(book.getAuthor());
    //         }
    //         return e;
    //     }).collect(Collectors.toList());
    book.setId(id);
    this.bookRepository.save(book);

        
    }

}
