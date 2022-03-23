import beast_management.BeastType;
import beast_management.enemy.Enemy;
import org.junit.Before;
import org.junit.Test;
import player_management.warrior.Warrior;
import player_management.warrior.WarriorType;
import resource_management.weapons.Weapon;
import resource_management.weapons.WeaponType;

import static org.junit.Assert.assertEquals;

public class WarriorTest {

    private Warrior warrior;
    private Warrior warrior2;
    private Enemy enemy;
    private Enemy enemy2;
    private Enemy enemy3;
    private Weapon weapon;
    private Weapon weapon2;
    private Weapon weapon3;

    @Before
    public void before(){
        weapon = new Weapon(WeaponType.DRAGONSLAYER);
        weapon2 = new Weapon(WeaponType.DAGGER);
        weapon3 = new Weapon(WeaponType.SPEAR);
        warrior = new Warrior("Guts", WarriorType.BARBARIAN, weapon);
        warrior2 = new Warrior("Casca", WarriorType.ROGUE, weapon2);
        enemy = new Enemy(BeastType.ONI, 100, 5, 10);
        enemy2 = new Enemy(BeastType.ONI, 100, 5, 10);
        enemy3 = new Enemy(BeastType.SLIME, 5, 1, 5);
    }

    @Test
    public void canGetAp(){
        assertEquals(10, warrior.getAP());
    }

    @Test
    public void canAttack(){
        warrior.attack(enemy);
        assertEquals(91, enemy.getHP());
        warrior2.attack(enemy2);
        assertEquals(98, enemy2.getHP());
    }

    @Test
    public void canGetGoldOnDeath(){
        warrior.attack(enemy);
        warrior.attack(enemy3);
        assertEquals(5, warrior.getGold());
    }

    @Test
    public void cantAttackOnNoAP(){
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        warrior.attack(enemy);
        assertEquals(73, enemy.getHP());
        assertEquals(1, warrior.getAP());
    }

    @Test
    public void cantWieldCertainWeapons(){
        assertEquals("You do not have the stats to wield this weapon.", warrior2.equipWeapon(weapon));
        assertEquals("Weapon equipped.", warrior2.equipWeapon(weapon3));
    }
}
