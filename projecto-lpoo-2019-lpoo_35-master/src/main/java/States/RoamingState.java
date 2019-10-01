package States;

import Control.Hero;
import Control.Map;
import ViewLanterna.HeroStateViewLanterna;
import ViewLanterna.RoamingStateViewLanterna;
import com.googlecode.lanterna.input.KeyStroke;

public class RoamingState implements HeroState {

    private RoamingStateViewLanterna view = new RoamingStateViewLanterna();

    @Override
    public void processKey(KeyStroke key, Hero hero, Map map) {
        switch (key.getKeyType()) {
            case ArrowLeft:
                map.moveHero(hero.getModel().getPosition().moveLeft());
                break;
            case ArrowRight:
                map.moveHero(hero.getModel().getPosition().moveRight());
                break;
            case ArrowUp:
                map.moveHero(hero.getModel().getPosition().moveUp());
                break;
            case ArrowDown:
                map.moveHero(hero.getModel().getPosition().moveDown());
                break;
        }
    }

    @Override
    public void prev(Map map) {

    }

    public RoamingStateViewLanterna getView() {
        return view;
    }

    @Override
    public void setView(HeroStateViewLanterna view) {
        this.view= (RoamingStateViewLanterna) view;
    }
}
