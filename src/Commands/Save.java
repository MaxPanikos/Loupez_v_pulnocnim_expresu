package Commands;

import FileManagerHelper.FileManager;
import Main.World;

import java.io.File;

public class Save implements Command {
    private World world;

    public Save(World world) {
        this.world = world;
    }

    @Override
    public String execute(String command) throws Exception {
        FileManager.save(world, "saves.csv");
        return "Hra se ulozila.";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String text() {
        return "Hra se uklada...";
    }

    @Override
    public boolean hasText() {
        return true;
    }

    @Override
    public boolean nextScanner() {
        return false;
    }

    @Override
    public String toString() {
        return "Ulozit hru: ulozit";
    }
}
