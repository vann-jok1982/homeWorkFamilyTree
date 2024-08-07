package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public  abstract class Commands {
    private ConsoleUI consoleUI;
    private String description;

    public Commands(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
    }
    abstract void execute();

    public String getDescription() {
        return description;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
