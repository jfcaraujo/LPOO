package States;

import Control.Hero;
import Control.Map;
import Model.Armor;
import Model.Food;
import Model.ListOfEverything;
import Model.Weapon;
import ViewLanterna.HeroStateViewLanterna;
import ViewLanterna.ShopStateViewLanterna;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.List;

public class ShopState implements HeroState {

    private ShopStateViewLanterna view = new ShopStateViewLanterna();

    private final ListOfEverything theOneList = new ListOfEverything();
    private final List<Food> listOfFood = theOneList.getFood();
    private final List<Weapon> listOfWeapons = theOneList.getWeapons();
    private final List<Armor> listOfArmors = theOneList.getArmors();


    @Override
    public void processKey(KeyStroke key, Hero hero, Map map) {
        if (key.getKeyType() == KeyType.Character) {
            switch (key.getCharacter()) {
                case 'f':
                    map.getModel().setState(new FoodShopState());
                    System.out.println("\nIn food shop");
                    break;
                case 'w':
                    map.getModel().setState(new WeaponShopState());
                    System.out.println("\nIn weapon shop");
                    break;
                case 'a':
                    map.getModel().setState(new ArmorShopState());
                    System.out.println("\nIn armor shop");
                    break;
            }
        } else if (key.getKeyType() == KeyType.Escape) {
            prev(map);
            System.out.println("\nIn city.");
        }
    }

    @Override
    public void prev(Map map) {
        map.getModel().setState(new CityState());
    }

    public void buy(Hero hero, int i, String s) {
        i--;
        switch (s) {
            case "food":
                if (hero.getModel().removeGold(listOfFood.get(i).getBuyCost())) {
                    hero.removeHunger(listOfFood.get(i).getLevel() * 10);
                    System.out.println("\nBought " + listOfFood.get(i).getName() + ".\n");
                } else System.out.println("\nNot enough gold.");
                break;
            case "weapon":
                if (hero.getModel().checkGold(listOfWeapons.get(i).getBuyCost())) {
                    if (hero.equip(listOfWeapons.get(i))) {
                        hero.getModel().removeGold(listOfWeapons.get(i).getBuyCost());
                        System.out.println("\nBought " + listOfWeapons.get(i).getName() + ".\n");
                    }
                } else System.out.println("\nNot enough gold.");
                break;
            case "armor":
                if (hero.getModel().checkGold(listOfArmors.get(i).getBuyCost())) {
                    if (hero.equip(listOfArmors.get(i))) {
                        hero.getModel().removeGold(listOfArmors.get(i).getBuyCost());
                        System.out.println("\nBought " + listOfArmors.get(i).getName() + ".\n");
                    }
                } else System.out.println("\nNot enough gold.");
                break;
        }
    }

    public ShopStateViewLanterna getView() {
        return view;
    }

    @Override
    public void setView(HeroStateViewLanterna view) {
        this.view = (ShopStateViewLanterna) view;
    }

}
