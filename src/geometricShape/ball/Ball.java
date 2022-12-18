package geometricShape.ball;
// 318469830 Shilo Padael

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
import arkadinGame.GameLevel;
import collisionDetection.GameEnvironment;
import biuoop.DrawSurface;
import geometricShape.Point;
import geometricShape.Line;
import collisionDetection.CollisionInfo;
import sprites.Sprite;
import java.awt.Color;
/**
 *This class define ball with those members.
 *    shape.Point center;
 *    int borderDown, borderUp, borderRight, borderLeft;
 *    int radius.
 *    Color color.
 *    geometricShape.ball.Velocity velocity.
 */
public class Ball implements Sprite {
    private geometricShape.Point center;
    private final int radius;
    private final Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor give default velocity.
     * @param center shape.Point , center of the ball.
     * @param r int , radius of the ball.
     * @param color Color.
     */
    public Ball(geometricShape.Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        gameEnvironment = new GameEnvironment();
        setVelocity(Velocity.randomVelocityAngle(2));
    }
    /**
     * Constructor give default velocity.
     * @param center shape.Point , center of the ball.
     * @param r int , radius of the ball.
     * @param color Color.
     * @param gameEnvironment collisionDetection.GameEnvironment.
     */
    public Ball(geometricShape.Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
        setVelocity(Velocity.randomVelocityAngle(10));
    }
    /**
     * Constructor give default velocity.
     * @param x int , xCoordinate.
     * @param y int ,yCoordinate.
     * @param r radius.
     * @param color Color.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new geometricShape.Point(x, y);
        this.radius = r;
        this.color = color;
        gameEnvironment = new GameEnvironment();
        setVelocity(Velocity.randomVelocityAngle(5));
    }

    /**
     *
     * @param v geometricShape.ball.Velocity , (speed and angel of the ball).
     */
    public void setVelocity(Velocity v) {
        velocity = v;
    }

    /**
     *
     * @param dx double , delta x (avg speed in xCor)
     * @param dy double , delta y (avg speed in xCor)
     */
    public void setVelocity(double dx, double dy) {
        velocity = new Velocity(dx, dy);

    }

    /**
     * arkadinGame.Game environment setter.
     * @param g collisionDetection.GameEnvironment.
     */
    public void setGameEnvironment(GameEnvironment g) {
        gameEnvironment = g;
    }

    /**
     * @param gameLevel GameLevel.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }


    /**
     *
     * @return int , xCoordinate of the center.
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     *
     * @return int , yCoordinate of the center.@return
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     *
     * @return int , radius of the ball.
     */
    public int getSize() {
        return radius;
    }

    /**
     *
     * @return Color.
     */
    public java.awt.Color getColor() {
        return color;
    }
    /**
     *
     * @return geometricShape.ball.Velocity.
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     *
     * @return shape.Point.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * This method draw the ball in his petition.
     * @param surface DrawSurface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle(getX(), getY(), getSize());
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }


    /**
     * Add this ball to spriteCollisiion.
     * @param g arkadinGame.Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
    /**
     * This method move the ball one stop respectively to his position and his velocity.
     * <p>
     *     This method check where the next position of the ball.
     *     if there is no coalition points the ball will apply to his next positiont,
     *     respectively to his velocity.
     *     otherwise, there is a collision point so change his velocity respectively
     *     to his collision point.

     * </p>
     */
     public void moveOneStep() {
      // calculate the trajectory
     Line line = new Line(center, velocity.applyToPoint(center));
     CollisionInfo coliInfo = gameEnvironment.getClosestCollision(line);
     // if there is a collision point.
     if (coliInfo.collisionPoint() != null) {
         // if the ball inside the block and the collision point is in upper line
         if (Line.commonPoint(coliInfo.collisionObject().getCollisionRectangle().getUpperLine(),
                 coliInfo.collisionPoint())
         && center.getY() >= coliInfo.collisionPoint().getY()) {
             center = velocity.applyToPoint(center);
             return;
         }
         // if the ball inside the block and the collision point is in the left line
         if (Line.commonPoint(coliInfo.collisionObject().getCollisionRectangle().getLeftLine(),
                 coliInfo.collisionPoint())
                 && center.getX() >= coliInfo.collisionPoint().getX()) {
             center = velocity.applyToPoint(center);
             return;
         }
         // if the ball inside the block and the collision point is in the right line
         if (Line.commonPoint(coliInfo.collisionObject().getCollisionRectangle().getRightLine(),
                 coliInfo.collisionPoint())
                 && center.getX() <= coliInfo.collisionPoint().getX()) {
             center = velocity.applyToPoint(center);
             return;
         }
         double dxVelo = coliInfo.collisionPoint().getX() - getX() - Math.signum(velocity.getDx());
         double dyVelo = coliInfo.collisionPoint().getY() - getY() - Math.signum(velocity.getDy());
         Velocity tempVelocity = new Velocity(dxVelo, dyVelo);
         // apply the ball to almost in the collision point
         center = tempVelocity.applyToPoint(center);
         setVelocity(coliInfo.collisionObject().hit(this, coliInfo.collisionPoint(), velocity));
     // there is no collision point
     } else {
         center = velocity.applyToPoint(center);
     }
     }
}

//    public shape.Point centerToradiusV() {
//        double veloLen = center.distance(new shape.Point(center.getX() + velocity.getDx(),
//                center.getY() + velocity.getDy()));
//        double v = Math.sqrt(((center.getX()) - velocity.getDx()) * (center.getX()) - velocity.getDx())
//        + ((center.getY() - velocity.getDy()) * (center.getY() - velocity.getDy()));
//        double dyRadius = (velocity.getDy() * radius) / veloLen;
//        double dxRadius = (velocity.getDx() * radius) / veloLen;
//        double newYcor = center.getY() + velocity.getDy() + dyRadius;
//        double newXcor = center.getX() + velocity.getDx() + dxRadius;
//        return new shape.Point(newXcor, newYcor);
//    }