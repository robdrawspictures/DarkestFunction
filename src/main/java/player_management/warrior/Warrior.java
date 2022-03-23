package player_management.warrior;

import beast_management.enemy.Enemy;
import behaviours.IAttack;
import player_management.PlayerCharacter;
import resource_management.weapons.Weapon;

public class Warrior extends PlayerCharacter implements IAttack {


    private int HP;
    private WarriorType type;
    private Weapon weapon;
    private int STR;
    private int DEF;

    public Warrior(String name, WarriorType type, Weapon weapon) {
        super(name);
        this.HP = HP;
        this.type = type;
        this.STR = type.getSTR() + weapon.getATK();
        this.DEF = type.getDEF();
        this.weapon = weapon;
    }

    public String equipWeapon(Weapon newWeapon){
        int weight = newWeapon.getAPCost();
        if(weight <= this.type.getCLASS()){
            this.weapon = newWeapon;
            return "Weapon equipped.";
        } else return "You do not have the stats to wield this weapon.";
    }

    public void attack(Enemy enemy) {
        if(weapon.getAPCost() < getAP()) {
            int DMG = this.STR;
            enemy.takeDMG(DMG);
            reduceAP(weapon.getAPCost());
            if (enemy.getHP() <= 0) {
                addGold(enemy.getGOLD());
            }
        }
    }

}
