package com.epam.library.util.validation;

import com.epam.library.domain.Book;
import com.epam.library.service.exception.ServiceException;

public class ServiceValidator {
    public void validateBook(Book book) throws ServiceException {
        if (book == null) throw new ServiceException();
        if (book.getId() < 0 || book.getYear() < 0) throw new ServiceException("Negative value");
        if (book.getTitle().isEmpty() || book.getAuthor().isEmpty()) throw new ServiceException("Empty field");
    }
}
