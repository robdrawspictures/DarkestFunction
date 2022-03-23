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
}
