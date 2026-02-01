package Characters;

import Items.Item;
import Rooms.Room;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Character{
    private Item[] inventory;
    private ArrayList<String> proofs;

    public Player(Room startingRoom){
        super(startingRoom);
        this.inventory = new Item[2];
        this.proofs = new ArrayList<>();
    }

    private int unusedPockets () {
        int pocketsLeft = inventory.length;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                pocketsLeft--;
            }
        }
        return pocketsLeft;
    }

    public Integer checkInventory (Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(item)) {
                return i;
            }
        }
        return null;
    }

    public boolean grabItem (Item item) {
        if (currentRoom.getItems().containsKey(item.getName()) && unusedPockets() > 0) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    currentRoom.getItems().remove(item.getName());
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean throwAwayItem (Item item) {
        Integer check = checkInventory(item);
        if (check != null) {
            inventory[check] = null;
            currentRoom.getItems().put(item.getName(), item);
            return true;
        }
        return false;
    }

    public boolean move (Room newRoom) {
        if (currentRoom.getRooms().containsKey(newRoom.getID())) {
            currentRoom = newRoom;
            return true;
        }
        return false;
    }

    public ArrayList<String> getProofs() {
        return proofs;
    }

    @Override
    public String toString() {
        return "Player{" +
                "inventory=" + Arrays.toString(inventory) +
                ", currentRoom=" + currentRoom +
                '}';
    }
}
