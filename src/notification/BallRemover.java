package notification;

import arkadinGame.GameLevel;
import collisionDetection.Block;
import counter.Counter;
import geometricShape.ball.Ball;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * @param gameLevel GameLevel.
     * @param remainingBalls Counter.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;



    }
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        //System.out.println(beingHit.getCollisionRectangle().getUpperleft().getX());
        hitter.removeFromGame(gameLevel);
        remainingBalls.decrease(1);

    }

    /**
     * @return Counter
     */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }
}
