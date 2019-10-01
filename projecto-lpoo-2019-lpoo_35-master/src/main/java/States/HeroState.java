package States;

import Control.Hero;
import Control.Map;
import ViewLanterna.HeroStateViewLanterna;
import com.googlecode.lanterna.input.KeyStroke;

public interface HeroState {

    void processKey(KeyStroke key, Hero hero, Map map);

    void prev(Map map);

    HeroStateViewLanterna getView();

    void setView(HeroStateViewLanterna view);
}
