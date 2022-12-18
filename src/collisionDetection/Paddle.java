// 318469830 Shilo Padael
package collisionDetection;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
import arkadinGame.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometricShape.Line;
import geometricShape.Point;
import geometricShape.Rectangle;
import geometricShape.ball.Ball;
import geometricShape.ball.Velocity;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;

/**
 *Class to make collisionDetection.Paddle gor the arkadinGame.Game.
 */
public class Paddle implements Sprite, Collidable {
    private final int paddleSpeed;
    private biuoop.KeyboardSensor keyboard;
    private Rectangle paddle;
    private Rectangle border;
    private ArrayList<Line> region;

    /**
     *
     * @param keyboard KeyboardSensor.
     * @param border shape.Rectangle, rectangle with the size of the screen.
     * @param color Color.
     * @param pad shape.Rectangle.
     * @param paddleSpeed int
     */
    public Paddle(KeyboardSensor keyboard, Rectangle border, Color color, Rectangle pad, int paddleSpeed) {
        this.keyboard = keyboard;
        this.paddle = pad;
        paddle.setColor(color);
        region = paddleToLines();
        this.border = border;
        this.paddleSpeed = paddleSpeed;
    }

    /**
     * This method creat five line in the upper line in the rectangle.
     * @return ArrayList.
     */
    private ArrayList<Line> paddleToLines() {
        ArrayList<Line> reg = new ArrayList<Line>();
        double fifthPad = paddle.getWidth() / 5;
        double leftSideOfFifth = paddle.getUpperleft().getX();
        double yCorOfPaddle = paddle.getUpperleft().getY();
        // loop for making 5 lines.
        for (int i = 0; i < 5; i++) {
            Line line = new Line(new Point(leftSideOfFifth, yCorOfPaddle),
                    new Point(leftSideOfFifth + fifthPad, yCorOfPaddle));
            leftSideOfFifth += fifthPad;
            reg.add(line);
        }
        return reg;
    }

    /**
     * This method move the paddle to the left in each press in the key.
     */
    public void moveLeft() {
        // if paddle next step is in the borders.
        if (paddle.getUpperleft().getX() - paddleSpeed >= border.getUpperleft().getX() + 25) {
            paddle = new Rectangle(new Point(paddle.getUpperleft().getX() - paddleSpeed, paddle.getUpperleft().getY()),
                    paddle.getWidth(), paddle.getHeight(), paddle.getColor());
            ArrayList<Line> reg = new ArrayList<Line>();
            // change the lines positions.
            for (Line line : region) {
                line = new Line(line.start().getX() - paddleSpeed, line.start().getY(),
                        line.end().getX() - paddleSpeed, line.end().getY());
                reg.add(line);
            }
            region = reg;
        }

    }

    /**
     * This method move the paddle to the right in each press in the key.
     */
    public void moveRight() {
        // if paddle next step is in the borders.
        if (paddle.getUpperleft().getX() + paddle.getWidth() + paddleSpeed
                <= border.getRightLine().start().getX() - 24) {
            paddle = new Rectangle(new Point(paddle.getUpperleft().getX() + paddleSpeed, paddle.getUpperleft().getY()),
                    paddle.getWidth(), paddle.getHeight(), paddle.getColor());
            // change the lines positions.
            ArrayList<Line> reg = new ArrayList<Line>();
            for (Line line : region) {
                line = new Line(line.start().getX() + paddleSpeed, line.start().getY(),
                        line.end().getX() + paddleSpeed, line.end().getY());
                reg.add(line);
            }
            region = reg;
        }
    }

    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }
    @Override
    public void drawOn(DrawSurface d) {
        paddle.drawOn(d, paddle);
    }

    /**
     *
     * @return shape.Rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return paddle;
    }
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // if the collision point is under the upper line.
        if (collisionPoint.getY() < this.paddle.getUpperleft().getY()) {
            Block block = new Block(this.getCollisionRectangle());
            return block.hit(hitter, collisionPoint, currentVelocity);
        }
        Velocity vel = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());

        if (collisionPoint.getY() > this.paddle.getUpperleft().getY()) {
            Block block = new Block(this.getCollisionRectangle());
            return block.hit(hitter, collisionPoint, currentVelocity);
        }
        double angle = calculateAngel(collisionPoint);
        if (angle == 3) {
            Block block = new Block(paddle);
            return block.hit(hitter, collisionPoint, currentVelocity);
        } else {
            vel = Velocity.fromAngleAndSpeed(angle, currentVelocity.getAvgSpeed());
            return vel;
        }

    }

    /**
     * This method calculate the angle, depend on which line the ball collide.
     * @param collisionPoint shape.Point.
     * @return double, the angle.
     */
    private double calculateAngel(Point collisionPoint) {
        int i = 1;
        for (Line l: region) {
            if (Line.commonPoint(l, collisionPoint)) {
                break;
            }
            i += 1;
        }
        if (i == 1) {
            return 60 + 90;
        }
        if (i == 2) {
            return 30 + 90;
        }
        if (i == 3) {
            return 3;
        }
        if (i == 4) {
            return 30;
        }
        if (i == 5) {
            return 60;
        }
        return 0;
    }
    // Add this paddle to the game.

    /**
     * Add this paddle to the game.
     * @param g arkadinGame.Game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * @param g GameLevel
     */
    public void removePaddle(GameLevel g) {
        g.removeSprite(this);
        g.removeCollidable(this);
    }

}