package org.bookmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler(value=BookIdExistException.class)
    public ResponseEntity<String> bookIdExist(BookIdExistException ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.FOUND);
    }


    @ExceptionHandler(value=BookNotAvailable.class)
    public ResponseEntity<String> bookIdNotAvailable(BookNotAvailable ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
