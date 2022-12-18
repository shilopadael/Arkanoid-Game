package Levels;

import Background.BackFinalFour;
import collisionDetection.Block;
import geometricShape.Point;
import geometricShape.Rectangle;
import geometricShape.ball.Velocity;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 /**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class FinalFour implements LevelInformation {
    private List<Block> blockList = new ArrayList<>();
    private BackFinalFour finalFour;
    /**
     * constructor.
     */
    public FinalFour() {
        finalFour = new BackFinalFour();
    }

    @Override
    public int numberOfBalls() {
        return 3;
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return finalFour;
    }

    @Override
    public List<Block> blocks() {
        rowOfBlocks(60, 20, new Point(780, 170), 20, Color.blue);
        rowOfBlocks(60, 20, new Point(780, 210), 20, Color.gray);
        rowOfBlocks(60, 20, new Point(780, 190), 20, Color.yellow);
        rowOfBlocks(60, 20, new Point(780, 230), 20, Color.RED);
        rowOfBlocks(60, 20, new Point(780, 250), 20, Color.white);
        rowOfBlocks(60, 20, new Point(780, 270), 20, Color.orange);
        rowOfBlocks(60, 20, new Point(780, 290), 20, Color.pink);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 9 + 8 + 7 + 6;
    }
    private void rowOfBlocks(int width, int height, Point upperRight, int num, Color color) {
        upperRight.setX(upperRight.getX() - width);
        Point upperLeft = upperRight;

        for (int i = 0; i < num; i++) {
            Block block = new Block(new Rectangle(upperLeft, width, height, color));
            this.blockList.add(block);
            upperLeft = new Point(upperLeft.getX() - width, upperLeft.getY());

        }
    }

}
