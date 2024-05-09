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


    @ExceptionHandler(value=BookIdNotAvailable.class)
    public ResponseEntity<String> bookIdNotAvailable(BookIdNotAvailable ex){
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
