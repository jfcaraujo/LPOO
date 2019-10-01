package ViewLanterna;

import Control.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class WoodsViewLanterna extends ElementViewLanterna {

    @Override
    public void drawDiscovered(TextGraphics graphics, Position position) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#929292"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "W");
    }

}
