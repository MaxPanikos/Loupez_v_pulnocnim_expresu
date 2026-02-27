package Commands;

import FileManagerHelper.FileManager;
import Main.Console;
import Main.World;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class LoadGame implements Command{
    private Console c;
    private String fileName;

    public LoadGame(Console c, String fileName) {
        this.c = c;
        this.fileName = fileName;
    }

    @Override
    public boolean hasText() {
        return true;
    }

    @Override
    public String text() {
        return "Nactena hra se spousti...";
    }

    @Override
    public String execute(String command) throws Exception {
        World newWorld = FileManager.loadLastGame(fileName);
        c.setWorld(newWorld);
        c.game();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return " - Nacte a spusti posledni ulozenou hru.";
    }
}
