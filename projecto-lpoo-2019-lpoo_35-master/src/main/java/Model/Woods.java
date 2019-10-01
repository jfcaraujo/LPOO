package Model;

import ViewLanterna.ElementViewLanterna;
import ViewLanterna.WoodsViewLanterna;

public class Woods extends Element {

    private final WoodsViewLanterna view = new WoodsViewLanterna();

    public Woods(int x, int y) {
        super(x, y);
    }

    @Override
    public ElementViewLanterna getView() {
        return view;
    }


}
