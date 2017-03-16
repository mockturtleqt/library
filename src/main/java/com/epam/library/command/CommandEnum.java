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
    RENAME_BOOK {
        {
            command = new RenameBookCommand();
        }
    },
    CREATE_BOOK {
        {
            command = new CreateBookCommand();
        }
    },
    FIND_BOOK_BY_TITLE {
        {
            command = new FindBookByTitleCommand();
        }
    },
    FIND_BOOK_BY_ID {
        {
            command = new FindBookByIdCommand();
        }
    },
    FIND_ALL_BOOKS {
        {
            command = new FindAllBooksCommand();
        }
    },
    DELETE_BOOK {
        {
            command = new DeleteBookByIdCommand();
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
