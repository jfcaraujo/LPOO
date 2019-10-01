package ViewLanterna;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class HeroStateViewLanterna {

    void drawSentence(TextGraphics graphics, int width, int height, String s) {
        graphics.setForegroundColor(TextColor.ANSI.DEFAULT);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(new TerminalPosition(width + 5, height), s);
    }

    public abstract void draw(TextGraphics graphics, int width);//, Hero hero);
}
