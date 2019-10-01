package Control;

import Model.*;
import States.CityState;
import States.FightingState;
import States.RoamingState;
import ViewLanterna.MapViewLanterna;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;

public class Map {

    private final MapModel model;
    private final MapViewLanterna view = new MapViewLanterna();

    public Map(int width, int height) {
        model = new MapModel(width, height);
        createMap();
        discovered(model.getHero().getModel().getPosition());
    }

    public MapModel getModel() {
        return model;
    }

    public MapViewLanterna getView() {
        return view;
    }

    private void createMap() {
        ArrayList<Element> temp;
        for (int h = 0; h < model.getHeight(); h++) {
            temp = new ArrayList<>();
            for (int w = 0; w < model.getWidth(); w++) {
                if (h == 0 || h == model.getHeight() - 1 || w == 0 || w == model.getWidth() - 1)
                    temp.add(new Wall(w, h));
                else if (h == 1 && w == 1)
                    temp.add(new City(w, h));
                else if (h == model.getHeight() - 2 && w == model.getWidth() - 2)
                    temp.add(new End(w, h));
                else if (Math.random() > 0.95)
                    temp.add(new City(w, h));
                else temp.add(new Woods(w, h));
            }
            model.getPositions().add(temp);
        }

    }

    public void processKey(KeyStroke key) {
        model.getState().processKey(key, model.getHero(), this);
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            model.getHero().getModel().setPosition(position);
            discovered(position);
            model.getHero().addHunger();
            if (model.getElement(position).getClass() == Woods.class) {
                if (Math.random() < (position.getX() + position.getY()) / (2.0 * model.getHero().getModel().getLevel())) {
                    model.setState(new FightingState());
                    createMonster();
                } else model.setState(new RoamingState());
            } else if (model.getElement(position).getClass() == City.class)
                model.setState(new CityState());
            else if (model.getElement(position).getClass() == End.class) {
                model.setState(new FightingState());
                createMonster();

            }
        }
    }

    private void createMonster() {
        if (model.getHero().getModel().getPosition().equals(new Position(48, 22)))
            model.setMonster(new Monster(50));
        else
            model.setMonster(new Monster((model.getHero().getModel().getPosition().getX() + model.getHero().getModel().getPosition().getY() - 1) / 2));
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() < 0) return false;
        if (position.getX() > model.getWidth() - 1) return false;
        if (position.getY() < 0) return false;
        if (position.getY() > model.getHeight() - 1) return false;
        return model.getElement(position).getClass() != Wall.class;
    }

    private void discovered(Position position) {
        model.getElement(position).discovered();
    }

    public boolean checkDead() {
        return model.getHero().updateHealth();
    }

    public void gameOver() {
        model.getHero().gameOver(1);
    }

    public boolean victory() {
        if (model.getHero().getModel().getPosition().equals(new Position(48, 22)) && model.getMonster().updateHealth()) {
            model.getHero().gameOver(0);
            System.out.println("Congratulations, you won the game!");
            return true;
        } else
            return false;
    }


    public void basicAttack() {
        model.getHero().basicAttack(model.getMonster());
    }

    public void combat() {
        model.getHero().combat(model.getMonster());
    }

    public boolean skillAttack(int i) {
        return model.getHero().skillAttack(i, model.getMonster());
    }


    public boolean wasAbleToRun() {
        return Math.random() > (0.5 + 0.1 * (model.getMonster().getStats().get(2) - model.getHero().getModel().getStats().get(2)));
    }


    public boolean updateMonsterHealth(Hero hero) {
        if (model.getMonster().updateHealth()) {
            hero.defeated(model.getMonster());
            return true;
        } else return false;
    }


}
