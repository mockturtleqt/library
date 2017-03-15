package com.epam.library.command;

public enum CommandEnum {

    REPORT_1 {
        {
            command = new EmployeeBookReportCommand();
        }
    },
    REPORT_2 {
        {
            command = new EmployeeBirthdayBookReportCommand();
        }
    },
    CHANGE_BOOK_TITLE {
        {
            command = new ChangeBookTitleCommand();
        }
    },
    EXIT {
        {
            command = new ExitCommand();
        }
    };
    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}
