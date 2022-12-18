package notification;

import collisionDetection.Block;
import counter.Counter;
import geometricShape.ball.Ball;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * @param scoreCounter Counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
       currentScore.increase(5);
    }

    /**
     * @return Counter.
     */
    public Counter getCurrentScore() {
        return currentScore;
    }
}