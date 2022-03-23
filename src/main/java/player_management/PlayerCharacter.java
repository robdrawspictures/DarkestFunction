package player_management;

import beast_management.enemy.Enemy;

abstract public class PlayerCharacter {

    private String name;
    private int AP;
    private int gold;

    public PlayerCharacter(String name) {
        this.name = name;
        this.AP = 10;
        this.gold = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAP() {
        return AP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void reduceAP(int cost){
        this.AP -= cost;
    }

    public void addGold(int loot){
        this.gold += loot;
    }

    abstract public void takeDMG(int DMG);

    abstract public void heal(int amount);
}
