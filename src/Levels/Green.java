package Levels;

import Background.BackGreen;
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
public class Green implements LevelInformation {
    private List<Block> blockList = new ArrayList<>();
    private BackGreen backGreen;

    /**
     * Green.
     */
    public Green() {
        backGreen = new BackGreen();
    }

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velList = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            velList.add(Velocity.fromAngleAndSpeed((i + 2) * 32, 7));
        }
        return velList;
    }

    @Override
    public int paddleSpeed() {
        return 20;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "Green";
    }

    @Override
    public Sprite getBackground() {
        return backGreen;

    }

    @Override
    public List<Block> blocks() {
        rowOfBlocks(23, new Point(780, 170), 9);
        rowOfBlocks(28, new Point(780, 190), 8);
        rowOfBlocks(35, new Point(780, 210), 7);
        rowOfBlocks(40, new Point(780, 230), 6);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 9 + 8 + 7 + 6;
    }
    private void rowOfBlocks(int j, Point upperRight, int num) {
        upperRight.setX(upperRight.getX() - (double) 60);
        Point upperLeft = upperRight;
        Color color = GameLevel.randomColor(j);
        for (int i = 0; i < num; i++) {
            Block block = new Block(new Rectangle(upperLeft, 60, 20, color));
            this.blockList.add(block);
            upperLeft = new Point(upperLeft.getX() - (double) 60, upperLeft.getY());
            color = GameLevel.randomColor(i + 15 + j);

        }
    }

}
