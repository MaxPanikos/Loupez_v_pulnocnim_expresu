import Characters.NPC;
import Items.Item;
import Rooms.Room;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Represents the game data loaded from a JSON file.
 * This class serves as a data container for all static game content, such as items, characters, locations, and quests.
 *
 */
public class FileManager {

    private HashMap<String, NPC> npc;
    private HashMap<String, Room> rooms;

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

    public HashMap<String, NPC> getNpc() {
        return npc;
    }

    public HashMap<String, Room> getRooms() {
        return rooms;
    }

    /**
     * Finds a specific location by its identifier.
     * @param name the identifier of the location to be found
     * @return the matching location
     */
    public  Room findLocation(String name) {
        for (Room l : rooms.values()) {
            if (l.getName().equals(name)){
                return l;
            }
        }
        throw new IllegalArgumentException("Neexistuje lokace s nazvem: " + name);
    }
}

