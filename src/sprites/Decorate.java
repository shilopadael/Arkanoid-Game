package sprites;

import arkadinGame.GameLevel;
import biuoop.DrawSurface;
import collisionDetection.Block;
import collisionDetection.Collidable;
import geometricShape.Point;
import geometricShape.Rectangle;
import geometricShape.ball.Ball;
import geometricShape.ball.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class Decorate the game, with a big smile.
 */
public class Decorate implements Sprite, Collidable {
    private DrawSurface drawSurface;
    private GameLevel gameLevel;
    private List<Ball> ballList;

    /**
     * Take a DrawSurface and draw om the given gui.
     * @param d DrawSurface.
     */
    public Decorate(DrawSurface d) {
        ballList = new ArrayList<>();
        drawSurface = d;
//        game = new Game();
//        createEyes();
//        creatBalls();

    }

    /**
     * Creat the eyes of the emoji.
     */
    private void createEyes() {
//        List<Block> coli = new ArrayList<>();
        Block eye1 = new Block(new Rectangle(new Point(430, 325), 50, 50, Color.white));
        Block eye2 = new Block(new Rectangle(new Point(330, 325), 50, 50, Color.white));
        gameLevel.addCollidable(eye1);
        gameLevel.addCollidable(eye2);

    }

    /**
     * Creat the balls of the eyes.
     * @return List.
     */
    private List<Ball> creatBalls() {
        List<Ball> balls = new ArrayList<>();
        Ball ball1 = new Ball(new Point(450, 350), 15, Color.black);
        Ball ball2 = new Ball(new Point(350, 350), 15, Color.black);
        ball1.setVelocity(2, 2);
        ball2.setVelocity(2, 2);
        gameLevel.addSprite(ball1);
        gameLevel.addSprite(ball2);
        return balls;
    }

    /**
     * Getter for the Game.
     * @return Game.
     */
    public GameLevel getGame() {
        return gameLevel;
    }

    @Override
    public void drawOn(DrawSurface d) {
        //draw circle
        d.setColor(Color.yellow);
        d.fillCircle(400, 400, 200);
        //thw out circle
        d.setColor(Color.black);
        d.drawCircle(400, 400, 200);

        // 2 eyes
        d.setColor(Color.white);
        d.fillCircle(450, 350, 30);
        d.fillCircle(350, 350, 30);
        // the black in the eye
        d.setColor(Color.black);
//        for (Ball ball: ballList) {
//            ball.drawOn(d);
//        }
        d.fillCircle(450, 350, 15);
        d.fillCircle(350, 350, 15);
        //smile
        d.setColor(Color.black);
        d.fillOval(350, 500, 150, 20);

        //draw eyes
        //draw smile

    }

    @Override
    public void timePassed() {
        for (Ball ball: ballList) {
            ball.moveOneStep();
        }

    }

    @Override
    public Rectangle getCollisionRectangle() {
        return null;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        return null;
    }
}
