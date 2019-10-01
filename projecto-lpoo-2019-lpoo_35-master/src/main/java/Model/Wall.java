package Model;

import ViewLanterna.ElementViewLanterna;
import ViewLanterna.WallViewLanterna;

public class Wall extends Element {

    private final WallViewLanterna view = new WallViewLanterna();

    public Wall(int x, int y) {
        super(x, y);
        discovered();
    }

    @Override
    public ElementViewLanterna getView() {
        return view;
    }

}