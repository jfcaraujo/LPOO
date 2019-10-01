package ViewLanterna;

import Control.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class EndViewLanterna extends ElementViewLanterna {

    @Override
    public void drawDiscovered(TextGraphics graphics, Position position) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "E");
    }

}
