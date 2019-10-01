package Model;

import Control.Hero;
import Control.Monster;
import Control.Position;
import States.CityState;
import States.HeroState;

import java.util.ArrayList;

public class MapModel {
    private final int width;
    private final int height;
    private final Hero hero;
    private HeroState state = new CityState();
    private final ArrayList<ArrayList<Element>> positions = new ArrayList<>();
    private Monster monster;

    public MapModel(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(2);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Hero getHero() {
        return hero;
    }

    public HeroState getState() {
        return state;
    }

    public void setState(HeroState state) {
        this.state = state;
    }


    public ArrayList<ArrayList<Element>> getPositions() {
        return positions;
    }

    public Element getElement(Position position) {
        return positions.get(position.getY()).get(position.getX());
    }


    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }



}
