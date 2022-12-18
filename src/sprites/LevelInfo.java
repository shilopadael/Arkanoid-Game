package sprites;

import Levels.LevelInformation;
import biuoop.DrawSurface;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class LevelInfo implements Sprite {
    private LevelInformation levelInfo;

    /**
     * @param live LevelInformation
     */
    public LevelInfo(LevelInformation live) {
        levelInfo = live;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(500, 19, String.format("Level Name: %s", levelInfo.levelName()), 20);
    }

    @Override
    public void timePassed() {
    }
}
