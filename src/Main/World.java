package Main;

import Characters.Player;
import Rooms.Room;

import java.io.Serializable;
import java.util.HashMap;

public class World implements Serializable {
    private HashMap<String, Room> rooms;
    private Player player;
    private boolean gameOver;
    private int minutesLeft;
    private String prologue;

    public World() {
        this.rooms = new HashMap<>();
        this.player = new Player(null, 1);
        this.gameOver = false;
        this.minutesLeft = 0;
        this.prologue = "";
    }

    public World(HashMap<String, Room> rooms, Player player, int minutesLeft, String prologue) {
        this.rooms = rooms;
        this.player = player;
        this.minutesLeft = minutesLeft;
        this.gameOver = false;
        this.prologue = prologue;
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

    public String getPrologue() {
        return prologue;
    }
}
