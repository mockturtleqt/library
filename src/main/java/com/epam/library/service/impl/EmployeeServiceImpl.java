package com.epam.library.service.impl;

import com.epam.library.dao.exception.DaoException;
import com.epam.library.dao.factory.DaoFactory;
import com.epam.library.domain.Employee;
import com.epam.library.service.EmployeeService;
import com.epam.library.service.exception.ServiceException;

import java.util.List;

public class EmployeeServiceImpl extends EmployeeService {
    public Employee create(Employee employee) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public Employee findById(int id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public Employee update(Employee employee) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public void deleteById(int id) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    public List<Employee> findEmployeeBookInfo() throws ServiceException {
        try {
            return DaoFactory.getInstance().getEmployeeDao().findEmployeeBookInfo();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Employee> findEmployeeBirthdayBookInfo() throws ServiceException {
        try {
            return DaoFactory.getInstance().getEmployeeDao().findEmployeeBirthdayBookInfo();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
