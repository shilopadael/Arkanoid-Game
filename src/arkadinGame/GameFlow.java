package arkadinGame;

import Animation.AnimationRunner;
import Animation.KeyPressStoppableAnimation;
import Animation.YouWin;
import Levels.LevelInformation;
import biuoop.KeyboardSensor;
import notification.ScoreTrackingListener;
import sprites.LevelInfo;
import sprites.Lives;
import java.util.List;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */

public class GameFlow {
    private ScoreTrackingListener scoreIndicator;
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private int counter;
    private LevelInfo levelDraw;
    private Lives lives;

    /**
     * @param ar AnimationRunner
     * @param ks KeyboardSensor
     * @param stl ScoreTrackingListener
     * @param lives Lives
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, ScoreTrackingListener stl, Lives lives) {
        scoreIndicator = stl;
        keyboardSensor = ks;
        animationRunner = ar;
        this.lives = lives;


    }

    /**
     * @param levels List
     */
    public void runLevels(List<LevelInformation> levels) {
        counter = levels.size();

        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.scoreIndicator, this.keyboardSensor,
                    this.animationRunner, this.lives);

            level.initialize();
            level.run();

            while (level.getBallRemover().getRemainingBalls().getCount() > 0
                    && level.getBlockRemover().getRemainingBlocks().getCount() > 0) {
                level.run();
            }
            if (level.getBallRemover().getRemainingBalls().getCount() <= 0) {
                break;
            }
            counter--;
        }

        if (counter <= 0) {
            this.animationRunner.run(new KeyPressStoppableAnimation(keyboardSensor,
                    KeyboardSensor.SPACE_KEY, new YouWin(this.keyboardSensor,
                    scoreIndicator.getCurrentScore().getCount())));
            animationRunner.getGui().close();
        }
        animationRunner.getGui().close();


    }
}
