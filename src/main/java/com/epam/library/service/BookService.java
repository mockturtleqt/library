package com.epam.library.service;

import com.epam.library.dao.BookDAO;
import com.epam.library.database.ConnectionPool;
import com.epam.library.entity.Book;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;

public class BookService extends AbstractService<Book> {
    private BookDAO bookDAO = new BookDAO(ConnectionPool.getInstance().getConnection());

    public Book create(Book book) throws ServiceException {
        try {
            return bookDAO.create(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Book findById(int id) throws ServiceException {
        return null;
    }

    public Book update(Book book) throws ServiceException {
        try {
            return bookDAO.update(book);
        } catch (DAOException e) {
            throw new ServiceException(e);
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

    }
}
