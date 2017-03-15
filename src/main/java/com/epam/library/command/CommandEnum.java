package com.epam.library.command;

public enum CommandEnum {

    EMPLOYEE_REPORT_1 {
        {
            command = new EmployeeReport1Command();
        }
    },
    EMPLOYEE_REPORT_2 {
        {
            command = new EmployeeReport2Command();
        }
    },
    CHANGE_BOOK_TITLE {
        {
            command = new ChangeBookTitleCommand();
        }
    };
    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
