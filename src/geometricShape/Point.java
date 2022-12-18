// 318469830 Shilo Padael
package geometricShape;
import biuoop.DrawSurface;

/**
 *This class define shape.Point. each shape.Point contains dx and dy.
 */
public class Point {
    static final double COMPARISON_THRESHOLD = 0.00000000001;
    private double x;
    private double y;

    /**
     *Constructor for shape.Point class, that composed of x-Coordinate and y-Coordinate.
     *
     * @param x the x Coordinate.
     * @param y the y Coordinate.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     *This methos measure the distance between two points.
     *
     * @param other The given point.
     * @return double.
     */
    public double distance(Point other) {
        return Math.sqrt((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y));
    }

    /**
     *This method check if two points are equal, with comparison threshold.
     *
     * @param other the given point.
     * @return boolean , true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        double dx = Math.abs(x - other.x);
        double dy = Math.abs(y - other.y);
//        System.out.println(dx + " " + dy);
        return dx >= 0 && dx <= COMPARISON_THRESHOLD && dy >= 0 && dy <= COMPARISON_THRESHOLD;
    }

    /**
     * @return double, x-Coordinate  values of this point.
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @return double, y-Coordinate  values of this point.
     */
    public double getY() {
        return y;
    }

    /**
     * @param x double.
     */
    public  void  setX(double x) {
        this.x = x;
    }

    /**
     *
     * @param y double.
     */
    public  void  setY(double y) {
        this.y = y;
    }

    /**
     *
     * @param p1 shape.Point.
     * @param d DrawSurface.
     * @param color Color.
     * @param radius int.
     */
    public void drawCircle(Point p1, DrawSurface d, java.awt.Color color, int radius) {
        if (p1 == null || d == null || color == null) {
            return;
        }
        d.setColor(color);
        d.fillCircle((int) p1.getX(), (int) p1.getY(), radius);

    }

}