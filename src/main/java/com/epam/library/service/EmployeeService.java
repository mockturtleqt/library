package com.epam.library.service;

import com.epam.library.domain.Employee;
import com.epam.library.service.exception.ServiceException;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee) throws ServiceException;

    Employee findById(int id) throws ServiceException;

    Employee update(Employee employee) throws ServiceException;

    void deleteById(int id) throws ServiceException;

    List<Employee> findEmployeeBookInfo() throws ServiceException;

    List<Employee> findEmployeeBirthdayBookInfo() throws ServiceException;
}
