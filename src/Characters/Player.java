package Characters;

import Items.Item;
import Rooms.Room;

public class Player extends Character{
    private Item[] inventory;

    public Player(Room startingRoom){
        super(startingRoom);
        inventory = new Item[2];
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
}
