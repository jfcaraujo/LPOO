package ViewLanterna;

import com.googlecode.lanterna.graphics.TextGraphics;

public class ShopStateViewLanterna extends HeroStateViewLanterna {

    @Override
    public void draw(TextGraphics graphics, int width) {
        drawSentence(graphics, width, 19, "Food Shop(f)");
        drawSentence(graphics, width, 20, "Weapon Shop(w)");
        drawSentence(graphics, width, 21,  "Armor Shop(a)");

    }
}
