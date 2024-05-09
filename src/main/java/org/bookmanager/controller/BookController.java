package org.bookmanager.controller;

import org.bookmanager.beans.Book;
import org.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addbook")
    public ResponseEntity<String> addBook(@RequestBody Book book) {

            String msg = bookService.addBook(book);
            return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @GetMapping("/findallbooks")
    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> bookList = bookService.getAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/findBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/findBookByTitle/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title) {
        Book book = bookService.getBookByTitle(title);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }
    @GetMapping("/findBooksByAuthor/{author}")
    public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable("author") String author) {
        List<Book> book = bookService.getBooksByAuthor(author);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }
    @GetMapping("/findBooksByPublications/{publication}")
    public ResponseEntity<List<Book>> getBookByPublications(@PathVariable("publication") String publication) {

            List<Book> book = bookService.getBooksByPublication(publication);
            return new ResponseEntity<>(book, HttpStatus.OK);
    }


    @PutMapping("/editbook")
    public ResponseEntity<Integer> updateBook(@RequestBody Book book) {
        int  res= bookService.updateBook(book);
        System.out.println("Book data Updated Successfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping("/deletebook/{id}")
    public ResponseEntity<Integer> deleteBook(@PathVariable("id") int id) {
        int res = bookService.deleteBook(id);
        System.out.println("Book data Deleted Successfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}

