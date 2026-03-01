package Commands;

import Main.Colors;

import java.util.HashMap;
import java.util.Map;

public class Help implements Command {
    private HashMap<String, Command> commands;
    public Help(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String execute(String command) {
        StringBuilder str = new StringBuilder();
        str.append(Colors.BRIGHTBLUE + "Vsechny prikazy " + Colors.RESET + "(do <> napiste vzdy " + Colors.CYAN + Colors.UNDERLINE + "modre vyznacene ID" + Colors.RESET + ")" + Colors.BRIGHTBLUE + ": " + Colors.RESET + '\n');
        int i = 0;
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            str.append(Colors.BLUE + entry.getKey() + Colors.RESET + entry.getValue());
            i++;
            if (i < commands.size()) {
                str.append('\n');
            }
        }
        return str.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String text() {
        return "";
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public String toString() {
        return " - Zavola prikaz, ktery vypise vsechny prikazy.";
    }
}
