package com.epam.library.command;

public class EmptyCommand implements Command {
    public String execute() {
        return "Unknown command";
    }
}
