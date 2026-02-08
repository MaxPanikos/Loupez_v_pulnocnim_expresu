package Commands;

import Main.Console;

public class NewGame implements Command {
    private Console c;

    public NewGame(Console c) {
        this.c = c;
    }

    @Override
    public String execute(String command) throws Exception {
        c.game();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String text() {
        return "Hra se spousti...";
    }

    @Override
    public boolean hasText() {
        return true;
    }

    @Override
    public boolean nextScanner() {
        return false;
    }

    @Override
    public String toString() {
        return "Nova hra: nova hra";
    }
}
