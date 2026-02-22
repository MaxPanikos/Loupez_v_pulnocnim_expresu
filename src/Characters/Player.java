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

    /**
     * checks the inventory of the player and return position of the searched item
     * @param item searched item
     * @return position of item in inventory or null if there is not this item
     */
    public Integer checkInventory (Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].equals(item)) {
                return i;
            }
        }
        return null;
    }

    /**
     * gives Item class from ID in inventory
     * @param ID of the item
     * @return searched Item or null if there is not this item
     */
    public Item getInventoryItem (String ID) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null && inventory[i].getID().equals(ID)) {
                return inventory[i];
            }
        }
        return null;
    }

    /**
     * grabs Item from room and put it into inventory
     * @param item you want to pick up
     * @return true if the grab went well
     */
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

    /**
     * takes Item from the inventory and put it in room where the player is
     * @param item you want to throw away
     * @return true if the thrown away went successfully
     */
    public boolean throwAwayItem (Item item) {
        Integer check = checkInventory(item);
        if (check != null) {
            inventory[check] = null;
            currentRoom.getItems().put(item.getID(), item);
            return true;
        }
        return false;
    }

    /**
     * removes item from inventory
     * @param item you want to remove
     * @return true if it was deleted
     */
    public boolean removeItem (Item item) {
        Integer check = checkInventory(item);
        if (check != null) {
            inventory[check] = null;
            return true;
        }
        return false;
    }


    /**
     * moves player throughout the rooms
     * @param newRoom room where you want to move
     * @return true if the moving went well
     * @throws Exception if there is an error while moving or before moving
     */
    public boolean move (Room newRoom) throws Exception{
        if (currentRoom.getRooms().containsKey(newRoom.getID())) {
            if (newRoom.isLocked()) {
                throw new Exception("Mistnost potrebujete nejprve odemknout predmetem (" + newRoom.getUnlocks().getName() + ")!");
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

    /**
     * gives String of the players inventory
     * @return String
     */
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

    public ArrayList<String> inventoryToStringList () {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                list.add(inventory[i].getID());
            }
        }
        return list;
    }
}
