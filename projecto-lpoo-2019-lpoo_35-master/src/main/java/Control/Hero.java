package Control;

import Model.*;
import ViewLanterna.HeroViewLanterna;

public class Hero {

    private final HeroModel model;
    private final HeroViewLanterna view = new HeroViewLanterna();

    public Hero(int baseStats) {
        model = new HeroModel(baseStats);
    }

    public HeroModel getModel() {
        return model;
    }

    public HeroViewLanterna getView() {
        return view;
    }

    private void levelUp() {
        model.setExp(model.getExp() - model.getLevel() * 100);
        model.setLevel(model.getLevel() + 1);
        model.setHunger(0);
        for (int i = 0; i < 5; i++)
            model.getStats().set(i, 1 + model.getStats().get(i));
        fullHeal();
        System.out.println("Level up!");
        if (model.getLevel() % 5 == 0 && model.getLevel() < 20) {
            learnSkill(model.getTheOneList().getSkills().get((model.getLevel() / 5) - 1));
            System.out.println("Learned skill \"" + model.getTheOneList().getSkills().get((model.getLevel() / 5) - 1).getName() + "\" !");
        }
    }

    public void addHunger() {
        if (model.getHunger() == 30)
            model.setHp(model.getHp() - 1);
        else {
            model.setHunger(model.getHunger() + 1);
        }
    }

    public boolean equip(Item i) {
        if (i.getLevel() > model.getLevel()) {
            System.out.println("\nYour level is to low to equip this.");
            return false;
        } else if (Weapon.class.equals(i.getClass())) {
            return compare(i, model.getWeapon(), "weapon");
        } else if (Armor.class.equals(i.getClass())) {
            return compare(i, model.getArmor(), "armor");
        } else return false;
    }

    private boolean compare(Item i, Item compare, String s) {
        if (compare != null) {
            if (compare.equals(i)) {
                System.out.println("\nYou have already equipped that " + s + ".");
                return false;
            } else if (i.getLevel() < compare.getLevel()) {
                System.out.println("\nYou have already equipped a better " + s + ".");
                return false;
            }
        }
        unequip(s);
        auxiliaryEquip(i);
        return true;
    }

    private void auxiliaryEquip(Item i) {
        if (Weapon.class.equals(i.getClass())) {
            model.setWeapon((Weapon) i);
            model.getStats().set(0, model.getStats().get(0) + model.getWeapon().getAttack());
        }
        if (Armor.class.equals(i.getClass())) {
            model.setArmor((Armor) i);
            model.getStats().set(1, model.getStats().get(1) + model.getArmor().getDefence());
        }

    }

    private void unequip(String s) {
        if (s.equals("weapon")) {
            if (model.getWeapon() != null) {
                model.getStats().set(0, model.getStats().get(0) - model.getWeapon().getAttack());
                model.setWeapon(null);
            }
        }
        if (s.equals("armor")) {
            if (model.getArmor() != null) {
                model.getStats().set(1, model.getStats().get(1) - model.getArmor().getDefence());
                model.setArmor(null);
            }
        }
    }

    public void removeHunger(int i) {
        model.setHunger(model.getHunger() - i);
        if (model.getHunger() < 0) model.setHunger(0);
    }

    private boolean removeMana(int i) {
        if (model.getMp() < i) {
            System.out.println("Not enough mana.");
            return false;
        } else {
            model.setMp(model.getMp() - i);
            return true;
        }
    }

    public boolean updateHealth() {
        if (model.getHp() <= 0) {
            model.setHp(0);
            return true;
        } else return false;
    }

    public void fullHeal() {
        model.setHp(model.getStats().get(3) * 3);
        model.setMp(model.getStats().get(4) * 2);
    }

/*
    public void addHealth(int i) {
        hp += i;
        if (hp > stats.get(3)) hp = stats.get(3);
    }

    public void addMana(int i) {
        mp += i;
        if (mp > stats.get(4)) mp = stats.get(4);
    }*/

    public boolean learnSkill(Skill s) {
        if (model.getSkills().contains(s)) {
            System.out.println("You already know that skill.");
            return false;
        } else {
            model.getSkills().add(s);
            return true;
        }
    }

    public void combat(Monster monster) {
        int damage = (int) Math.round(monster.getStats().get(0) - (0.5 * model.getStats().get(1)));
        if (damage < 0) damage = 0;
        int dodge = (model.getStats().get(2) - monster.getStats().get(2));//dodge chance
        if (Math.random() < (dodge / 40.0))//2.5% chance per difference in agility
            damage = 0;
        model.setHp(model.getHp() - damage);//hero damage
    }

    public void basicAttack(Monster monster) {
        int damage = (int) Math.round(model.getStats().get(0) - (0.5 * monster.getStats().get(1)));
        int dodge = (monster.getStats().get(2) - model.getStats().get(2));//dodge chance
        if (damage < 0) damage = 0;
        if (Math.random() < (dodge / 40.0))//2.5% chance per difference in agility
            damage = 0;
        monster.setHp(monster.getHp() - damage);//monster damage
    }

    public boolean skillAttack(int x, Monster monster) {
        Skill s = model.getSkills().get(x - 1);

        if (removeMana(s.getManaCost())) {
            int damage = (int) Math.round(s.getAttackPower() * model.getStats().get(0) / 10.0 - (0.5 * monster.getStats().get(1)));
            if (damage < 0) damage = 0;
            monster.setHp(monster.getHp() - damage);//monster damage
            return true;
        } else return false;
    }

    public void defeated(Monster monster) {
        model.addGold(monster.getGoldDropped());
        System.out.println("Hero gained " + monster.getGoldDropped() + " gold!");
        model.setExp(model.getExp() + monster.getExpDropped());
        System.out.println("Hero gained " + monster.getExpDropped() + " exp!");
        while (model.getExp() >= model.getLevel() * 100) {
            levelUp();

        }
    }

    public void gameOver(int i) {
        System.out.println("\nGAME OVER");
        System.out.println("Hero reached level " + model.getLevel() + " with " + model.getExp() + " exp and " + model.getGold() + " gold.");
        if (i == 1)
            System.out.println("Hero died in position (" + model.getPosition().getX() + ", " + model.getPosition().getY() + "). Boss position is (48, 22).");
    }

}
