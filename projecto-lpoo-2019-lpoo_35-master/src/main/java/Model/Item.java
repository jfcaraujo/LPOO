package Model;

public abstract class Item {
    final int buyCost;
    final int id;
    final int level;
    final String name;


    public int getBuyCost() {
        return buyCost;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    Item(int buyCost, int id, int level, String name) {
        this.buyCost = buyCost;
        this.id = id;
        this.level = level;
        this.name = name;
    }

    @Override
    public abstract boolean equals(Object o);
}
