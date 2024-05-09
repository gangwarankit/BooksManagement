package org.bookmanager.dao;

import org.bookmanager.beans.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);

    List<Book> getAllBooks();

    List<Book> getBooksByPublication(String publication);

    List<Book> getBooksByAuthor(String author);

    Book getBookByTitle(String title);

    Book getBookById(int id);

    int updateBook(Book emp);

    int deleteBook(int id);
}
