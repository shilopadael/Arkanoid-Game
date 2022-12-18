package Animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;

    /**
     * AnimationRunner.
     */
    public AnimationRunner() {
        this.framesPerSecond = 60;
        gui = new GUI("arkadinGame.Game", 800, 600);

    }

    /**
     * getter.
     * @return GUI.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * @param animation Animation.
     */
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper();
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }

    }
}
