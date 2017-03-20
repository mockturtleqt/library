package com.epam.library.dao.impl;

import com.epam.library.dao.exception.DaoException;
import com.epam.library.dao.sql.SqlEmployeeDao;
import com.epam.library.domain.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.epam.library.util.database.query.SQLEmployeeQuery.SQL_SELECT_EMPLOYEE_BIRTHDAY_BOOK_STATISTICS;
import static com.epam.library.util.database.query.SQLEmployeeQuery.SQL_SELECT_EMPLOYEE_BOOK_STATISTICS;

public class EmployeeDaoImpl extends SqlEmployeeDao {
    private static final String NAME = "name";
    private static final String NUMBER_OF_BOOKS = "number_of_books";
    private static final String DATE_OF_BIRTH = "date_of_birth";

    public EmployeeDaoImpl(Connection connection) {
        super(connection);
    }

    public Employee create(Employee employee) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public Employee findById(int id) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public Employee update(Employee employee) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public void deleteById(int id) throws DaoException {
        throw new UnsupportedOperationException();
    }

    public List<Employee> findEmployeeBookInfo() throws DaoException {
        List<Employee> employeeList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_EMPLOYEE_BOOK_STATISTICS);
            while (resultSet.next()) {
                employeeList.add(createEmployeeFromResultSet(resultSet));
            }
            return employeeList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public List<Employee> findEmployeeBirthdayBookInfo() throws DaoException {
        List<Employee> employeeList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_EMPLOYEE_BIRTHDAY_BOOK_STATISTICS);
            while (resultSet.next()) {
                employeeList.add(createEmployeeFromResultSet(resultSet));
            }
            return employeeList;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private Employee createEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setName(resultSet.getString(NAME));

        Date date = resultSet.getDate(DATE_OF_BIRTH);
        LocalDate localDate = (date != null) ? date.toLocalDate() : null;
        employee.setBirthday(localDate);

        employee.setNumberOfBooks(resultSet.getInt(NUMBER_OF_BOOKS));
        return employee;
    }
}
