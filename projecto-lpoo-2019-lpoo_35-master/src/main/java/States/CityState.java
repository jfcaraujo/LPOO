package States;

import Control.Hero;
import Control.Map;
import ViewLanterna.CityStateViewLanterna;
import ViewLanterna.HeroStateViewLanterna;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class CityState implements HeroState {

    private CityStateViewLanterna view =new CityStateViewLanterna();

    @Override
    public void processKey(KeyStroke key, Hero hero, Map map) {
        if (key.getKeyType() == KeyType.Character) {
            switch (key.getCharacter()) {
                case 'h':
                    heal(hero);
                    break;
                case 's':
                    map.getModel().setState(new ShopState());
                    System.out.println("\nIn shop");
                    break;
            }
        } else new RoamingState().processKey(key, hero, map);
    }

    @Override
    public void prev(Map map) {

    }

    private void heal(Hero hero) {
        int cost = (hero.getModel().getStats().get(3) * 3 - hero.getModel().getHp()) + (hero.getModel().getStats().get(4) * 2 - hero.getModel().getMp());
        if (cost == 0)
            System.out.println("Hero is at full health.");
        else if (hero.getModel().removeGold(cost)) {
            hero.fullHeal();
            System.out.println("Hero was healed. It cost " + cost + " gold.");
        }
    }

    public CityStateViewLanterna getView() {
        return view;
    }

    @Override
    public void setView(HeroStateViewLanterna view) {
        this.view= (CityStateViewLanterna) view;
    }
}
