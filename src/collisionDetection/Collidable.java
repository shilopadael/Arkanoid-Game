package collisionDetection;
// 318469830 Shilo Padael

import geometricShape.Point;
import geometricShape.Rectangle;
import geometricShape.ball.Ball;
import geometricShape.ball.Velocity;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public interface Collidable {
    // Return the "collision shape" of the object.

    /**
     *
     * @return shape.Rectangle,the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

//     Notify the object that we collided with it at collisionPoint with
//     a given velocity.
//     The return is the new velocity expected after the hit (based on
//     the force the object inflicted on us).

    /**
     * This method change velocity to the collided object.
     * <p>
     *     the object that we collided with it at collisionPoint with
     *      a given velocity.
     *      The return is the new velocity expected after the hit (based on
     *      the force the object inflicted on us).
     * </p>
     * @param hitter Ball.
     * @param collisionPoint shape.Point.
     * @param currentVelocity geometricShape.ball.Velocity.
     *
     * @return geometricShape.ball.Velocity, the updated velocity respectively to the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}