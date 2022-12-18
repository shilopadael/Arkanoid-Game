package arkadinGame;

import collisionDetection.Block;
import geometricShape.ball.Ball;
import notification.HitListener;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class PrintingHitListener implements HitListener {
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}