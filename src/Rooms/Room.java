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
    private ArrayList<String> rooms;

    public Room(String ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.npcs = new HashMap<>();
        this.items = new HashMap<>();
        this.rooms = new ArrayList<>();
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
            npcs.put(npc.getName(), npc);
            npc.setCurrentRoomID(this);
            return true;
        }
        return false;
    }

    public boolean removeNPC(NPC npc) {
        if (npcs.containsKey(npc.getID())) {
            npcs.remove(npc.getName());
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

    public ArrayList<String> getRooms() {
        return rooms;
    }
}
