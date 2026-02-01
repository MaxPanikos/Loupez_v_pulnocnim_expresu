package Commands;

public class Exit implements Command {
    @Override
    public String execute(String command) {
        return "Program byl ukoncen.";
    }

    @Override
    public boolean exit() {
        return true;
    }

    @Override
    public String toString() {
        return "Opustit hru: konec";
    }
}
