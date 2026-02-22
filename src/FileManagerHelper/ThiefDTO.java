package FileManagerHelper;

import java.util.ArrayList;
import java.util.List;

public class ThiefDTO extends NPCDTO{
    private List<String> proofs;
    private String afterCaughtDialogue;
    public ThiefDTO(String ID, String name, int age, String currentRoom, List<String> proofs, String basicDialogue, String afterCaughtDialogue) {
        super(ID, name, age, currentRoom, basicDialogue);
        this.proofs = proofs;
        this.afterCaughtDialogue = afterCaughtDialogue;
    }

    public List<String> getProofs() {
        return proofs;
    }

    public String getAfterCaughtDialogue() {
        return afterCaughtDialogue;
    }
}
