import Characters.NPC;
import Items.Item;
import Rooms.Room;
import com.google.gson.Gson;
import com.sun.tools.javac.Main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import FileManager.*;

/**
 * Represents the game data loaded from a JSON file.
 * This class serves as a data container for all static game content, such as items, characters, locations, and quests.
 *
 */
public class FileManager {

    private ArrayList<ItemDTO> items;
    private ArrayList<RoomDTO> rooms;
    private ArrayList<NPCDTO> npcs;

    /**
     * Loads game data from a JSON file.
     * @param resourcePath path to the resource file
     * @return a GameData object filled with the loaded data
     */
    public static FileManager loadData (String resourcePath) {
        //Vytvoření objektu pro práci s JSON souborem
        Gson gson = new Gson();

        //Načtení souboru gamedata.json, musí být ve složce res/resources, ta musí být označena jako resource složka projektu
        try (InputStream is = Main.class.getResourceAsStream(resourcePath)) {

            //Zde ověřujeme, zdali soubor existuje
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath +
                        " (zkontrolujte, že soubor je v src/main/resources).");
            }

            //Přečte celý JSON a vytvoří instanci GameData, naplní vlastnosti podle názvů klíčů v JSONU, vrátí se hotová třída GameData
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    FileManager.class
            );

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

    }

    public ArrayList<RoomDTO> getRooms() {
        return rooms;
    }

    public ArrayList<ItemDTO> getItems() {
        return items;
    }

    public ArrayList<NPCDTO> getNpcs() {
        return npcs;
    }

    /*
    public  Room findRoom (String name) {
        for (Room r : rooms) {
            if (r.getName().equals(name)){
                return r;
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s nazvem: " + name);
    }
     */

    public HashMap<String, Room> getRoomMap () throws Exception {
        try {
            HashMap<String, Room> roomsHashMap = new HashMap<>();
            for (RoomDTO room : rooms) {
                roomsHashMap.put(room.getID(), new Room(room.getID(), room.getName(), room.getDescription()));
            }
            for (ItemDTO item : items) {
                if (roomsHashMap.containsKey(item.getCurrentRoomID())) {
                    roomsHashMap.get(item.getCurrentRoomID()).addItem(new Item(item.getName(), item.getDescription()));
                }
            }
            for (NPCDTO npc : npcs) {
                if (roomsHashMap.containsKey(npc.getCurrentRoomID())) {
                    roomsHashMap.get(npc.getCurrentRoomID()).spawnNPC(new NPC(npc.getID(), npc.getName(), npc.getAge(), roomsHashMap.get(npc.getCurrentRoomID())));
                }
            }
            for (RoomDTO room : rooms) {
                ArrayList<String> exits = (ArrayList<String>)room.getExits();
                HashMap<String, Room> exitsHashMap = new HashMap<>();
                for (String exit : exits) {
                    if (roomsHashMap.containsKey(exit)) {
                        exitsHashMap.put(exit, roomsHashMap.get(exit));
                    }

                }
                roomsHashMap.get(room.getID()).setRooms(exitsHashMap);
            }
            return roomsHashMap;
        } catch (Exception e) {
            throw new Exception("Nacteni neprobehlo spravne!");
        }
    }
}

