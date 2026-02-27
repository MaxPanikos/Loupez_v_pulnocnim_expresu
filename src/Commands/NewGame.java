package Commands;

import FileManagerHelper.FileManager;
import Main.Console;
import Main.World;

public class NewGame implements Command {
    private Console c;
    private String fileName;

    public NewGame(Console c, String fileName) {
        this.c = c;
        this.fileName = fileName;
    }

    @Override
    public String execute(String command) throws Exception {
        FileManager fileManager = FileManager.loadData(fileName);
        try {
            World newWorld = fileManager.getRoomMap();
            c.setWorld(newWorld);
            System.out.println(c.getWorld().getRooms());
            System.out.println(c.getWorld() == null);
        } catch (Exception e) {
            System.err.println("Nastala chyba pri nacitani souboru!");
        }
        c.game();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String text() {
        return "Nova hra se spousti...";
    }

    @Override
    public boolean hasText() {
        return true;
    }

    @Override
    public String toString() {
        return " - Spusti novou hru.";
    }
}
