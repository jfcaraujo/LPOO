package States;

import Control.Hero;
import Control.Map;
import ViewLanterna.HeroStateViewLanterna;
import ViewLanterna.WeaponShopStateViewLanterna;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;


public class WeaponShopState implements HeroState {

    private WeaponShopStateViewLanterna view = new WeaponShopStateViewLanterna();

    @Override
    public void processKey(KeyStroke key, Hero hero, Map map) {
        if (key.getKeyType() == KeyType.Character) {
            ShopState c = new ShopState();
            switch (key.getCharacter()) {
                case '1':
                    c.buy(hero, 1, "weapon");
                    break;
                case '2':
                    c.buy(hero, 2, "weapon");
                    break;
                case '3':
                    c.buy(hero, 3, "weapon");
                    break;
            }
        } else if (key.getKeyType() == KeyType.Escape) {
            prev(map);
            System.out.println("\nIn shop.");
        }
    }

    @Override
    public void prev(Map map) {
        map.getModel().setState(new ShopState());
    }

    public WeaponShopStateViewLanterna getView() {
        return view;
    }

    @Override
    public void setView(HeroStateViewLanterna view) {
        this.view = (WeaponShopStateViewLanterna) view;
    }
}
