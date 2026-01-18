import Characters.NPC;
import Characters.Player;
import Commands.Command;
import Rooms.Room;

import java.util.HashMap;

public class Console {
    private int roundCount;
    private Player player;
    private HashMap<String, Room> rooms;
    private HashMap<String, Command> commands;
    private HashMap<String, NPC> npcs;

    public Console() {
        roundCount = 0;
        player = new Player(null);
    }

    public void setup () {

    }

    public void game () {}
}
