package Commands;

import Characters.NPC;
import Characters.Thief;
import Main.World;

public class Accuse implements Command {
    private World world;

    public Accuse(World world) {
        this.world = world;
    }

    @Override
    public String execute(String command) {
        NPC npc = world.getPlayer().getCurrentRoom().getNpcs().get(command);
        if (npc != null) {
            if (npc instanceof Thief) {
                if (((Thief) npc).accuseTest(world.getPlayer().getProofs())) {
                    return "";
                }
            }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
