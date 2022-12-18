package collisionDetection;

import geometricShape.Line;
import geometricShape.Rectangle;

import java.util.ArrayList;
import java.util.List;
// 318469830 Shilo Padael
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class GameEnvironment {
    private List<Collidable> collideList;
    /**
     * Store Collide list.
     */
    public GameEnvironment() {
        collideList = new ArrayList<Collidable>();

    }
    /**
     * Add the given collidable to the environment.
     * @param c collisionDetection.Collidable, add the given collidable to the environment.
     */
    public void addCollidable(Collidable c) {
        if (c != null && c.getCollisionRectangle() != null) {
            collideList.add(c);
        }
    }
    /**
     * Add the given collidable to the environment.
     * @param c List , add the given collidable to the environment.
     */
    public void addCollidable(List<Collidable> c) {
        if (c != null) {
            collideList.addAll(c);
        }
    }

    /**
     *
     * @return List.
     */
    public List<Collidable> getCollidList() {
        return collideList;
    }

    /**
     * This method return the cloeset point where the collision occurs.
     * <p>
     *      looping all over the object that stored as member ,
     *      If object will not collide with any of the collidables
     *      in this collection, return null. Else, return the information
     *      about the closest collision that is going to occur.
     * </p>
     * @param trajectory shape.Line, the line that the object compare with.
     * @return collisionDetection.CollisionInfo, shape.Point of the collision and the rectangle.
     */

    public CollisionInfo getClosestCollision(Line trajectory) {
        Rectangle rectangle = ((Collidable) collideList.get(0)).getCollisionRectangle();
        CollisionInfo minColibel = new CollisionInfo(trajectory.closestIntersectionToStartOfLine(rectangle),
                collideList.get(0));
        List<Collidable> collidables = new ArrayList<Collidable>(this.collideList);
        // Find the closest collision from the given trajectory.
        for (Collidable o : collidables) {
            rectangle = o.getCollisionRectangle();

            if (minColibel.collisionPoint() == null) {
                minColibel = new CollisionInfo(trajectory.closestIntersectionToStartOfLine(rectangle), o);
                continue;
            }
            CollisionInfo coll = new CollisionInfo(trajectory.closestIntersectionToStartOfLine(rectangle), o);
            if (coll.collisionPoint() == null) {
                continue;
            }

            if (coll.collisionPoint().distance(trajectory.start()) < minColibel.collisionPoint()
                    .distance(trajectory.start())) {
                minColibel = coll;
            }
        }
        return minColibel;
    }
}






//    public collisionDetection.CollisionInfo getClosestCollision(shape.Line trajectory){
//
//        CollideList.sort(new SortByClosestPointCollsion(trajectory));
////        if (CollideList.get() == null) {
////            System.out.println("hi");
////            return null;
////        }
//        shape.Point collisionPoint = trajectory.closestIntersectionToStartOfLine
//        (CollideList.get(0).getCollisionRectangle());
//        return new collisionDetection.CollisionInfo(collisionPoint, CollideList.get(0));
//    }




//    public void addBorders(List<collisionDetection.Collidable> c) {
//        if (c != null) {
//            CollideList.addAll(c);
//        }
//    }