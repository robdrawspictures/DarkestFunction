package beast_management.enemy;

import beast_management.Beast;
import beast_management.BeastType;
import player_management.PlayerCharacter;

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

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getSTR() {
        return STR;
    }

    public int getGOLD() {
        return GOLD;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public void setGOLD(int GOLD) {
        this.GOLD = GOLD;
    }

    public void takeDMG(int DMG){
        this.HP -= DMG;
    }

    public void attack(PlayerCharacter target){
        target.takeDMG(getSTR());
    }
}
