package FileManagerHelper;

import java.util.ArrayList;
import java.util.List;

public class ThiefDTO extends NPCDTO{
    private List<String> proofs;
    public ThiefDTO(String ID, String name, int age, String currentRoom, List<String> proofs) {
        super(ID, name, age, currentRoom);
        this.proofs = proofs;
    }

    public List<String> getProofs() {
        return proofs;
    }
}
