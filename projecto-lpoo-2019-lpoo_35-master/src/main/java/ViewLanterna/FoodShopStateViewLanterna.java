package ViewLanterna;

import Model.Food;
import Model.ListOfEverything;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class FoodShopStateViewLanterna extends HeroStateViewLanterna {

    private final ListOfEverything theOneList = new ListOfEverything();
    private final List<Food> listOfFood = theOneList.getFood();

    @Override
    public void draw(TextGraphics graphics, int width) {
        drawSentence(graphics, width, 19, "List of items for sale:");
        for (int i = 0; i < listOfFood.size(); i++) {
            drawSentence(graphics, width, 20 + i, (i + 1) + ": " + listOfFood.get(i).getName()
                    + " | Cost: " + listOfFood.get(i).getBuyCost()
                    + " | Restores " + listOfFood.get(i).getLevel() * 10 + " hunger.");
        }
    }
}
