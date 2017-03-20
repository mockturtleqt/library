package com.epam.library.dao.sql;

import com.epam.library.dao.EmployeeDao;
import com.epam.library.dao.exception.DaoException;
import com.epam.library.domain.Employee;

import java.sql.Connection;
import java.util.List;

public abstract class SqlEmployeeDao implements EmployeeDao {
    protected Connection connection;

    public SqlEmployeeDao() {
    }

    public SqlEmployeeDao(Connection connection) {
        this.connection = connection;
    }

    public abstract Employee create(Employee employee) throws DaoException;

    public abstract Employee findById(int id) throws DaoException;

    public abstract Employee update(Employee employee) throws DaoException;

    public abstract void deleteById(int id) throws DaoException;

    public abstract List<Employee> findEmployeeBookInfo() throws DaoException;

    public abstract List<Employee> findEmployeeBirthdayBookInfo() throws DaoException;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
