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

    public Room(String ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.npcs = new HashMap<>();
        this.items = new HashMap<>();
        this.rooms = new HashMap<>();
    }

    public String text () {
        String head = "Jsi v mistnostni " + name + "\n" + description;
        String npcsString;
        if (npcs.isEmpty()) {
            npcsString = "Zadni lide.";
        } else {
            npcsString = npcs.toString();
        }
        String roomItems;
        if (items.isEmpty()) {
            roomItems = "Zadne predmety k sebrani.";
        } else {
            roomItems = items.toString();
        }
        String roomRooms = "Z teto mistnosti muzeto do: " + rooms;

        return head + "\n" + npcsString + "\n" + roomItems + "\n" + roomRooms;
    }

    public boolean addNPC(NPC npc) {
        if (!npcs.containsKey(npc.getID()) && npc.getCurrentRoomID().getRooms().contains(npc.getID())) {
            npcs.put(npc.getID(), npc);
            npc.setCurrentRoomID(this);
            return true;
        }
        return false;
    }

    public boolean removeNPC(NPC npc) {
        if (npcs.containsKey(npc.getID())) {
            npcs.remove(npc.getID());
            return true;
        }
        return false;
    }

    public boolean spawnNPC (NPC npc) {
        if (!npcs.containsKey(npc.getID())) {
            npcs.put(npc.getID(), npc);
            return true;
        }
        return false;
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
        if (!items.containsKey(item.getName())) {
            items.put(item.getName(), item);
            return true;
        }
        return false;
    }
}
