package notification;
import collisionDetection.Block;
import geometricShape.ball.Ball;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit Block
     * @param hitter Ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}
