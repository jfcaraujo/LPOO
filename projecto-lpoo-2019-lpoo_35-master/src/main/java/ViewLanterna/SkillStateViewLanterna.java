package ViewLanterna;

import Model.Skill;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class SkillStateViewLanterna extends HeroStateViewLanterna {
    private final List<Skill> skills;

    public SkillStateViewLanterna(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public void draw(TextGraphics graphics, int width) {
        drawSentence(graphics, width, 19, "List of skills:");
        Skill s;
        for (int i = 0; i < skills.size(); i++) {
            s = skills.get(i);
            drawSentence(graphics, width, 20 + i, (i + 1) + ": " + s.getName()
                    + " | Power: " + s.getAttackPower()
                    + " | Cost: " + s.getManaCost());
        }
    }
}
