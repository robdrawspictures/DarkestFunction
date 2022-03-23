package player_management.warrior;

import beast_management.enemy.Enemy;
import player_management.PlayerCharacter;
import resource_management.weapons.Weapon;

public class Warrior extends PlayerCharacter implements IAttack {

    private WarriorType type;
    private Weapon weapon;
    private int STR;
    private int DEF;

    public Warrior(String name, int HP, int AP, int gold, WarriorType type, Weapon weapon) {
        super(name, HP, AP, gold);
        this.type = type;
        this.STR = type.getSTR() + weapon.getATK();
        this.DEF = type.getDEF();
        this.weapon = weapon;
    }

    public void attack(Enemy enemy) {
        if(weapon.getAPCost() < getAP()) {
            int enemyHP = enemy.getHP();
            int DMG = this.STR;
            int newHP = enemyHP - DMG;
            enemy.setHP(newHP);
            reduceAP(weapon.getAPCost());
            if (enemy.getHP() <= 0) {
                giveGold(enemy.getGOLD());
            }
        }
    }

    public void reduceAP(int cost){
        int oldAP = getAP();
        int newAP = oldAP - cost;
        setAP(newAP);
    }

    public void giveGold(int gold){
        int oldGold = getGold();
        int newGold = oldGold + gold;
        setGold(newGold);
    }
}
