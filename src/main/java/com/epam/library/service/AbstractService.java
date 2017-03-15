package com.epam.library.service;

import com.epam.library.entity.Entity;
import com.epam.library.exception.ServiceException;

public abstract class AbstractService<T extends Entity> {
    public abstract T create(T entity) throws ServiceException;

    public abstract T findById(int id) throws ServiceException;

    public abstract T update(T entity) throws ServiceException;

    public abstract void deleteById(int id) throws ServiceException;
}
