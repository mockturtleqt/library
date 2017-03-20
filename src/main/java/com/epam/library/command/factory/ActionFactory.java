package com.epam.library.command.factory;

import com.epam.library.command.Command;
import com.epam.library.command.CommandEnum;
import com.epam.library.command.impl.EmptyCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActionFactory {
    private static final ActionFactory INSTANCE = new ActionFactory();

    private static Logger logger = LogManager.getLogger();

    private ActionFactory() {
    }

    public static ActionFactory getInstance() {
        return INSTANCE;
    }

    public Command defineCommand(String userCommand) {
        Command command = new EmptyCommand();
        try {
            if (!userCommand.isEmpty()) {
                command = CommandEnum.valueOf(userCommand.toUpperCase()).getCurrentCommand();
            }
        } catch (IllegalArgumentException e) {
            logger.error(e);
        }
        return command;
    }
}
