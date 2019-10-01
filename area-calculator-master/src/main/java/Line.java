public class Line implements BasicShape{
    private double lenght;

    public Line (double x){
        lenght=x;
    }

    public double getArea() throws Exception {
        throw NoAreaException();
    }

    private Exception NoAreaException(){
        System.out.println("A line doesn't have an area.");
        return null;
    }

    public void draw() {
        System.out.println("Line.");
    }
}
