package sprites;

import biuoop.DrawSurface;
import counter.Counter;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class ScoreIndicator implements Sprite {
    private Counter counter;

    /**
     * @param counter Counter
     */
    public ScoreIndicator(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void drawOn(DrawSurface d) {
        String str = new String("Score: " + counter.getCount());
        d.drawText(360, 19, str, 20);

    }

    @Override
    public void timePassed() {

    }
}
