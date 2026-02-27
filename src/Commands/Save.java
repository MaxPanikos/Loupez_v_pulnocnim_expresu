package Commands;

import FileManagerHelper.FileManager;
import Main.World;


public class Save implements Command {
    private World world;
    private String fileName;

    public Save(World world, String filename) {
        this.world = world;
        this.fileName = filename;
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public String text() {
        return "";
    }

    @Override
    public String execute(String command) throws Exception {
        FileManager.saveLastGame(world, fileName);
        return "Hra byla ulozena.";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return " - Ulozi hru, ktera je nyni rozehrana.";
    }
}
