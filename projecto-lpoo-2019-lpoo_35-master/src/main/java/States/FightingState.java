package States;

import Control.Hero;
import Control.Map;
import ViewLanterna.FightingStateViewLanterna;
import ViewLanterna.HeroStateViewLanterna;
import ViewLanterna.SkillStateViewLanterna;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class FightingState implements HeroState {

    private FightingStateViewLanterna view = new FightingStateViewLanterna();

    @Override
    public void processKey(KeyStroke key, Hero hero, Map map) {
        if (key.getKeyType() == KeyType.Character)
            switch (key.getCharacter()) {
                case 'a':
                    map.basicAttack();
                    map.combat();
                    break;
                case 's':
                    if (hero.getModel().getSkills().size() == 0)
                        System.out.println("You don't have skills yet.");
                    else {
                        map.getModel().setState(new SkillState());
                        map.getModel().getState().setView(new SkillStateViewLanterna(hero.getModel().getSkills()));
                    }
                    break;
                case 'r':
                    if (map.wasAbleToRun())
                        prev(map);
                    else map.combat();
                    break;
            }
        if (map.updateMonsterHealth(hero))
            prev(map);
    }

    @Override
    public void prev(Map map) {
        map.getModel().setState(new RoamingState());
    }

    public FightingStateViewLanterna getView() {
        return view;
    }

    @Override
    public void setView(HeroStateViewLanterna view) {
        this.view = (FightingStateViewLanterna) view;
    }
}
