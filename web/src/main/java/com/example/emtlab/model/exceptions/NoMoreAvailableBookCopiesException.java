package com.example.emtlab.model.exceptions;

public class NoMoreAvailableBookCopiesException extends RuntimeException {
    public NoMoreAvailableBookCopiesException(Long id) {
        super(String.format("There are no more available copies for the book with id %d", id));
    }
}