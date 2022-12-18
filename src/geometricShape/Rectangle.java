package geometricShape;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
// 318469830 Shilo Padael
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class Rectangle {
    private final Line leftLine, rightLine, upperLine, downLine;
    private Point upperleft, upperRight, downLeft, downRight;
    private final List<Line> rectangleLines;
    private double height, width;
    private Color color;

    /**
     * this constructor specifies rectangle by 4 lines.
     * @param upperLeft shape.Point.
     * @param width double.
     * @param height double.
     * @param color Color.
     */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        double x = upperLeft.getX();
        double y = upperLeft.getY();
        Point upperRight = new Point(x + width, y);
        Point downLeft = new Point(x, y + height);
        Point downRight = new Point(x + width, y + height);
        List<Line> rec = new ArrayList<>();
        leftLine = new Line(upperLeft, downLeft);
        rightLine = new Line(upperRight, downRight);
        upperLine = new Line(upperLeft, upperRight);
        downLine = new Line(downLeft, downRight);
        rec.add(leftLine);
        rec.add(rightLine);
        rec.add(upperLine);
        rec.add(downLine);
        rectangleLines = rec;
        this.width = width;
        this.height = height;
        this.upperleft = upperLeft;
        this.color = color;

    }

    /**
     * this constructor specifies rectangle by 4 lines.
     * @param upperLeft shape.Point.
     * @param width double.
     * @param height double
     */
    public Rectangle(Point upperLeft, double width, double height) {
        double x = upperLeft.getX();
        double y = upperLeft.getY();
        List<Line> rec = new ArrayList<>();
        leftLine = new Line(upperLeft, new Point(x, y + height));
        rightLine = new Line(new Point(x + width, y), new Point(x + width, y + height));
        upperLine = new Line(upperLeft, new Point(x + width, y));
        downLine = new Line(x, y + height, x + width, y + height);
        rec.add(leftLine);
        rec.add(rightLine);
        rec.add(upperLine);
        rec.add(downLine);
        rectangleLines = rec;
        this.width = width;
        this.height = height;
        this.upperleft = upperLeft;
        this.color = Color.RED;

    }

    /**
     * This method check the intersection points between the rectangles and the specified line.
     * <p>
     *     Check each line of the rectangle (up, down, left and right sides).
     *     By using the functions of finding intersections points between two lines(in shape.Line class).
     * </p>
     * @param line shape.Line.
     * @return List, the intersections points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<>();
        for (Line l: this.rectangleLines) {
            if (l.isIntersecting(line)) {
                points.add(l.findInsrtPoint(l, line));
            }
        }
        return points;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) {
            return false;
        }
        // return true if their upper left point is the same, height and width.
        return this.upperleft.equals(((Rectangle) o).upperleft)
                && this.width == ((Rectangle) o).getWidth()
                && this.height == ((Rectangle) o).height;
    }

    /**
     *
     * @return double, return the width.
     */
    public double getWidth() {

        return upperLine.length();
    }

    /**
     *
     * @return shape.Point.
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     *
     * @return shape.Point.
     */
    public Point getDownLeft() {
        return downLeft;
    }
    /**
     *
     * @return shape.Point.
     */
    public Point getDownRight() {
        return downRight;
    }
    /**
     *
     * @return double, return the height.
     */
    public double getHeight() {
        return leftLine.length();
    }
    /**
     *
     * @return double, returns the upper-left point of the rectangle.
     */
    public Point getUpperleft() {
        return upperleft;
    }
    // Returns list of the rectangle lines.
    /**
     *
     * @return double, returns list of the rectangle lines.
     */
    public List<Line> getRectangleLines() {
        return rectangleLines;
    }

    /**
     *
     * @return Color.
     */
    public Color getColor() {
        return this.color;
    }
    /**
     *
     * @return shape.Line.
     */
    public Line getLeftLine() {
        return leftLine;
    }
    /**
     *
     * @return shape.Line.
     */
    public Line getRightLine() {
        return rightLine;
    }
    /**
     *
     * @return shape.Line.
     */
    public Line getUpperLine() {
        return upperLine;
    }
    /**
     *
     * @return shape.Line.
     */
    public Line getDownLine() {
        return downLine;
    }

    /**
     *
     * @param color Color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * This method draw rectangle on the given surface.
     * @param surface surface.
     * @param rectangle shape.Rectangle.
     */
    public void drawOn(DrawSurface surface, Rectangle rectangle) {
        surface.setColor(rectangle.getColor());
        surface.fillRectangle((int) rectangle.upperleft.getX(), (int) rectangle.upperleft.getY(),
                (int) rectangle.upperLine.length(), (int) rectangle.leftLine.length());
        surface.setColor(Color.black);
        surface.drawRectangle((int) rectangle.upperleft.getX(), (int) rectangle.upperleft.getY(),
                (int) rectangle.upperLine.length(), (int) rectangle.leftLine.length());    }

}