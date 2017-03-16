package com.epam.library.command;

import com.epam.library.domain.Employee;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class EmployeeBookReportCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = new EmployeeService().findEmployeeBookInfo();

        } catch (ServiceException e) {
            logger.error(e);
        }
        return employeeList
                .stream()
                .map(Employee::getNameAndBookNumber)
                .collect(Collectors.joining("\n"));
    }
}
