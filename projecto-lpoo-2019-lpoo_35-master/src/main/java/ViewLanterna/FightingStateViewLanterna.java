package ViewLanterna;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class FightingStateViewLanterna extends HeroStateViewLanterna {

    @Override
    public void draw(TextGraphics graphics, int width) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(new TerminalPosition(width + 5, 19), "Attack(a)");
        graphics.putString(new TerminalPosition(width + 5, 20), "Skills(s)");
        graphics.putString(new TerminalPosition(width + 5, 21), "Run(r)");
    }
}
