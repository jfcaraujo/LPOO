package Model;

import Control.Position;

import java.util.ArrayList;
import java.util.List;

public class HeroModel {
    private int hp, mp, hunger, gold, level, exp /*total xp= level*100*/;
    private Weapon weapon;
    private Armor armor;
    private final List<Integer> stats = new ArrayList<>();
    private Position position;
    private final List<Skill> skills = new ArrayList<>();
    private final ListOfEverything theOneList;

    public HeroModel(int baseStats) {
        position = new Position(1, 1);
        stats.add(10 * baseStats);//attack
        stats.add(10 * baseStats);//defense
        stats.add(10 * baseStats);//agility
        stats.add(10 * baseStats);//vitality=max hp
        stats.add(10 * baseStats);//mana=max mp
        hp = stats.get(3) * 3;
        mp = stats.get(4) * 2;
        hunger = 0;//max 30
        gold = 100;
        this.level = 1;
        exp = 0;
        theOneList = new ListOfEverything();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public List<Integer> getStats() {
        return stats;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public ListOfEverything getTheOneList() {
        return theOneList;
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public boolean removeGold(int amount) {
        if (!checkGold(amount)) {
            System.out.println("Not enough gold.");
            return false;
        } else {
            gold -= amount;
            return true;
        }
    }

    public int getGold() {
        return gold;
    }

    public boolean checkGold(int amount) {
        return gold >= amount;
    }

}
