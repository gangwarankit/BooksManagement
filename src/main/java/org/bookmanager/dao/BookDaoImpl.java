package org.bookmanager.dao;

import org.bookmanager.beans.Book;
import org.bookmanager.exceptions.BookIdExistException;
import org.bookmanager.exceptions.BookIdNotAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate template;

    @Override
    public int addBook(Book book) {


        String checkId = "select count(*) from Book where bookId=?";
        int count = template.queryForObject(checkId, Integer.class,book.getBookId());
        if(count>=0){
            throw new BookIdExistException();
        }

        String add = "insert into Book values(?,?,?,?,?)";
        Object args[]={book.getBookId(), book.getTitle(), book.getAuthor(), book.getPublication(), book.getPrice()};
        int rows = template.update(add,args);
        return rows;
    }

    @Override
    public List<Book> getAllBooks() {
        String qry = "select * from Book";
        List<Book> emplist = template.query(qry, new BeanPropertyRowMapper<Book>(Book.class));
        return emplist;
    }

    @Override
    public List<Book> getBooksByPublication(String publication) {
        String qry = "select * from Book where publication=?";
        List<Book> emplist = template.query(qry, new BeanPropertyRowMapper<Book>(Book.class), publication);
        return emplist;
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        String qry = "select * from Book where author=?";
        List<Book> emplist = template.query(qry, new BeanPropertyRowMapper<Book>(Book.class), author);
        return emplist;
    }

    @Override
    public Book getBookByTitle(String title) {
        String qry = "select * from Book where title=?";
        Book book = template.queryForObject(qry, new BeanPropertyRowMapper<Book>(Book.class), title);
        return book;
    }

    @Override
    public Book getBookById(int id) {
        String qry = "select * from Book where bookId=?";
        List<Book> book = template.query(qry, new BeanPropertyRowMapper<Book>(Book.class), id);
        if(book.size()==0)
            throw new BookIdNotAvailable();
        return book.get(0);
    }

    @Override
    public int updateBook(Book book) {
        String qry = "update Book set title=?,author=?,publications=?,price =? where bookId=?";
        Object args[]={book.getTitle(), book.getAuthor(), book.getPublication(), book.getPrice(), book.getBookId()};
        int rows = template.update(qry,args);
        return rows;
    }

    @Override
    public int deleteBook(int id) {
        String qry = "delete from Book where bookId=?";
        int rows = template.update(qry,id);
        return rows;
    }
}
