public class Rectangle implements Shape{
    private double width, height;

    public Rectangle(double x, double y){
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
        return width*height;
    }

    public void draw() {
        System.out.println("Rectangle.");
    }
}
