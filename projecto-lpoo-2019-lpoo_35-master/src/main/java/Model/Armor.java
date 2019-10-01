package Model;

public class Armor extends Item {

    private final int defence;

    public Armor(int buyCost, int id, int level, String name, int defence) {
        super(buyCost, id, level, name);
        this.defence = defence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Armor a = (Armor) o;
        return defence == a.defence && buyCost == a.buyCost && id == a.id && level == a.level && name.equals(a.name);
    }

    public int getDefence() {
        return defence;
    }
}
