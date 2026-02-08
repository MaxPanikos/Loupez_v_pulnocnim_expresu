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
    public String text() {
        return "";
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public boolean nextScanner() {
        return false;
    }

    @Override
    public String toString() {
        return "Opustit hru: konec";
    }
}
