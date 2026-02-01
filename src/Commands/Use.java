package Commands;

public class Use implements Command {
    @Override
    public String execute(String command) {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Pouzit: pouzij <predmet v inventari>";
    }
}
