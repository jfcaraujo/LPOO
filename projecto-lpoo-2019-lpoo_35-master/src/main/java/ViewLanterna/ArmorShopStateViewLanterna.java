package ViewLanterna;

import Model.Armor;
import Model.ListOfEverything;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class ArmorShopStateViewLanterna extends HeroStateViewLanterna {

    private final ListOfEverything theOneList = new ListOfEverything();
    private final List<Armor> listOfArmors = theOneList.getArmors();

    @Override
    public void draw(TextGraphics graphics, int width) {
        drawSentence(graphics, width, 19, "List of items for sale:");
        for (int i = 0; i < listOfArmors.size(); i++) {
            drawSentence(graphics, width, 20 + i, (i + 1) + ": " + listOfArmors.get(i).getName()
                    + " | Cost: " + listOfArmors.get(i).getBuyCost()
                    + " | Has " + listOfArmors.get(i).getDefence() + " defense.");
        }
    }
}
