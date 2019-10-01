package ViewLanterna;

import Control.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class WallViewLanterna extends ElementViewLanterna {

    @Override
    public void drawDiscovered(TextGraphics graphics, Position position) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF5722"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), " ");
    }

}
