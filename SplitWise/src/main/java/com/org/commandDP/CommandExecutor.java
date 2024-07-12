package com.org.commandDP;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandExecutor {

    private List<Command> commandList = new ArrayList<Command>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void removeCommand(Command command) {
        commandList.remove(command);
    }

    public void execute(String input) {
        commandList.stream().filter(c -> c.match(input)).forEach(
                c -> c.execute(input)
        );
    }
}
