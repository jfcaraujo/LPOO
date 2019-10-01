package ViewLanterna;

import Model.Element;
import Model.MapModel;
import States.FightingState;
import States.SkillState;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;

public class MapViewLanterna {

    private void drawPositions(TextGraphics graphics, ArrayList<ArrayList<Element>> positions) {
        for (ArrayList<Element> list : positions)
            for (Element element : list) {
                if (element.isDiscovered())
                    element.getView().drawDiscovered(graphics, element.getPosition());
                else element.getView().drawUndiscovered(graphics, element.getPosition());
            }
    }

    public void draw(TextGraphics graphics, MapModel map) {
        drawPositions(graphics, map.getPositions());
        if (map.getState().getClass() == SkillState.class || map.getState().getClass() == FightingState.class) {
            map.getMonster().getView().draw(graphics, map.getWidth(), map.getMonster());
        }
        map.getState().getView().draw(graphics, map.getWidth());
        map.getHero().getView().draw(graphics, map.getWidth(), map.getHero().getModel());
    }
}
