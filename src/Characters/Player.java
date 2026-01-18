package Characters;

import Items.Item;
import Rooms.Hall;
import Rooms.Room;

public class Player{
    private Item[] inventory;
    private Room currentRoom;

    public Player(Room startingRoom){
        inventory = new Item[2];
        currentRoom = startingRoom;
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
        if (currentRoom.getItems().containsKey(item.name) && unusedPockets() > 0) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    currentRoom.getItems().remove(item.name);
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
            currentRoom.getItems().put(item.name, item);
            return true;
        }
        return false;
    }
}
