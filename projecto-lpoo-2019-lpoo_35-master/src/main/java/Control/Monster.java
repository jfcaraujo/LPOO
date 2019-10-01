package Control;

import ViewLanterna.MonsterViewLanterna;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    private final int level;
    private int hp;
    private final int goldDropped;
    private final int expDropped;
    private final List<Integer> stats = new ArrayList<>();
    private final MonsterViewLanterna view = new MonsterViewLanterna();

    public Monster(int level) {
        int x = 9 + level;
        this.level = level;
        stats.add(x);//attack
        stats.add(x);//defense
        stats.add(x);//agility
        stats.add(x);//vitality=max hp
        hp = stats.get(3) * 2;
        goldDropped = level * 25;
        expDropped = goldDropped;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean updateHealth() {
        if (hp <= 0) {
            hp = 0;
            return true;
        } else return false;
    }

    public int getGoldDropped() {
        return goldDropped;
    }

    public int getExpDropped() {
        return expDropped;
    }

    public List<Integer> getStats() {
        return stats;
    }


    public MonsterViewLanterna getView() {
        return view;
    }
}
