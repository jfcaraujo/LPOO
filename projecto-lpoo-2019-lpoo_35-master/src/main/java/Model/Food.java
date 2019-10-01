package Model;

public class Food extends Item {

    public Food(int buyCost, int id, int level, String name) {
        super(buyCost, id, level, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Food f = (Food) o;
        return buyCost == f.buyCost && id == f.id && level == f.level && name.equals(f.name);
    }

}
