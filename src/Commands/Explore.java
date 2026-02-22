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
                        if (item.getOnlyIf() != null && world.getPlayer().checkInventory(item.getOnlyIf()) == null) {
                            roomItems += "potrebuju " + item.getOnlyIf().getName() + " abych si to mohl prohlednout...";
                        } else {
                            roomItems += item.getName() + " (" + item.getID() + ")";
                        }
                    } else {
                        if (item.getOnlyIf() != null && world.getPlayer().checkInventory(item.getOnlyIf()) == null) {
                            roomItems += "potrebuju " + item.getOnlyIf().getName() + " abych si to mohl prohlednout, ";
                        } else {
                            roomItems += item.getName() + " (" + item.getID() + "), ";
                        }
                        i++;
                    }
                }
            }
            this.world.setMinutesLeft(this.world.getMinutesLeft() - 2);
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
    public String text() {
        return "";
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public boolean nextScanner() {
        return false;
    }

    @Override
    public String toString() {
        return "Prohledat: prohledej";
    }
}
