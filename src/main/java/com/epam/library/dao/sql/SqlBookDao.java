package com.epam.library.dao.sql;

import com.epam.library.dao.BookDao;
import com.epam.library.dao.exception.DaoException;
import com.epam.library.domain.Book;

import java.sql.Connection;
import java.util.List;

public abstract class SqlBookDao implements BookDao {

    protected Connection connection;

    public SqlBookDao() {
    }

    public SqlBookDao(Connection connection) {
        this.connection = connection;
    }

    public abstract Book create(Book book) throws DaoException;

    public abstract Book findById(int id) throws DaoException;

    public abstract Book update(Book book) throws DaoException;

    public abstract void deleteById(int id) throws DaoException;

    public abstract Book findByTitle(String title) throws DaoException;

    public abstract List<Book> findAll() throws DaoException;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
