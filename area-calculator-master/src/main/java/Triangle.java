public class Triangle implements Shape {
    private double width, height;

    public Triangle(double x, double y){
        width=x;
        height=y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width*height/2.0;
    }

    public void draw() {
        System.out.println("Triangle.");
    }
}
