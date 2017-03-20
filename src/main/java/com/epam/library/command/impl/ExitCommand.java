package com.epam.library.command.impl;

import com.epam.library.command.Command;

public class ExitCommand implements Command {
    public String execute() {
        return "Bye!";
    }
}
