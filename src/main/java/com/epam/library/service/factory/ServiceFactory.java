package com.epam.library.service.factory;

import com.epam.library.service.BookService;
import com.epam.library.service.EmployeeService;
import com.epam.library.service.impl.BookServiceImpl;
import com.epam.library.service.impl.EmployeeServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();
    private BookService bookService = new BookServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public BookService getBookService() {
        return bookService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }
}
