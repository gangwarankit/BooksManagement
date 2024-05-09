package org.bookmanager.service;

import org.bookmanager.beans.Book;

import java.util.List;

public interface BookService {
    String addBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int id);

    Book getBookByTitle(String author);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByPublication(String author);

    int updateBook(Book book);

    int deleteBook(int id);
}
