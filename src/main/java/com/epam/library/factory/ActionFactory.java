package com.epam.library.factory;

import com.epam.library.command.Command;
import com.epam.library.command.CommandEnum;
import com.epam.library.command.EmptyCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionFactory {
    private static Logger logger = LogManager.getLogger();

    public Command defineCommand(String userCommand) {
        Command command = new EmptyCommand();
        try {
            if (!userCommand.isEmpty()) {
                command = CommandEnum.valueOf(userCommand.toUpperCase()).getCurrentCommand();
            }
        } catch (IllegalArgumentException e) {
            logger.log(Level.ERROR, e);
        }
        return command;
    }
}
