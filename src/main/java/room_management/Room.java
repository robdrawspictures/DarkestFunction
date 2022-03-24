package room_management;

import beast_management.enemy.Enemy;
import player_management.PlayerCharacter;
import treasure.Treasure;

import java.util.ArrayList;

public class Room {

    private PlayerCharacter player1;
    private Enemy enemy1;
    private Treasure loot;

    public Room(PlayerCharacter player1, Enemy enemy1, Treasure loot) {
        this.player1 = player1;
        this.enemy1 = enemy1;
        this.loot = loot;
    }

    public PlayerCharacter getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayerCharacter player1) {
        this.player1 = player1;
    }

    public Enemy getEnemy1() {
        return enemy1;
    }

    public void setEnemy1(Enemy enemy1) {
        this.enemy1 = enemy1;
    }

    public Treasure getLoot() {
        return loot;
    }

    public void setLoot(Treasure loot) {
        this.loot = loot;
    }
}
