package Model;

public class Weapon extends Item {

    private final int attack;

    public Weapon(int buyCost, int id, int level, String name, int attack) {
        super(buyCost, id, level, name);
        this.attack = attack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Weapon w = (Weapon) o;
        return attack == w.attack && buyCost == w.buyCost && id == w.id && level == w.level && name.equals(w.name);
    }

    public int getAttack() {
        return attack;
    }
}
