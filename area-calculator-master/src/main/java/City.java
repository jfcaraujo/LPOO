import java.util.List;

public class City implements SumProvider{
    private List<House> houses;

    public City(List<House> list) {
        houses = list;
    }

    public double sum() {
        double sum = 0;
        for (House house : houses)
            sum += house.getArea();
        return sum;
    }
}
