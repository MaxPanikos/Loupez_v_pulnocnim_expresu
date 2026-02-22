package Commands;

public interface Command {
    /**
     * method that tells you if the command have prepared text
     * @return true if yes
     */
    boolean hasText();

    /**
     * the actual text
     * @return String of text
     */
    String text();

    /**
     * main executing method of command
     * @param command user input
     * @return String
     * @throws Exception if there is an error
     */
    String execute(String command) throws Exception;

    /**
     * return if the program have to end
     * @return true if its end
     */
    boolean exit();
}
