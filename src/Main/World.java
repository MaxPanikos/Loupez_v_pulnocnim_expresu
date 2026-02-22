package Main;

import Characters.Player;
import Rooms.Room;

import java.util.HashMap;

public class World {
    private HashMap<String, Room> rooms;
    private Player player;
    private boolean gameOver;
    private int minutesLeft;

    public World() {
        this.rooms = new HashMap<>();
        this.player = new Player(null);
    }

    public World(HashMap<String, Room> rooms, Player player, int minutesLeft) {
        this.rooms = rooms;
        this.player = player;
        this.minutesLeft = minutesLeft;
        this.gameOver = false;
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

    public boolean isGameOver() {
        return gameOver;
    }

    public int getMinutesLeft() {
        return minutesLeft;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }
}
