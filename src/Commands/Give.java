package Commands;

import Characters.NPC;
import Items.Item;
import Main.World;

public class Give implements Command {
    private World world;

    public Give(World world) {
        this.world = world;
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public String text() {
        return "";
    }

    @Override
    public String execute(String command) throws Exception {
        String[] splitedCommand = command.split(" ");
        NPC npc = world.getPlayer().getCurrentRoom().getNpcs().get(splitedCommand[0]);
        if (npc != null) {
            Item item = world.getPlayer().getInventoryItem(splitedCommand[1]);
            if (item != null) {
                world.getPlayer().removeItem(item);
                npc.setWasItemGiven(true);
                this.world.setMinutesLeft(this.world.getMinutesLeft() - 1);
                return "Postava si vzala predmet " + item.getName();
            }
            throw new Exception("Nemate tuto vec v inventari!");
        }
        throw new Exception("Tato postava se zde nenachazi!");
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Dat predmet postave: dej <npc> <item>";
    }
}
