package player_management.warrior;

public enum WarriorType {

    ROGUE(1, 2),
    KNIGHT(2,3),
    BARBARIAN(4, 2);

    private final int STR;
    private final int DEF;

    WarriorType(int STR, int DEF){
        this.STR = STR;
        this.DEF = DEF;
    }
}
