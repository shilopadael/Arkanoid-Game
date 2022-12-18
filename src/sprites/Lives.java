package sprites;

import biuoop.DrawSurface;
import counter.Counter;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class Lives implements Sprite {
    private Counter lives;

    /**
     * @param live Counter
     */
    public Lives(Counter live) {
        lives = live;
        this.lives.increase(3);
    }

    /**
     * @return Counter
     */
    public Counter getLives() {
        return lives;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(200, 19, String.format("Lives: %d", lives.getCount()), 20);
    }

    @Override
    public void timePassed() {

    }
}
