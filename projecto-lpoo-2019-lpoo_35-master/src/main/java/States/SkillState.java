package States;

import Control.Hero;
import Control.Map;
import ViewLanterna.HeroStateViewLanterna;
import ViewLanterna.SkillStateViewLanterna;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class SkillState implements HeroState {
    private SkillStateViewLanterna view;

    @Override
    public void processKey(KeyStroke key, Hero hero, Map map) {
        view = new SkillStateViewLanterna(hero.getModel().getSkills());
        if (key.getKeyType() == KeyType.Character) {
            switch (key.getCharacter()) {
                case '1':
                    if (hero.getModel().getSkills().size() > 0) {
                        if (map.skillAttack(1))
                            map.combat();
                    }
                    break;
                case '2':
                    if (hero.getModel().getSkills().size() > 1) {
                        if (map.skillAttack(2))
                            map.combat();
                    }
                    break;
                case '3':
                    if (hero.getModel().getSkills().size() > 2) {
                        if (map.skillAttack(3))
                            map.combat();
                    }
                    break;
            }
        } else if (key.getKeyType() == KeyType.Escape) {
            prev(map);
        }
        if (map.updateMonsterHealth(hero))
            map.getModel().setState(new RoamingState());
    }

    @Override
    public void prev(Map map) {
        map.getModel().setState(new FightingState());
    }

    public SkillStateViewLanterna getView() {
        return view;
    }

    @Override
    public void setView(HeroStateViewLanterna view) {
        this.view = (SkillStateViewLanterna) view;
    }
}
