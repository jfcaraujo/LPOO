package Model;

import ViewLanterna.CityViewLanterna;
import ViewLanterna.ElementViewLanterna;

public class City extends Element {

    private final CityViewLanterna view = new CityViewLanterna();

    public City(int x, int y) {
        super(x, y);
    }

    @Override
    public ElementViewLanterna getView() {
        return view;
    }

}
