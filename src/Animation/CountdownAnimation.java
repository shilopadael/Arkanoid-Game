package Animation;

import biuoop.DrawSurface;
import sprites.SpriteCollection;
import biuoop.Sleeper;

import java.awt.Color;




/**
 *  The CountdownAnimation will display the given gameScreen,
 *  for numOfSeconds seconds, and on top of them it will show
 *  a countdown from countFrom back to 1, where each number will
 *  appear on the screen for (numOfSeconds / countFrom) seconds, before
 *  it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private int countFrom;
    private double numOfSeconds;
    private SpriteCollection gameScreen;
    private int counter;
    private boolean stop;
    private double sigma;
    private AnimationRunner runner;

    /**
     *
     * @param numOfSeconds double
     * @param countFrom int
     * @param gameScreen SpriteCollection
     * @param runner AnimationRunner
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, AnimationRunner runner) {
        this.countFrom = countFrom;
        this.numOfSeconds = numOfSeconds;
        this.gameScreen = gameScreen;
        counter = 0;
        stop = false;
        sigma = (numOfSeconds / countFrom);
        this.runner = runner;



    }

    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        gameScreen.drawAllOn(d);
        Color color1 = new Color(17, 24, 134);

        d.setColor(color1);
        if (counter == 0) {
            counter++;
            return;
        }
        d.drawText(250, d.getHeight() / 2, String.format("%s . .", countFrom), 120);
        sleeper.sleepFor((long) (1000 * sigma));


        countFrom -= 1;
        counter++;
        if (countFrom == 0) {
            stop = true;
            return;
        }
    }
    @Override
    public boolean shouldStop() {
        return stop;
    }
}