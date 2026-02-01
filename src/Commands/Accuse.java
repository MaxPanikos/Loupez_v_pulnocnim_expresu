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
    public String execute(String command) throws Exception{
        command = command.trim().toLowerCase();
        NPC npc = world.getPlayer().getCurrentRoom().getNpcs().get(command);
        if (npc != null) {
            return npc.accuse();
        }
        throw new Exception("Tato osoba se nenachazi v teto mistnosti!");
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Obvinit: obvin <jmeno npc>";
    }
}
