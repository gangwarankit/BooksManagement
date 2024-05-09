package org.bookmanager.beans;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String publication;
    private Double price;

    public Book() {
    }

    public Book(int bookId, String title, String author, String publication, Double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                ", price=" + price +
                '}';
    }
}
