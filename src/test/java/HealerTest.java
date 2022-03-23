import beast_management.BeastType;
import beast_management.enemy.Enemy;
import beast_management.mount.Mount;
import org.junit.Before;
import org.junit.Test;
import player_management.healer.Healer;
import player_management.healer.HealerType;
import player_management.mage.Mage;
import player_management.mage.MageType;
import resource_management.items.Item;
import resource_management.items.ItemType;
import resource_management.spells.Spell;
import resource_management.spells.SpellType;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HealerTest {

    private Mage ally;
    private Healer healer;
    private Mount mount;
    private Enemy enemy;
    private Enemy enemy2;
    private Enemy enemy3;
    private Spell fireball;
    private Spell death;
    private Spell cure;
    private Spell meteor;
    private Item potion;
    private Item phoenixDown;
    private ArrayList<Spell> spells;
    private ArrayList<Spell> spells2;
    private ArrayList<Item> items;

    @Before
    public void before(){
        fireball = new Spell(SpellType.FIREBALL);
        death = new Spell(SpellType.DEATH);
        cure = new Spell(SpellType.CURE);
        meteor = new Spell(SpellType.METEOR);
        spells = new ArrayList<>();
        spells.add(cure);
        spells.add(fireball);
        spells2 = new ArrayList<>();
        spells2.add(fireball);
        mount = new Mount(BeastType.DRAGON, 10, 10);
        potion = new Item(ItemType.POTION);
        phoenixDown = new Item(ItemType.PHOENIXDOWN);
        items = new ArrayList<>();
        items.add(potion);
        ally = new Mage("Greg", MageType.WIZARD, spells, mount);
        healer = new Healer("Tsunade", HealerType.CLERIC, items, spells);
        enemy = new Enemy(BeastType.ONI, 100, 5, 10);
        enemy2 = new Enemy(BeastType.ONI, 100, 5, 10);
        enemy3 = new Enemy(BeastType.SLIME, 5, 1, 5);
    }

    @Test
    public void canAddItem(){
        healer.addItem(phoenixDown);
        assertEquals(2, healer.itemCount());
    }

    @Test
    public void canUseItem(){
        enemy.attack(ally);
        assertEquals(70, ally.getHP());
        healer.useItem(potion, ally);
        assertEquals(75, ally.getHP());
        assertEquals(0, healer.itemCount());
        healer.addItem(potion);
        enemy.attack(ally);
        enemy.attack(ally);
        enemy.attack(ally);
        enemy.attack(ally);
        enemy.attack(ally);
        enemy.attack(ally);
        healer.useItem(potion, ally);
        assertEquals(70, ally.getHP());
    }

    @Test
    public void cannotExceedMaxItem(){
        healer.addItem(potion);
        healer.addItem(potion);
        healer.addItem(potion);
        assertEquals(4, healer.itemCount());
        healer.addItem(potion);
        assertEquals(4, healer.itemCount());

    }
}
