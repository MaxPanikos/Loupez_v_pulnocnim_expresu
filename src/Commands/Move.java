package Commands;

import Main.World;
import Rooms.Room;

public class Move implements Command{
    private World world;

    public Move(World world) {
        this.world = world;
    }

    @Override
    public String execute(String command) throws Exception {
        Room room = world.getRooms().get(command);
        if (room != null) {
            world.getPlayer().move(room);
            return "Hrac byl presunut do " + room.getName();
        }
        throw new Exception("Tato mistnost neexistuje!");
    }

    @Override
    public boolean exit() {
        return false;
    }
}
