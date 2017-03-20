package com.epam.library.dao;

import com.epam.library.dao.exception.DaoException;
import com.epam.library.domain.Book;

import java.util.List;

public interface BookDao {
    Book create(Book book) throws DaoException;

    Book findById(int id) throws DaoException;

    Book update(Book book) throws DaoException;

    void deleteById(int id) throws DaoException;

    Book findByTitle(String title) throws DaoException;

    List<Book> findAll() throws DaoException;
}
