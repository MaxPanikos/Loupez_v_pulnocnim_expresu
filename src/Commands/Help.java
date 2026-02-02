package Commands;

import java.util.HashMap;

public class Help implements Command {
    private HashMap<String, Command> commands;
    public Help(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    @Override
    public String execute(String command) {
        StringBuilder str = new StringBuilder();
        str.append("Vsechny prikazy: ");
        int i = 0;
        for (Command c : commands.values()) {
            str.append(c);
            i++;
            if (i < commands.size()-1) {
                str.append(", ");
            }
        }
        return str.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Pomoc: pomoc";
    }
}
