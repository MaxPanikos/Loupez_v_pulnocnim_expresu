package Commands;

import Main.Console;

public class LoadGame implements Command {
    private Console c;

    public LoadGame(Console c) {
        this.c = c;
    }

    @Override
    public boolean hasText() {
        return true;
    }

    @Override
    public String text() throws Exception {
        return "";
    }

    @Override
    public String execute(String command) throws Exception {
        return "";
    }

    @Override
    public boolean nextScanner() {
        return true;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
