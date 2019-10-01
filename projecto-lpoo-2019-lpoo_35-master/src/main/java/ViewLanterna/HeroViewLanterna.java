package ViewLanterna;

import Control.Position;
import Model.HeroModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class HeroViewLanterna {

    public void draw(TextGraphics graphics, int width, HeroModel hero) {
        drawHeroStats(graphics,width,hero);

        drawBar(graphics, width, 10, (int) Math.ceil(20 * hero.getExp() / (hero.getLevel() * 100)), "Exp", "#14FF14", "#009900");
        drawBar(graphics, width, 12, (int) Math.ceil(20 * hero.getHp() / (hero.getStats().get(3) * 3)), "Player health", "#14FF14", "#FF1414");
        drawBar(graphics, width, 14, (int) Math.ceil(20 * hero.getMp() / (hero.getStats().get(4) * 2)), "Player mana", "#224EBF", "#001754");
        drawBar(graphics, width, 16, 20 - (int) (Math.floor(20 * hero.getHunger() / 30)), "Hunger", "#FF9000", "#A3610B");

        drawHero(graphics, hero.getPosition());
    }

    private void drawBar(TextGraphics graphics, int width, int height, int value, String name, String color1, String color2) {
        String empty = "                    ";
        graphics.setForegroundColor(TextColor.ANSI.DEFAULT);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(new TerminalPosition(width + 5, height), name);
        graphics.setBackgroundColor(TextColor.Factory.fromString(color1));
        graphics.putString(new TerminalPosition(width + 5, height + 1), empty.substring(0, value));
        graphics.setBackgroundColor(TextColor.Factory.fromString(color2));
        graphics.putString(new TerminalPosition(width + 5 + value, height + 1), empty.substring(value));
    }

    private void drawHero(TextGraphics graphics, Position position) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "H");
        graphics.disableModifiers(SGR.BOLD);
        graphics.setForegroundColor(TextColor.ANSI.DEFAULT);
    }

    private void drawHeroStats(TextGraphics graphics, int width, HeroModel hero) {
        String s;
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.setForegroundColor(TextColor.ANSI.DEFAULT);
        graphics.putString(new TerminalPosition(width + 5, 6), "Level: " + hero.getLevel());
        graphics.putString(new TerminalPosition(width + 5, 7), "Gold: " + hero.getGold());

        if (hero.getWeapon() == null) s = "";
        else s = hero.getWeapon().getName();
        graphics.putString(new TerminalPosition(width + 5, 8), "Weapon: " + s);
        if (hero.getArmor() == null) s = "";
        else s = hero.getArmor().getName();
        graphics.putString(new TerminalPosition(width + 5, 9), "Armor: " + s);
    }
}
