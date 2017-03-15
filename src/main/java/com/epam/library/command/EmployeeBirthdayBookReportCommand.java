package com.epam.library.command;

import com.epam.library.entity.Employee;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.EmployeeService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeBirthdayBookReportCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = employeeService.findEmployeeBirthdayBookInfo();

        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
        }
        return employeeList
                .stream()
                .map(Employee::getNameBirthdayAndBookNumber)
                .collect(Collectors.joining("\n"));
    }
}
