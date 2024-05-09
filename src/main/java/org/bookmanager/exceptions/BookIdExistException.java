package org.bookmanager.exceptions;

public class BookIdExistException extends RuntimeException{
    public BookIdExistException(){
        super("BookId already exist. Check another book");
    }
}
