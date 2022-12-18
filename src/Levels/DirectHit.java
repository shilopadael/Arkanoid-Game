package Levels;

import Background.BackDirectHit;
import collisionDetection.Block;
import geometricShape.Point;
import geometricShape.Rectangle;
import geometricShape.ball.Velocity;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class DirectHit implements LevelInformation {
    private BackDirectHit backDirectHit;

    /**
     * DirectHit.
     */
    public DirectHit() {
        backDirectHit = new BackDirectHit();
    }

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velList = new ArrayList<>();
        velList.add(Velocity.fromAngleAndSpeed(91, 10));
        return velList;
    }

    @Override
    public int paddleSpeed() {
        return 15;
    }

    @Override
    public int paddleWidth() {
        return 140;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return backDirectHit;
//        return new Block(new Rectangle(new Point(20, 20), 800 , 600, Color.black));
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(new Rectangle(new Point(380, 200), 20, 20, Color.yellow)));
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

}
