import Characters.NPC;
import Characters.Player;
import Commands.*;
import Rooms.Room;

import java.io.File;
import java.util.HashMap;

public class Console {
    private int roundCount;
    private Player player;
    private HashMap<String, Room> rooms;
    private HashMap<String, Command> commands;

    public Console() {
        this.roundCount = 0;
        FileManager fm = FileManager.loadData("GameData.json");
        if (fm != null) {
            this.rooms = fm.getRooms();
            this.player = new Player(rooms.get("sluzebni oddil"));
        } else {
            System.err.println("Chyba pri nacitani souboru!");
            this.rooms = new HashMap<>();
            return;
        }
        this.commands = new HashMap<>();
        this.commands.put("zeptat", new Ask());
        this.commands.put("exit", new Exit());
        this.commands.put("prohledat", new Explore());
        this.commands.put("pomoc", new Help());
        this.commands.put("pouzit", new Use());
        this.commands.put("obvinit", new Accuse());
    }

    public void play () {
    }
}
