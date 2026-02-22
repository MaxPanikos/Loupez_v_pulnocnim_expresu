package Characters;

import Main.World;
import Rooms.Room;

import java.util.ArrayList;
import java.util.Collections;

public class Thief extends NPC{
    private ArrayList<String> proofs;
    private String afterCaughtDialogue;
    public Thief(String ID, String name, int age, Room currentRoom, ArrayList<String> proofs, String basicDialogue, String afterCaughtDialogue) {
        super(ID, name, age, currentRoom, basicDialogue);
        this.proofs = proofs;
        this.afterCaughtDialogue = afterCaughtDialogue;
    }

    public boolean accuseTest (ArrayList<String> playerProofs) {
        if (compareLists(proofs, playerProofs)) {
            return true;
        }
        return false;
    }

    @Override
    public String accuse (ArrayList<String> playerProofs) {
        if (compareLists(proofs, playerProofs)) {
            return afterCaughtDialogue;
        }
        return name + ": Nemate dukazy a ja to opravdu nejsem!";
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
