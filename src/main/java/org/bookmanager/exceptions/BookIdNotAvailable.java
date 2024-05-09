package org.bookmanager.exceptions;

public class BookIdNotAvailable extends RuntimeException{

    public BookIdNotAvailable(){
        super("BookId Not Available");
    }
}
