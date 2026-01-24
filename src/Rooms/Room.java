package Rooms;

import Characters.NPC;
import Items.Item;
import Characters.Character;

import java.util.HashMap;

public abstract class Room {
    protected String name;
    protected HashMap<String, NPC> characters;
    protected HashMap<String, Item> items;
    protected HashMap<String, Room> rooms;

    public Room(String name) {
        this.name = name;
        this.characters = new HashMap<>();
        this.items = new HashMap<>();
        this.rooms = new HashMap<>();
    }

    public abstract String text ();

    public boolean addNPC(NPC npc) {
        if (!characters.containsKey(npc.getName()) && npc.getCurrentRoom().getRooms().containsKey(name)) {
            characters.put(npc.getName(), npc);
            return true;
        }
        return false;
    }

    public boolean removeNPC(NPC npc) {
        if (characters.containsKey(npc.getName())) {
            characters.remove(npc.getName());
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, NPC> getCharacters() {
        return characters;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }
}
