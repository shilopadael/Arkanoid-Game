// 318469830 Shilo Padael
package collisionDetection;


import geometricShape.Point;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     *
     * @param collisionPoint shape.Point.
     * @param collisionObject collisionDetection.Collidable.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }
    // the point at which the collision occurs.

    /**
     *
     * @return shape.Point, the point at which the collision occurs.
     */
    public Point collisionPoint() {
        if (collisionPoint != null) {
            return collisionPoint;
        }
        return null;
    }
    // the collidable object involved in the collision.

    /**
     *
     * @return collisionDetection.Collidable, the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}