package Levels;

import Background.BackWideEasy;
import arkadinGame.GameLevel;
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
public class WideEasy implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velList = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            velList.add(Velocity.fromAngleAndSpeed((i + 2) * 16, 7));
        }
        return velList;
    }

    @Override
    public int paddleSpeed() {
        return 20;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new BackWideEasy();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        blockList.add(new Block(new Rectangle(new Point(380, 200), 20, 20, Color.red)));
        blockList = rowOfBlocks(20, 38, 155, new Point(780, 270), 20);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 20;
    }
    private List<Block> rowOfBlocks(double height, double width, int j, Point upperRight, int num) {
        List<Block> blockList = new ArrayList<Block>();
        upperRight.setX(upperRight.getX() - width);
        Point upperLeft = upperRight;
        Color color = GameLevel.randomColor(j);

        for (int i = 0; i < num; i++) {
            Block block = new Block(new Rectangle(upperLeft, width, height, color));
            blockList.add(block);
            upperLeft = new Point(upperLeft.getX() - width, upperLeft.getY());
            color = GameLevel.randomColor(i + 46 + j);

        }
        return blockList;
    }


}
