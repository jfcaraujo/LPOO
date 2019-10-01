package ViewLanterna;

import Control.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class ElementViewLanterna {

    public void drawUndiscovered(TextGraphics graphics, Position position) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
            graphics.putString(new TerminalPosition(position.getX(), position.getY()), " ");
    }

    abstract void drawDiscovered(TextGraphics graphics, Position position);

}
