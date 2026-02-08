package Commands;

public interface Command {
    boolean hasText();
    String text() throws Exception;
    boolean nextScanner();
    String execute(String command) throws Exception;
    boolean exit();
}
