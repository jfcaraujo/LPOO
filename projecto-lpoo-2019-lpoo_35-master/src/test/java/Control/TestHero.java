package Control;

import Control.Hero;
import Control.Monster;
import Model.Armor;
import Model.HeroModel;
import Model.Skill;
import Model.Weapon;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestHero {

    @Test
    public void testHeroGetItem() {
        Hero hero = new Hero(1);
        HeroModel heroModel = hero.getModel();
        Weapon weapon1 = new Weapon(100, 1, 1, "weapon1", 10);
        Weapon weapon2 = new Weapon(100, 2, 2, "weapon2", 10);

        assertTrue(hero.equip(weapon1));                                                                                /* has enough level */
        assertFalse(hero.equip(weapon2));                                                                               /* doesn't have enough level */

        while (heroModel.getLevel() != 2) {
            Monster monster = new Monster(1);//desnecessario
            hero.defeated(monster);
        }
        assertFalse(hero.equip(weapon1));                                                                               /* already has this weapon */
        assertTrue(hero.equip(weapon2));                                                                                /* has enough level and it's a better weapon */
        assertFalse(hero.equip(weapon1));                                                                               /* has a better weapon already */
    }

    @Test
    public void testHeroHunger() {
        Hero hero = new Hero(1);
        HeroModel heroModel = hero.getModel();
        assertEquals(0, heroModel.getHunger());                                                                /* no hunger */
        assertEquals(10 * heroModel.getLevel() * 3, heroModel.getHp());                                        /* full health */

        for (int i = 0; i < 30; i++) {
            hero.addHunger();
        }

        assertEquals(30, heroModel.getHunger());                                                               /* full hunger */
        assertEquals(10 * heroModel.getLevel() * 3, heroModel.getHp());                                        /* not enough to lose hp */

        hero.addHunger();

        assertEquals(30, heroModel.getHunger());                                                               /* full hunger */
        assertEquals(10 * heroModel.getLevel() * 3 - 1, heroModel.getHp());                                    /* lose one of hp, due to full hunger */

        while (heroModel.getHp() > 0)
            hero.addHunger();

        assertTrue(hero.updateHealth());                                                                                /* checks if hero has 0 hp */

        hero.fullHeal();
        hero.removeHunger(30);

        assertEquals(0, heroModel.getHunger());                                                                /* no hunger */
        assertEquals(10 * heroModel.getLevel() * 3, heroModel.getHp());                                        /* full health */
    }

    @Test
    public void testHeroSkills() {
        Hero hero = new Hero(1);
        HeroModel heroModel = hero.getModel();
        Monster monster1 = new Monster(1);

        assertEquals(1,monster1.getLevel());
        assertEquals(0, heroModel.getSkills().size());                                                         /* no initial skills */

        while (heroModel.getLevel() != 5) {
            Monster monster = new Monster(1);
            hero.defeated(monster);
        }

        assertEquals(1, heroModel.getSkills().size());                                                         /* got his first skill */
        assertEquals("Pew", heroModel.getSkills().get(0).getName());                                           /* confirm his first skill */

        Skill skill1 = new Skill(25, 10, 1, "skill1");

        assertTrue(hero.learnSkill(skill1));                                                                            /* learn a skill */
        assertFalse(hero.learnSkill(skill1));                                                                           /* can't learn the same skill twice */

        assertTrue(hero.skillAttack(2, monster1));                                                                   /* has enough mana */
        assertFalse(hero.skillAttack(2, monster1));                                                                  /* doesn't have enough mana */
    }

    @Test
    public void testHeroChangeWeapon() {
        Hero hero = new Hero(1);
        HeroModel heroModel = hero.getModel();

        for (int i = 0; i < 5; i++)
            assertEquals((Integer) 10, heroModel.getStats().get(i));                                                    /* verify inicial stats */

        Weapon weapon1 = new Weapon(100, 1, 1, "weapon1", 10);
        hero.equip(weapon1);

        assertEquals((Integer) 20, heroModel.getStats().get(0));                                                        /* verify if attack stat has been well modified */
        for (int i = 1; i < 5; i++)
            assertEquals((Integer) 10, heroModel.getStats().get(i));                                                    /* verify that other status haven't been modified */

        Weapon weapon2 = new Weapon(100, 1, 1, "weapon1", 15);
        hero.equip(weapon2);

        assertEquals((Integer) 25, heroModel.getStats().get(0));                                                        /* verify if attack stat has been well modified */
        for (int i = 1; i < 5; i++)
            assertEquals((Integer) 10, heroModel.getStats().get(i));                                                    /* verify that other status haven't been modified */
    }

    @Test
    public void testHeroChangeArmor() {
        Hero hero = new Hero(1);
        HeroModel heroModel = hero.getModel();

        for (int i = 0; i < 5; i++)
            assertEquals((Integer) 10, heroModel.getStats().get(i));                                                    /* verify inicial stats */

        Armor armor1 = new Armor(100, 1, 1, "armor1", 10);
        hero.equip(armor1);

        assertEquals((Integer) 10, heroModel.getStats().get(0));                                                        /* verify that other status haven't been modified */
        assertEquals((Integer) 20, heroModel.getStats().get(1));                                                        /* verify if defense stat has been well modified */
        for (int i = 2; i < 5; i++)
            assertEquals((Integer) 10, heroModel.getStats().get(i));                                                    /* verify that other status haven't been modified */

        Armor armor2 = new Armor(100, 1, 1, "armor2", 15);
        hero.equip(armor2);

        assertEquals((Integer) 10, heroModel.getStats().get(0));                                                        /* verify that other status haven't been modified */
        assertEquals((Integer) 25, heroModel.getStats().get(1));                                                        /* verify if defense stat has been well modified */
        for (int i = 2; i < 5; i++)
            assertEquals((Integer) 10, heroModel.getStats().get(i));                                                    /* verify that other status haven't been modified */
    }

    @Test
    public void testHeroLevel() {
        Hero hero = new Hero(1);
        Monster monster1 = new Monster(50);

        assertEquals(1, hero.getModel().getLevel());                                                            /* verify initial level */

        hero.defeated(monster1);

        assertEquals(5, hero.getModel().getLevel());                                                            /* verify if level has been well modified */
    }

    @Test
    public void testHeroBasicAttack() {
        Hero hero = new Hero(1);
        Monster monster = new Monster(1);

        assertEquals(20,monster.getHp());
        assertFalse(monster.updateHealth());

        hero.basicAttack(monster);

        assertEquals(15,monster.getHp());
        assertFalse(monster.updateHealth());

        hero.basicAttack(monster);
        hero.basicAttack(monster);
        hero.basicAttack(monster);

        assertTrue(monster.updateHealth());
    }

    @Test
    public void testHeroCombat() {
        Hero hero = new Hero(1);
        HeroModel heroModel = hero.getModel();
        Monster monster = new Monster(1);

        assertEquals(30,heroModel.getHp());

        hero.combat(monster);
        assertEquals(25,heroModel.getHp());
    }
}
