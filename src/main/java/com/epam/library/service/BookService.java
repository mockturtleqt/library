package com.epam.library.service;

import com.epam.library.dao.BookDAO;
import com.epam.library.database.ConnectionWrapper;
import com.epam.library.domain.Book;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;

import java.util.List;

public class BookService extends AbstractService<Book> {
    private BookDAO bookDAO = new BookDAO(ConnectionWrapper.getInstance().getConnection());

    public Book create(Book book) throws ServiceException {
        try {
            return bookDAO.create(book);
        } catch (DAOException e) {
            throw new ServiceException("Cannot create this book.", e);
        }
    }

    public Book findById(int id) throws ServiceException {
        try {
            return bookDAO.findById(id);
        } catch (DAOException e) {
            throw new ServiceException("Cannot find this book.", e);
        }
    }

    public Book update(Book book) throws ServiceException {
        try {
            return bookDAO.update(book);
        } catch (DAOException e) {
            throw new ServiceException("Cannot update this book.", e);
        }
    }

    public Book updateTitle(String oldTitle, String newTitle) throws ServiceException {
        try {
            Book book = bookDAO.findByTitle(oldTitle);
            if (book != null) {
                book.setTitle(newTitle);
                return bookDAO.update(book);
            } else {
                throw new ServiceException("No book with `" + oldTitle + "` title.");
            }

        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteById(int id) throws ServiceException {
        try {
            bookDAO.deleteById(id);
        } catch (DAOException e) {
            throw new ServiceException("Cannot delete this book.", e);
        }
    }

    public Book findByTitle(String title) throws ServiceException {
        try {
            return bookDAO.findByTitle(title);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Book> findAll() throws ServiceException {
        try {
            return bookDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
