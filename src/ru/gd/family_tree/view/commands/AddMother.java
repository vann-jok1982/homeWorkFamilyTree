package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class AddMother extends Commands{
    public AddMother(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить мать :");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addMother();
    }
}


