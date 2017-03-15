package com.epam.library.dao;

import com.epam.library.domain.Book;
import com.epam.library.exception.DAOException;

import java.sql.*;

import static com.epam.library.database.query.SQLBookQuery.*;

public class BookDAO extends AbstractDAO<Book> {
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String PUBLISH_YEAR = "publish_year";
    private static final String AUTHOR = "author";

    public BookDAO(Connection connection) {
        super(connection);
    }

    public Book create(Book book) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_BOOK, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getYear());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.executeUpdate();

            //getting the autogenerated id
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                book.setId(generatedKeys.getInt(1));
            }
            return book;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public Book findById(int id) throws DAOException {
        Book book = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BOOK_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book = createBookFromResultSet(resultSet);
            }
            return book;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public Book update(Book book) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_BOOK)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setInt(2, book.getId());
            preparedStatement.executeUpdate();
            return book;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public void deleteById(int id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_BOOK)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public Book findByTitle(String title) throws DAOException {
        Book book = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BOOK_BY_TITLE)) {
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book = createBookFromResultSet(resultSet);
            }
            return book;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private Book createBookFromResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt(ID));
        book.setTitle(resultSet.getString(TITLE));
        book.setYear(resultSet.getInt(PUBLISH_YEAR));
        book.setAuthor(resultSet.getString(AUTHOR));
        return book;
    }
}
