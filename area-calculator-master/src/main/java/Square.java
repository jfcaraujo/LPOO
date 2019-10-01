public class Square implements Shape{
    private double side;

    public Square(double l) {
        side = l;
    }

    public double getSide() {
        return side;
    }

    public double getArea() {
        return side*side;
    }

    public void draw() {
        System.out.println("Square.");
    }
}
