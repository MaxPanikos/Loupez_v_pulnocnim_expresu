import Characters.NPC;
import Characters.Player;
import Commands.Command;
import Items.Item;
import Rooms.Room;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Console {
    private int roundCount;
    private HashMap<String, Command> commands;
    private HashMap<String, Room> rooms;
    private Player player;

    public Console() {
        this.commands = new HashMap<>();
        this.roundCount = 0;
        FileManager fileManager = FileManager.loadData("/gamedata.json");
        try {
            this.rooms = fileManager.getRoomMap();
        } catch (Exception e) {
            System.out.println("Nastala chyba pri nacitani souboru!");
        }
        System.out.println(rooms.size());
        System.out.println(rooms);
    }

    public void game () {}
}
