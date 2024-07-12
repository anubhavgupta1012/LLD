package com.org.commandDP;

public interface Command {

    public void execute(String input);

    public boolean match(String input);
}
