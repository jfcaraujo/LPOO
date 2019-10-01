package Model;

import ViewLanterna.ElementViewLanterna;
import ViewLanterna.EndViewLanterna;

public class End extends Element {

    private final EndViewLanterna view = new EndViewLanterna();

    public End(int x, int y) {
        super(x, y);
    }

    @Override
    public ElementViewLanterna getView() {
        return view;
    }

}

