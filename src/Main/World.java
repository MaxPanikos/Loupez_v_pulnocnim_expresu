package Main;

import Characters.Player;
import Rooms.Room;

import java.util.HashMap;

public class World {
    private HashMap<String, Room> rooms;
    private Player player;

    public World() {
        this.rooms = new HashMap<>();
        this.player = new Player(null);
    }

    public World(HashMap<String, Room> rooms, Player player) {
        this.rooms = rooms;
        this.player = player;
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setStartingRoom (Room startingRoom) {
        this.player.setCurrentRoom(startingRoom);
    }
}
