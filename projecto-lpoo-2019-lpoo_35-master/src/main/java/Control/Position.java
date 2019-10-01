package Control;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position moveUp() {
        return new Position(x, y - 1);
    }

    public Position moveDown() {
        return new Position(x, y + 1);
    }

    public Position moveLeft() {
        return new Position(x - 1, y);
    }

    public Position moveRight() {
        return new Position(x + 1, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();

    }
}
