package ViewLanterna;

import com.googlecode.lanterna.graphics.TextGraphics;

public class CityStateViewLanterna extends HeroStateViewLanterna {

    @Override
    public void draw(TextGraphics graphics, int width) {
        drawSentence(graphics, width, 19, "Heal(h)");
        drawSentence(graphics, width, 20, "Shop(s)");
    }
}
