package ViewLanterna;

import Control.Monster;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MonsterViewLanterna {
    public void draw(TextGraphics graphics, int width, Monster monster) {
        String empty = "                    ";
        graphics.setForegroundColor(TextColor.ANSI.DEFAULT);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(new TerminalPosition(width + 5, 1), "Level: " + monster.getLevel());

        int health = (int) Math.ceil(20.0 * monster.getHp() / monster.getStats().get(3) / 2.0);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(new TerminalPosition(width + 5, 2), "Monster health");
        graphics.setBackgroundColor(TextColor.Factory.fromString("#14FF14"));
        graphics.putString(new TerminalPosition(width + 5, 3), empty.substring(0, health));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF1414"));
        graphics.putString(new TerminalPosition(width + 5 + health, 3), empty.substring(health));
    }

}
