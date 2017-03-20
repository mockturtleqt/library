package com.epam.library.command.impl.employee;

import com.epam.library.command.Command;
import com.epam.library.domain.Employee;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeBirthdayBookReportCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            employeeList = ServiceFactory.getInstance().getEmployeeService().findEmployeeBirthdayBookInfo();

        } catch (ServiceException e) {
            logger.error(e);
        }
        return employeeList
                .stream()
                .map(Employee::getNameBirthdayAndBookNumber)
                .collect(Collectors.joining("\n"));
    }
}
