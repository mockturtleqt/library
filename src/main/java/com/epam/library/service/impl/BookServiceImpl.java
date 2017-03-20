package com.epam.library.service.impl;

import com.epam.library.dao.BookDao;
import com.epam.library.dao.exception.DaoException;
import com.epam.library.dao.factory.DaoFactory;
import com.epam.library.domain.Book;
import com.epam.library.service.BookService;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.util.validation.ServiceValidator;

import java.util.List;

public class BookServiceImpl extends BookService {
    public Book create(Book book) throws ServiceException {
        try {
            new ServiceValidator().validateBook(book);
            return DaoFactory.getInstance().getBookDao().create(book);
        } catch (DaoException e) {
            throw new ServiceException("Cannot create this book.", e);
        }
    }

    public Book findById(int id) throws ServiceException {
        try {
            return DaoFactory.getInstance().getBookDao().findById(id);
        } catch (DaoException e) {
            throw new ServiceException("Cannot find this book.", e);
        }
    }

    public Book update(Book book) throws ServiceException {
        try {
            new ServiceValidator().validateBook(book);
            return DaoFactory.getInstance().getBookDao().update(book);
        } catch (DaoException e) {
            throw new ServiceException("Cannot update this book.", e);
        }
    }

    public Book updateTitle(String oldTitle, String newTitle) throws ServiceException {
        try {
            BookDao bookDao = DaoFactory.getInstance().getBookDao();
            Book book = bookDao.findByTitle(oldTitle);
            if (book != null) {
                book.setTitle(newTitle);
                return bookDao.update(book);
            } else {
                throw new ServiceException("No book with `" + oldTitle + "` title.");
            }

        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteById(int id) throws ServiceException {
        try {
            DaoFactory.getInstance().getBookDao().deleteById(id);
        } catch (DaoException e) {
            throw new ServiceException("Cannot delete this book.", e);
        }
    }

    public Book findByTitle(String title) throws ServiceException {
        try {
            return DaoFactory.getInstance().getBookDao().findByTitle(title);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Book> findAll() throws ServiceException {
        try {
            return DaoFactory.getInstance().getBookDao().findAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
