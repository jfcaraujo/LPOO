public class Circle implements Shape {
    private double radius;

    public Circle(double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void draw() {
        System.out.println("Circle.");
    }
}
