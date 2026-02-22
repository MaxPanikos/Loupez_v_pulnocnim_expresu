package Rooms;

import Characters.NPC;
import Items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String ID;
    private String name;
    private String description;
    private HashMap<String, NPC> npcs;
    private HashMap<String, Item> items;
    private HashMap<String, Room> rooms;
    private Item unlocks;
    private boolean locked;

    public Room(String ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.npcs = new HashMap<>();
        this.items = new HashMap<>();
        this.rooms = new HashMap<>();
        this.unlocks = null;
        this.locked = false;
    }


    /**
     * gives you basic info about the room
     * @return String
     */
    public String text () {
        String head = "Jsi v mistnostni " + name + "\n" + description;
        String npcsString = "Lide v mistnosti: ";
        if (npcs.isEmpty()) {
            npcsString += "Zadni lide.";
        } else {
            int i = 0;
            for (NPC npc : npcs.values()) {
                if (i == npcs.size()-1) {
                    npcsString += npc.getName() + " (" + npc.getID() + ")";
                } else {
                    npcsString += npc.getName() + " (" + npc.getID() + "), ";
                    i++;
                }
            }
        }
        String roomRooms = "Z teto mistnosti muzete do (" + rooms.size() + "): ";
        int i = 0;
        for (Room room : rooms.values()) {
            if (i == rooms.size()-1) {
                roomRooms += room.getName() + " (" + room.getID() + ")";
            } else {
                roomRooms += room.getName() + " (" + room.getID() + "), ";
                i++;
            }
        }

        return head + "\n" + npcsString + "\n" + roomRooms;
    }

    /**
     * method that adds NPC to room
     * @param npc you want to add
     * @return true if the add was successful
     */
    public boolean addNPC(NPC npc) {
        if (!npcs.containsKey(npc.getID()) && npc.getCurrentRoom().getRooms().containsKey(npc.getID())) {
            npcs.put(npc.getID(), npc);
            npc.setCurrentRoom(this);
            return true;
        }
        return false;
    }

    /**
     * removes npc from the room
     * @param npc you want to remove
     * @return true if the remove was successful
     */
    public boolean removeNPC(NPC npc) {
        if (npcs.containsKey(npc.getID())) {
            npcs.remove(npc.getID());
            return true;
        }
        return false;
    }

    /**
     * spawns npc only at the start of the game
     * @param npc you want to spawn
     * @return true if the spawn was successful
     */
    public boolean spawnNPC (NPC npc) {
        if (!npcs.containsKey(npc.getID())) {
            npcs.put(npc.getID(), npc);
            return true;
        }
        return false;
    }

    public Item getUnlocks() {
        return unlocks;
    }

    public void setUnlocks(Item unlocks) {
        this.unlocks = unlocks;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, NPC> getNpcs() {
        return npcs;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    public void setNpcs(HashMap<String, NPC> npcs) {
        this.npcs = npcs;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }

    public void setRooms(HashMap<String, Room> rooms) {
        this.rooms = rooms;
    }


    public boolean addItem(Item item) {
        if (!items.containsKey(item.getID())) {
            items.put(item.getID(), item);
            return true;
        }
        return false;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return description + " " + npcs;
    }
}
