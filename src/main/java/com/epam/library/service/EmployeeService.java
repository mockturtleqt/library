package com.epam.library.service;

import com.epam.library.dao.EmployeeDAO;
import com.epam.library.database.ConnectionWrapper;
import com.epam.library.domain.Employee;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;

import java.util.List;

public class EmployeeService extends AbstractService<Employee> {
    private EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionWrapper.getInstance().getConnection());

    public Employee create(Employee employee) throws ServiceException {
        return null;
    }

    public Employee findById(int id) throws ServiceException {
        return null;
    }

    public Employee update(Employee employee) throws ServiceException {
        return null;
    }

    public void deleteById(int id) throws ServiceException {

    }

    public List<Employee> findEmployeeBookInfo() throws ServiceException {
        try {
            return employeeDAO.findEmployeeBookInfo();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Employee> findEmployeeBirthdayBookInfo() throws ServiceException {
        try {
            return employeeDAO.findEmployeeBirthdayBookInfo();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
