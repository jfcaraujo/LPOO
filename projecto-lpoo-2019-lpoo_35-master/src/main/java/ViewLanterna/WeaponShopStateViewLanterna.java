package ViewLanterna;

import Model.ListOfEverything;
import Model.Weapon;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class WeaponShopStateViewLanterna extends HeroStateViewLanterna {

    private final ListOfEverything theOneList = new ListOfEverything();
    private final List<Weapon> listOfWeapons = theOneList.getWeapons();

    @Override
    public void draw(TextGraphics graphics, int width) {
        drawSentence(graphics, width, 19, "List of items for sale:");
        for (int i = 0; i < listOfWeapons.size(); i++) {
            drawSentence(graphics, width, 20 + i, (i + 1) + ": " + listOfWeapons.get(i).getName()
                    + " | Cost: " + listOfWeapons.get(i).getBuyCost()
                    + " | Has " + listOfWeapons.get(i).getAttack() + " attack.");
        }
    }
}
