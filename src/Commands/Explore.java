package Commands;

import Items.Item;
import Main.World;

import java.util.HashMap;

public class Explore implements Command {
    private World world;

    public Explore(World world) {
        this.world = world;
    }

    @Override
    public String execute(String command) throws Exception{
        try {
            HashMap<String, Item> items = world.getPlayer().getCurrentRoom().getItems();
            String roomItems = "Predmety v mistnosti: ";
            if (items.isEmpty()) {
                roomItems += "Zadne predmety k sebrani.";
            } else {
                int i = 0;
                for (Item item : items.values()) {
                    if (i == items.size()-1) {
                        roomItems += item.getName() + " - " + item.getDescription();
                    } else {
                        roomItems += item.getName() + " - " + item.getDescription() + ", ";
                        i++;
                    }
                }
            }
            return roomItems;
        } catch (Exception e) {
            throw new Exception("Nastala neocekavana chyba!");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Prohledat: prohledej";
    }
}
