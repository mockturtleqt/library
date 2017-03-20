package com.epam.library.dao;

import com.epam.library.dao.exception.DaoException;
import com.epam.library.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee create(Employee employee) throws DaoException;

    Employee findById(int id) throws DaoException;

    Employee update(Employee employee) throws DaoException;

    void deleteById(int id) throws DaoException;

    List<Employee> findEmployeeBookInfo() throws DaoException;

    List<Employee> findEmployeeBirthdayBookInfo() throws DaoException;
}
