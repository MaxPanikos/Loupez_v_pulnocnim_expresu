package Characters;

import Rooms.Room;

import java.util.ArrayList;
import java.util.Collections;

public class Thief extends NPC{
    private ArrayList<String> proofs;
    public Thief(String ID, String name, int age, Room currentRoom, ArrayList<String> proofs) {
        super(ID, name, age, currentRoom);
        this.proofs = proofs;
    }

    public boolean accuseTest (ArrayList<String> playerProofs) {
        if (compareLists(proofs, playerProofs)) {
            return true;
        }
        return false;
    }

    private boolean compareLists (ArrayList<String> list1, ArrayList<String> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        ArrayList copy1 = new ArrayList(list1);
        ArrayList copy2 = new ArrayList(list2);
        Collections.sort(list1);
        Collections.sort(list2);
        return copy1.equals(copy2);
    }
}
