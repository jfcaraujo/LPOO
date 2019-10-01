package Model;

public class Skill {
    private final int manaCost;
    private final int attackPower;
    private final int minimumLevel;
    private final String name;

    public Skill(int manaCost, int attackPower, int minimumLevel, String name) {
        this.manaCost = manaCost;
        this.attackPower = attackPower;
        this.minimumLevel = minimumLevel;
        this.name = name;
    }
/*
    @Override
    public int hashCode() {
        return minimumLevel * attackPower * manaCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Model.Skill s = (Model.Skill) o;
        return (manaCost == s.manaCost && attackPower == s.attackPower && minimumLevel == s.minimumLevel && name.equals(s.name));
    }*/

    public int getManaCost() {
        return manaCost;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMinimumLevel() {
        return minimumLevel;
    }

    public String getName() {
        return name;
    }
}
