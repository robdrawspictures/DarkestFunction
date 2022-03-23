package player_management;

abstract public class PlayerCharacter {

    private String name;
    private int HP;
    private int AP;
    private int gold;

    public PlayerCharacter(String name, int HP, int AP, int gold) {
        this.name = name;
        this.HP = HP;
        this.AP = AP;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
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
}
