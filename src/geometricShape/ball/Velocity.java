// 318469830 Shilo Padael
package geometricShape.ball;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */

import geometricShape.Point;

import java.util.Random;

/**
 *This class define speed and angle.
 */
public class Velocity {
    private double avgSpeed, dx, dy;
    // constructor

    /**
     * @param dx double , delta x( progress in the xCor).
     * @param dy double , delta y( progress in the yCor).
     */
    public Velocity(double dx, double dy) {
        avgSpeed = Math.sqrt((dx * dx) + (dy * dy));
        this.dx = dx;
        this.dy = dy;
    }

    /**
     *
     * @return velocity dx.
     */
    public double getDx() {
        return dx;
    }

    /**
     *
     * @return velocity dy.
     */
    public double getDy() {
        return dy;
    }

    /**
     *
     * @return velocity avgSpeed.
     */
    public double getAvgSpeed() {
        return avgSpeed;
    }

    /**
     *Set new velocity dx.
     * @param dx double.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     *Set new velocity dy.
     * @param dy double.
     */
    public void setYx(double dy) {
        this.dy = dy;
    }

    /**
     *Set new velocity avgSpeed.
     * @param avgSpeed double
     */
    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed =  avgSpeed;
    }
    /**
     * Calculate the sx and dy with Pythagoras.
     * @param angle double.
     * @param speed double.
     * @return geometricShape.ball.Velocity object.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radAngle = (angle * Math.PI / 180);
        double dx = speed * Math.cos(radAngle);
        double dy = -speed * Math.sin(radAngle);
        return new Velocity(dx, dy);
    }
    /**
     * This method get speed and calculate a random angel then return geometricShape.ball.Velocity.
     * @param speed int.
     * @return geometricShape.ball.Velocity.
     */
    public static Velocity randomVelocityAngle(int speed) {
        Random rand = new Random();
        int degree = rand.nextInt(180);
        return Velocity.fromAngleAndSpeed(degree, speed);

    }

    /**
     * this method taking a point with position (x,y) and return a new point.
     * @param p shape.Point.
     * @return shape.Point.
     */
    public Point applyToPoint(Point p) {
        double xCor = p.getX();
        double yCor = p.getY();
        return new Point(xCor + dx, yCor + dy);
    }

}