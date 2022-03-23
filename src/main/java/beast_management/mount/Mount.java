package beast_management.mount;

import beast_management.Beast;
import beast_management.BeastType;

public class Mount extends Beast {

    private int ATK;
    private int DEF;

    public Mount(BeastType type, int ATK, int DEF) {
        super(type);
        this.ATK = ATK;
        this.DEF = DEF;
    }
}
