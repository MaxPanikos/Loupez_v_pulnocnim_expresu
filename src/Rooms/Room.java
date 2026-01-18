package Rooms;

import Items.Item;
import Characters.Character;

import java.util.HashMap;

public abstract class Room {
    protected String name;
    protected HashMap<String, Character> characters;
    protected HashMap<String, Item> items;
    protected HashMap<String, Room> rooms;

    public Room() {
        this.name = "Room";
        this.characters = new HashMap<>();
        this.items = new HashMap<>();
        this.rooms = new HashMap<>();
    }

    public String text () {
        return "";
    }

    public boolean addCharacter(Character character) {
        if (!characters.containsKey(character.getName()) && character.getCurrentRoom().getRooms().containsKey(name)) {
            characters.put(character.getName(), character);
            return true;
        }
        return false;
    }

    public boolean removeCharacter(Character character) {
        if (characters.containsKey(character.getName())) {
            characters.remove(character.getName());
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Character> getCharacters() {
        return characters;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }
}
