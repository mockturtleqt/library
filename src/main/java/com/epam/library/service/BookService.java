package com.epam.library.service;

import com.epam.library.domain.Book;
import com.epam.library.service.exception.ServiceException;

import java.util.List;

public interface BookService {

    Book create(Book book) throws ServiceException;

    Book findById(int id) throws ServiceException;

    Book update(Book book) throws ServiceException;

    Book updateTitle(String oldTitle, String newTitle) throws ServiceException;

    void deleteById(int id) throws ServiceException;

    Book findByTitle(String title) throws ServiceException;

    List<Book> findAll() throws ServiceException;
}
