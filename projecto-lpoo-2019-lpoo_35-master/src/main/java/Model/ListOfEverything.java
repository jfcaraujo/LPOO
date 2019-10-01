package Model;

import java.util.ArrayList;
import java.util.List;

public class ListOfEverything {
    private final List<Food> food;
    private final List<Weapon> weapons;
    private final List<Armor> armors;
    private final List<Skill> skills;

    public ListOfEverything() {
        food = new ArrayList<>();
        weapons = new ArrayList<>();
        armors = new ArrayList<>();
        skills = new ArrayList<>();


        food.add(new Food(10, 1, 1, "Bread"));
        food.add(new Food(20, 2, 2, "Big Bread"));
        food.add(new Food(30, 3, 3, "Giant Bread"));
        weapons.add(new Weapon(10, 101, 1, "Stick", 1));
        weapons.add(new Weapon(20, 102, 5, "Big Stick", 2));
        weapons.add(new Weapon(30, 103, 10, "Gigantic Stick", 3));
        armors.add(new Armor(10, 201, 1, "Paper", 1));
        armors.add(new Armor(20, 202, 5, "Double Leaf Paper", 2));
        armors.add(new Armor(30, 203, 10, "Nokia", 3));
        skills.add(new Skill(11, 20, 5, "Pew"));
        skills.add(new Skill(15, 25, 10, "Pew Pew"));
        skills.add(new Skill(19, 30, 15, "Mega Pew Pew"));

    }

    public List<Food> getFood() {
        return food;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
