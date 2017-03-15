package com.epam.library.dao;

import com.epam.library.entity.Entity;
import com.epam.library.exception.DAOException;

import java.sql.Connection;

public abstract class AbstractDAO<T extends Entity> {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract T create(T entity) throws DAOException;

    public abstract T findById(int id) throws DAOException;

    public abstract T update(T entity) throws DAOException;

    public abstract void deleteById(int id) throws DAOException;
}
