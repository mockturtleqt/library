package com.epam.library.service;

import com.epam.library.domain.Employee;
import com.epam.library.service.exception.ServiceException;

import java.util.List;

public abstract class EmployeeService {

    public abstract Employee create(Employee employee) throws ServiceException;

    public abstract Employee findById(int id) throws ServiceException;

    public abstract Employee update(Employee employee) throws ServiceException;

    public abstract void deleteById(int id) throws ServiceException;

    public abstract List<Employee> findEmployeeBookInfo() throws ServiceException;

    public abstract List<Employee> findEmployeeBirthdayBookInfo() throws ServiceException;
}
