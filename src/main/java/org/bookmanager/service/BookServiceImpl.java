package org.bookmanager.service;

import org.bookmanager.beans.Book;
import org.bookmanager.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDao bookDao;

    public BookServiceImpl() {
    }
    @Override
    public String addBook(Book book) {
//        bookList.add(book);
        bookDao.addBook(book);
        return "object inserted successfully";
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookDao.getBookByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookDao.getBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByPublication(String publication) {
        return bookDao.getBooksByPublication(publication);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int deleteBook(int id) {
        return bookDao.deleteBook(id);
    }
}
