import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {

    private Position position;

    public Element(int x, int y) {
        position = new Position(x, y);
    }

    public abstract void draw(TextGraphics graphics);

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        position.setY(y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        setX(position.getX());
        setY(position.getY());
    }
}
