package beast_management.enemy;

import beast_management.Beast;
import beast_management.BeastType;

public class Enemy extends Beast {

    private int HP;
    private int STR;
    private int GOLD;

    public Enemy(BeastType type, int HP, int STR, int GOLD) {
        super(type);
        this.HP = HP;
        this.STR = STR;
        this.GOLD = GOLD;
    }
}
