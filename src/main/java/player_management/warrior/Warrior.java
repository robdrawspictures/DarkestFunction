package player_management.warrior;

import player_management.PlayerCharacter;
import resource_management.weapons.Weapon;

public class Warrior extends PlayerCharacter implements IAttack {

    private int STR;
    private int DEF;
    private Weapon weapon;

    public Warrior(String name, int HP, int AP, int gold, int STR, int DEF, Weapon weapon) {
        super(name, HP, AP, gold);
        this.STR = STR;
        this.DEF = DEF;
        this.weapon = weapon;
    }

    public void attack(Weapon weapon) {
    }
}
