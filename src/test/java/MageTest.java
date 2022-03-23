import beast_management.Beast;
import beast_management.BeastType;
import beast_management.enemy.Enemy;
import beast_management.mount.Mount;
import org.junit.Before;
import org.junit.Test;
import player_management.mage.Mage;
import player_management.mage.MageType;
import player_management.warrior.Warrior;
import player_management.warrior.WarriorType;
import resource_management.spells.Spell;
import resource_management.spells.SpellType;
import resource_management.weapons.Weapon;
import resource_management.weapons.WeaponType;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MageTest {

    private Mage mage1;
    private Mage darkElf;
    private Mount mount;
    private Enemy enemy;
    private Enemy enemy2;
    private Enemy enemy3;
    private Spell fireball;
    private Spell death;
    private Spell cure;
    private ArrayList<Spell> spells;
    private ArrayList<Spell> spells2;

    @Before
    public void before(){
        fireball = new Spell(SpellType.FIREBALL);
        death = new Spell(SpellType.DEATH);
        cure = new Spell(SpellType.CURE);
        spells = new ArrayList<>();
        spells.add(cure);
        spells.add(fireball);
        spells2 = new ArrayList<>();
        spells2.add(fireball);
        mount = new Mount(BeastType.DRAGON, 10, 10);
        mage1 = new Mage("Greg", MageType.WIZARD, spells, mount);
        darkElf = new Mage("Cyril", MageType.WARLOCK, spells2, mount);
        enemy = new Enemy(BeastType.ONI, 100, 5, 10);
        enemy2 = new Enemy(BeastType.ONI, 100, 5, 10);
        enemy3 = new Enemy(BeastType.SLIME, 5, 1, 5);
    }

    @Test
    public void hasSpells(){
        assertEquals(2, mage1.spellCount());
    }

    @Test
    public void canAttack(){
        mage1.cast("fireball", enemy3);
        assertEquals(2, enemy3.getHP());
    }

    @Test
    public void cantLearnCertainSpells(){
        mage1.learnSpell(death);
        assertEquals(2, mage1.spellCount());
        assertEquals(1, darkElf.spellCount());
        darkElf.learnSpell(cure);
        assertEquals(1, darkElf.spellCount());
        darkElf.learnSpell(death);
        assertEquals(2, darkElf.spellCount());
    }
}
