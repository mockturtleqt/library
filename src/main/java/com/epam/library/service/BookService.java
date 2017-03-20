package com.epam.library.service;

import com.epam.library.domain.Book;
import com.epam.library.service.exception.ServiceException;

import java.util.List;

public abstract class BookService {

    public abstract Book create(Book book) throws ServiceException;

    public abstract Book findById(int id) throws ServiceException;

    public abstract Book update(Book book) throws ServiceException;

    public abstract Book updateTitle(String oldTitle, String newTitle) throws ServiceException;

    public abstract void deleteById(int id) throws ServiceException;

    public abstract Book findByTitle(String title) throws ServiceException;

    public abstract List<Book> findAll() throws ServiceException;
}
