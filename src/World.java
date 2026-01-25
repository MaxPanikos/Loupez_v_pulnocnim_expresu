import Characters.Player;
import Rooms.Room;

import java.util.HashMap;

public class World {
    private Player player;
    private HashMap<String, Room> rooms;

    public World() {
        this.rooms = new HashMap<>();
        this.player = null;
    }

    public Room getRoom(String roomName) {
        return this.rooms.get(roomName);
    }
}

