import Characters.NPC;
import Characters.Player;
import Commands.Command;
import Items.Item;
import Rooms.Room;

import java.util.ArrayList;
import java.util.HashMap;

public class Console {
    private int roundCount;
    private HashMap<String, Command> commands;
    private World worldMap;

    public Console() {
        this.commands = new HashMap<>();
        roundCount = 0;
    }

    public void game () {}
}
