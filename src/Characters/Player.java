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

    public Item getInventoryItem (String ID) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].getID().equals(ID)) {
                return inventory[i];
            }
        }
        return null;
    }

    public boolean grabItem (Item item) {
        if (currentRoom.getItems().containsKey(item.getID())) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    currentRoom.getItems().remove(item.getID());
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
            currentRoom.getItems().put(item.getID(), item);
            return true;
        }
        return false;
    }

    public boolean removeItem (Item item) {
        Integer check = checkInventory(item);
        if (check != null) {
            inventory[check] = null;
            return true;
        }
        return false;
    }

    public boolean move (Room newRoom) throws Exception{
        if (currentRoom.getRooms().containsKey(newRoom.getID())) {
            if (newRoom.getUnlocks() != null && checkInventory(newRoom.getUnlocks()) == null) {
                throw new Exception("Nemate potrebny predmet ke vstupu do mistnosti (" + newRoom.getUnlocks().getName() + ")!");
            } else {
                currentRoom = newRoom;
                return true;
            }
        } else {
            throw new Exception("Do teto mistnosti se neda jit z mistnosti kde se nachazite!");
        }
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

    public String inventory () {
        String inventoryString = "Inventar: ";
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                inventoryString += i + ". - " + inventory[i].getID();
                if (i < inventory.length - 1) {
                    inventoryString += ", ";
                }
            } else {
                inventoryString += i + ". - nic";
                if (i < inventory.length - 1) {
                    inventoryString += ", ";
                }
            }
        }
        return inventoryString;
    }
}
