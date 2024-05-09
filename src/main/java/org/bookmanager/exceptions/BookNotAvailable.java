package org.bookmanager.exceptions;

public class BookNotAvailable extends RuntimeException{

    public BookNotAvailable(){
        super("Book Not Available");
    }
}
