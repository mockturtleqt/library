package com.epam.library.service;

import com.epam.library.dao.EmployeeDAO;
import com.epam.library.database.ConnectionPool;
import com.epam.library.entity.Employee;
import com.epam.library.exception.DAOException;
import com.epam.library.exception.ServiceException;

import java.util.List;

public class EmployeeService extends AbstractService<Employee> {
    private EmployeeDAO employeeDAO = new EmployeeDAO(ConnectionPool.getInstance().getConnection());

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

    public List<Employee> findEmployeeBookStatistics() throws ServiceException {
        try {
            return employeeDAO.findEmployeeBookStatistics();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Employee> findEmployeeBirthdayBookStatistics() throws ServiceException {
        try {
            return employeeDAO.findEmployeeBirthdayBookStatistics();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
