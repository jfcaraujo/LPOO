package Control;

import Control.Map;
import Control.Position;
import Model.MapModel;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestMap {
    @Test
    public void testMapMoveHero(){
        Map map = new Map(50,24);
        MapModel mapModel = map.getModel();

        Position position1 = new Position(0,0);
        map.moveHero(position1);

        assertNotEquals(position1, mapModel.getHero().getModel().getPosition());        /* Try to move to a wall position */

        Position position2 = new Position(2,2);
        map.moveHero(position2);

        assertEquals(position2, mapModel.getHero().getModel().getPosition());           /*try to move to a valid position */

        assertEquals(new Position(2,3),mapModel.getHero().getModel().getPosition().moveDown());
        assertEquals(new Position(2,1),mapModel.getHero().getModel().getPosition().moveUp());
        assertEquals(new Position(3,2),mapModel.getHero().getModel().getPosition().moveRight());
        assertEquals(new Position(1,2),mapModel.getHero().getModel().getPosition().moveLeft());
    }
/*
    @Test
    public void testMapBasicAttack(){
        Map map = new Map(50,24);

        Position position1 = new Position(5,5);
        map.moveHero(position1);

        assertFalse(map.checkDead());

        map.combat();
        map.basicAttack();

        assertEquals(12,map.getModel().getMonster().getHp());
        assertEquals(57,map.getModel().getHero().getModel().getHp());

        Position position2 = new Position(48,22);
        map.moveHero(position1);
    }
*/


}
