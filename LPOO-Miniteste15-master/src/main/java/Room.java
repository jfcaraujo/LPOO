public class Room extends Facility {
    private Building building;
    private int floor, capacity;
    private String number;

    public Room(Building b, String number, int floor) throws DuplicateRoomException {
        for (Room room:b.rooms)
            if (room.number==number && room.floor ==floor) throw new DuplicateRoomException();
        if (floor>b.getMaxFloor()||floor<b.getMinFloor()) throw new IllegalArgumentException();
        building=b;
        capacity=0;
        this.number=number;
        this.floor=floor;
        b.rooms.add(this);
    }

    public Room(Building b, String number, int floor, int capacity) throws DuplicateRoomException {
        for (Room room:b.rooms)
            if (room.number==number && room.floor ==floor) throw new DuplicateRoomException();
        if (floor>b.getMaxFloor()||floor<b.getMinFloor()) throw new IllegalArgumentException();
        building=b;
        b.setCapacity(b.getCapacity()+capacity);
        this.capacity=capacity;
        this.number=number;
        this.floor=floor;
        b.rooms.add(this);
    }

    public Building getBuilding() {
        return building;
    }

    public int getFloor() {
        return floor;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return building.getName()+number;
    }

    @Override
    public String toString() {
        return "Room("+building.getName()+","+number+")";
    }

    public int getCapacity() {
        return capacity;
    }


    public void authorize(User u1) {
        this.users.add(u1);
        building.users.add(u1);
    }
}
