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
        this.rooms = fm.getRooms();
    }

    public void game () {

    }
}
