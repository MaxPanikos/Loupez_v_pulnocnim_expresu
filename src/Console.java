import Characters.NPC;
import Characters.Player;
import Commands.Command;
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
        this.player = new Player(null);
        FileManager fm = FileManager.loadData("GameData.json");
        if (fm != null) {
            this.rooms = fm.getRooms();
        } else {
            System.err.println("Chyba pri nacitani souboru!");
            this.rooms = new HashMap<>();
        }
    }

    public void play () {

    }
}
