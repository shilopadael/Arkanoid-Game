package geometricShape;
// 318469830 Shilo Padael
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */

/**
 *This class define a segment line, that his components' is two points.
 */
public class Line {
    private final double m, b;
    private final Point point1, point2;
    private final boolean vertical;

    /**
     * Constructor, get two points and convert this two lines to linear function.
     *
     * @param start shape.Point , start position.
     * @param end   shape.Point , end Position.
     */
    public Line(Point start, Point end) {
        point1 = start;
        point2 = end;
        vertical = end.getX() - start.getX() == 0;
        m = (end.getY() - start.getY()) / (end.getX() - start.getX());
        b = (start.getY() - ((m) * start.getX()));
    }

    /**
     * Constructor, get x1,x2 ,y1,y2  and convert this 4 values to point then build linear function respectively.
     *
     * @param x1 x-Coordinate for the first point.
     * @param y1 y-Coordinate for the first point.
     * @param x2 x-Coordinate for the second point.
     * @param y2 y-Coordinate for the second point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        vertical = x2 - x1 == 0;
        m = ((y2 - y1) / (x2 - x1));
        b = (y1 - (m * x1));
    }

    /**
     * This method give the length of the line ( by measure the distance between two points).
     *
     * @return double , line length.
     */
    public double length() {
        return point1.distance(point2);
    }

    /**
     * This method give the middle point of the line.
     *
     * @return shape.Point , the middle point.
     */
    public Point middle() {
        return new Point((point1.getX() + point2.getX()) / 2, (point1.getY() + point2.getY()) / 2);

    }

    /**
     * This method give the start point of the line.
     *
     * @return shape.Point.
     */
    public Point start() {
        return point1;
    }

    /**
     * This method give the end point of the line.
     *
     * @return shape.Point.
     */
    public Point end() {
        return point2;
    }

    /**
     * This method check if point C are located on the same Range and Domain of line from A  to B and otherwise.
     * <p></p>
     * this method check two side from A->B and B->A.
     *
     * @param a shape.Point , start point of the line A->B
     * @param b shape.Point , end point of the line A->B
     * @param c shape.Point , the point that get checked if he is in the domain and the range of A->B/B->A.
     * @return boolean , true if C is in the range and domain and false otherwise.
     */
    public static boolean commonPoint(Point a, Point b, Point c) {
        return Math.max(a.getX(), b.getX()) + Point.COMPARISON_THRESHOLD >= c.getX()
                && Math.min(a.getX(), b.getX()) - Point.COMPARISON_THRESHOLD <= c.getX()
                && Math.max(a.getY(), b.getY()) + Point.COMPARISON_THRESHOLD >= c.getY()
                && Math.min(a.getY(), b.getY()) - Point.COMPARISON_THRESHOLD <= c.getY();
    }

    /**
     * This method check if point C are located on the same Range and Domain of line from A  to B and otherwise.
     * <p></p>
     * this method check two side from A->B and B->A.
     * @param l shape.Line.
     * @param c shape.Point , the point that get checked if he is in the domain and the range of A->B/B->A.
     * @return boolean , true if C is in the range and domain and false otherwise.
     */
    public static boolean commonPoint(Line l, Point c) {
        return Math.max(l.point1.getX(), l.point2.getX()) + Point.COMPARISON_THRESHOLD >= c.getX()
                && Math.min(l.point1.getX(), l.point2.getX()) - Point.COMPARISON_THRESHOLD <= c.getX()
                && Math.max(l.point1.getY(), l.point2.getY()) + Point.COMPARISON_THRESHOLD >= c.getY()
                && Math.min(l.point1.getY(), l.point2.getY()) - Point.COMPARISON_THRESHOLD <= c.getY();
    }

    /**
     * This method check if two lines are contained in each other.
     * <p></p>
     * The line can be containd only and only if they have the same b and m.
     * This function check the sum of the two lines length, if the sum is smaller the
     * then the lowest point to the greatest point, then the both line are contains each other.
     *
     * @param other shape.Line , the line that get checked with.
     * @return boolean , true if the lines are contained , false otherwise.
     */
    private boolean lineContain(Line other) {
        if (this.equals(other)) {
            return true;
        }
        if (m == other.m && b == other.b) {
            double x1 = Math.max(Math.max(Math.max(this.point1.getX(), this.point2.getX()),
                    other.point1.getX()), other.point2.getX());
            double x2 = Math.min(Math.min(Math.min(this.point1.getX(), this.point2.getX()),
                    other.point1.getX()), other.point2.getX());
            double y1 = Math.max(Math.max(Math.max(this.point1.getY(), this.point2.getY()),
                    other.point1.getY()), other.point2.getY());
            double y2 = Math.min(Math.min(Math.min(this.point1.getY(), this.point2.getY()),
                    other.point1.getY()), other.point2.getY());
            double diagonal = Math.sqrt(((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
            return diagonal - 2 * Point.COMPARISON_THRESHOLD < this.length() + other.length();
        }
        return false;


    }

    /**
     * This method check if two lines have intersection.
     * <p>
     * if lines have the same m and b , if they contain each other return true otherwise return false.
     * if lines have the same m but not b , then in any case there are not intersect.
     * if lines have different b and a then they for sure have common point,
     * then we check if this shape.Point located in both segments with the function commonPoint.
     * </p>
     *
     * @param other shape.Line , the line we compare.
     * @return boolean.
     */
    public boolean isIntersecting(Line other) {
        // line is parallel
        // check id ndeeed
        if (lineContain(other)) {
            return true;
        }
        // if two lines have the same linear function have one point in common.
        if (m == other.m && other.b == b) {
            return point1.equals(other.point1) || point1.equals(other.point2) || point2.equals(other.point1)
                    || point2.equals(other.point2);
        }
        if (m == other.m) {
            return false;
        }
        Point interPoint = findInsrtPoint(this, other);
        if (commonPoint(point1, point2, interPoint)
                && commonPoint(other.point1, other.point2, interPoint)) {
            return true;
        }
        return false;
    }

    /**
     * This method get two lines and return the inserting shape.Point.
     * <p>
     * Method check if two lines have have common point in the edges,
     * ( for external case that two lines have the sae linear function but inserted in one line
     * if lines are vertical ( we can not dividing in 0) so we check spertly the X and Y coordinate.
     * any other case return the intersection point.
     * </p>
     *
     * @param line1 shape.Line , first line.
     * @param line2 shape.Line , second line.
     * @return shape.Point , the intersection point , if lines are contained , null.
     */
    public Point findInsrtPoint(Line line1, Line line2) {
        double xCor, yCor;
//        if (!line1.isIntersecting(line2)) {
//            return null;
//        }
        if (line1.point1.equals(line2.point1)) {
            return line1.point1;
        }
        if (line1.point1.equals(line2.point2)) {
            return line1.point1;
        }
        if (line1.point2.equals(line2.point1)) {
            return line1.point2;
        }
        if (line1.point2.equals(line2.point2)) {
            return line1.point2;
        }
        if (line1.vertical || line2.vertical) {
            if (line1.vertical) {
                xCor = line1.start().getX();
                yCor = xCor * line2.m + line2.b;
            } else {
                xCor = line2.start().getX();
                yCor = xCor * line1.m + line1.b;
            }
        } else {
            xCor = (line2.b - line1.b) / (line1.m - line2.m);
            yCor = (line1.m * xCor) + line1.b;
        }
        return new Point(xCor, yCor);

    }

    /**
     * This method give the common point of two lines.
     *
     * @param other shape.Line.
     * @return shape.Point , if there is a common line. null, otherwise.
     */
    public Point intersectionWith(Line other) {
        if (this.lineContain(other)) {
            return null;
        }
        if (isIntersecting(other)) {
            return findInsrtPoint(this, other);
        }
        return null;
    }


    /**
     * This method check if two lines are equal(by checking if the two points of each line are equal).
     *
     * @param other shape.Line.
     * @return boolean , true if they are equal. false, otherwise.
     */
    public boolean equals(Line other) {
        if (point1.equals(other.point1) && point2.equals(other.point2)
                || point1.equals(other.point2) && point2.equals(other.point1)) {
            return true;
        }
        return false;
    }

    /**
     * This method take the list of the intersection points between the rectangle and this line
     * and check which point is closer to the start point by the function distance between two points.
     * @param rect shape.Rectangle.
     * @return shape.Point , the closest. null if there is no intersection point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //Maybe check the start position by the larger y.
        Point closetPoint = null;
        for (Point rec: rect.intersectionPoints(this)) {
            if (rec == null) {
                continue;
            }
            if (closetPoint == null || start().distance(rec) < start().distance(closetPoint)) {
                closetPoint = rec;
            }
        }
        return closetPoint;
    }
}
