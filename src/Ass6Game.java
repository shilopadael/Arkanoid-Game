import Animation.AnimationRunner;
import Levels.DirectHit;
import Levels.FinalFour;
import Levels.Green;
import Levels.WideEasy;
import Levels.LevelInformation;
import arkadinGame.GameFlow;
import counter.Counter;
import notification.ScoreTrackingListener;
import sprites.Lives;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class Ass6Game {
    /**
     * This main run the game.
     * @param args String[].
     */
    public static void main(String[] args) {
        List<LevelInformation> levelInformations = new ArrayList<>();

        for (String srt: args) {
            try {
                if (Integer.parseInt(srt) == 1) {
                    levelInformations.add(new DirectHit());
                }
                if (Integer.parseInt(srt) == 2) {
                    levelInformations.add(new WideEasy());
                }
                if (Integer.parseInt(srt) == 3) {
                    levelInformations.add(new Green());
                }
                if (Integer.parseInt(srt) == 4) {
                    levelInformations.add(new FinalFour());
                }
            } catch (Exception ignored) {
            }
        }
        if (levelInformations.size() == 0) {
            levelInformations.add(new DirectHit());
            levelInformations.add(new WideEasy());
            levelInformations.add(new Green());
            levelInformations.add(new FinalFour());
        }
        AnimationRunner animationRunner = new AnimationRunner();
        GameFlow gameFlow = new GameFlow(animationRunner, animationRunner.getGui().getKeyboardSensor(),
                new ScoreTrackingListener(new Counter("SC", 10000)), new Lives(new Counter("Live", 7)));
        gameFlow.runLevels(levelInformations);
    }
}
