import Characters.Player;
import Items.Item;
import Rooms.Room;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.player = new Player(new Room("nazev", "jmeno", "nic"), 2);
    }

    @org.junit.jupiter.api.Test
    void checkInventory() {
        Item item = new Item("item", "jmeno", "nic");
        player.grabItem(item);
        assertEquals(player.checkInventory(item), 0);
    }

    @org.junit.jupiter.api.Test
    void getInventoryItem() {
        Item item = new Item("item", "jmeno", "nic");
        player.grabItem(item);
        assertEquals(item, "item");
    }

    @org.junit.jupiter.api.Test
    void grabItem() {
        Item item = new Item("item", "jmeno", "nic");
        player.grabItem(item);
        assertEquals(item, player.getInventoryItem("item"));
    }

    @org.junit.jupiter.api.Test
    void throwAwayItem() {
        Item item = new Item("item", "jmeno", "nic");
        player.grabItem(item);
        player.throwAwayItem(item);
        assertFalse(player.getCurrentRoom().getItems().containsKey("item"));
    }

    @org.junit.jupiter.api.Test
    void removeItem() {
        Item item = new Item("item", "jmeno", "nic");
        player.grabItem(item);
        player.removeItem(item);
        assertEquals(player.getInventoryItem("item"), null);
    }

    @org.junit.jupiter.api.Test
    void move() {
        Room newRoom = new Room("room2", "druha mistnost", "nic");
        HashMap<String, Room> rooms = new HashMap<>();
        rooms.put("room2", newRoom);
        player.getCurrentRoom().setRooms(rooms);
        try {
            player.move(newRoom);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(player.getCurrentRoom(), newRoom);
    }
}