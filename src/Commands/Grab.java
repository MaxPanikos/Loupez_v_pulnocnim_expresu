package Commands;

import Items.Item;
import Main.World;

public class Grab implements Command {
    private World world;

    public Grab(World world) {
        this.world = world;
    }
    @Override
    public String execute(String command) throws Exception {
        Item item = world.getPlayer().getCurrentRoom().getItems().get(command);
        if (item != null) {
            if (world.getPlayer().grabItem(item)) {
                return "Predmet " +  item.getName() + " byl sebran a strcen do kapsy.";
            }
            throw new Exception("Predmet se nepodarilo sebrat!");
        }
        throw new Exception("Tento predmet se nenachazi v teto mistnosti!");
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Vzit: seber <item v mistnosti>";
    }
}
