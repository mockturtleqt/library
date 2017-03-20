package com.epam.library.dao.factory;

import com.epam.library.dao.BookDao;
import com.epam.library.dao.EmployeeDao;
import com.epam.library.dao.impl.BookDaoImpl;
import com.epam.library.dao.impl.EmployeeDaoImpl;
import com.epam.library.util.database.ConnectionWrapper;

import java.sql.Connection;

public class DaoFactory {
    private static final DaoFactory INSTANCE = new DaoFactory();

    private Connection connection = ConnectionWrapper.getInstance().getConnection();
    private BookDao bookDao = new BookDaoImpl(connection);
    private EmployeeDao employeeDao = new EmployeeDaoImpl(connection);

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return INSTANCE;
    }

    public BookDao getBookDao() {
        return bookDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }
}
