package player_management.warrior;

import beast_management.enemy.Enemy;
import behaviours.IAttack;
import behaviours.ILevel;
import player_management.PlayerCharacter;
import resource_management.weapons.Weapon;

public class Warrior extends PlayerCharacter implements IAttack, ILevel {


    private int MAXHP;
    private int HP;
    private WarriorType type;
    private Weapon weapon;
    private int STR;
    private int DEF;

    public Warrior(String name, WarriorType type, Weapon weapon) {
        super(name);
        this.MAXHP = 100;
        this.HP = 100;
        this.type = type;
        this.STR = type.getSTR() + weapon.getATK();
        this.DEF = type.getDEF();
        this.weapon = weapon;
    }

    public int getMAXHP() {
        return MAXHP;
    }

    public int getHP() {
        return HP;
    }

    public WarriorType getType() {
        return type;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getSTR() {
        return STR;
    }

    public int getDEF() {
        return DEF;
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

    public void takeDMG(int DMG){
        this.HP -= DMG;
    }
    public void heal(int amount){
        this.HP += amount;
    }

    public void levelUp(){
        this.MAXHP += 5;
        this.HP += 5;
        this.STR += 2;
        this.DEF += 1;
    }

}
