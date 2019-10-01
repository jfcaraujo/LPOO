import java.util.ArrayList;
import java.util.List;

public class Building extends Facility {
    private int minFloor, maxFloor, capacity;
    private String name;
    protected List<Room> rooms = new ArrayList<>();

    public Building(String name, int min, int max) {
        if (min>max) throw new IllegalArgumentException();
        this.name=name;
        this.minFloor=min;
        this.maxFloor=max;
        capacity=0;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Building("+name+")";
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
