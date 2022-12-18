package Levels;

import collisionDetection.Block;
import geometricShape.ball.Velocity;
import sprites.Sprite;
import java.util.List;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public interface LevelInformation {
    /**
     * @return int
     */
    int numberOfBalls();


    /**
     * The initial velocity of each ball.
     * Note that initialBallVelocities().size() == numberOfBalls()
     * @return List.
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return int
     */
    int paddleSpeed();
    /**
     * @return int
     */
    int paddleWidth();

    /**
     * the level name will be displayed at the top of the screen.
     * @return String
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     * @return Sprite
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return List
     */
    List<Block> blocks();


    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     * @return int
     */
    int numberOfBlocksToRemove();

}