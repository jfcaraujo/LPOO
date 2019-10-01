package Model;

import Control.Position;
import ViewLanterna.ElementViewLanterna;

public abstract class Element {

    private final Position position;
    private boolean discovered;


    Element(int x, int y) {
        position = new Position(x, y);
        discovered = false;
    }

    public void discovered() {
        this.discovered = true;
    }

    public abstract ElementViewLanterna getView();

    public boolean isDiscovered() {
        return discovered;
    }

    public Position getPosition() {
        return position;
    }
}