package Background;

import biuoop.DrawSurface;
import collisionDetection.Block;
import geometricShape.Point;
import geometricShape.Rectangle;
import sprites.Sprite;

import java.awt.Color;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */

public class BackDirectHit implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Block block = new Block(new Rectangle(new Point(20, 20), 800, 600, Color.black));
        block.drawOn(d);
        Color color = new Color(77, 59, 29);
        Block block1 = new Block(new Rectangle(new Point(330, 400), 140, 200, color));
//        Line line1 = new Line()
        block1.drawOn(d);
        rectangelBlocks(new Point(340, 410), d);
        rectangelBlocks(new Point(340, 510), d);
//        Color fillcolor = new Color(51, 40, 24);
        rectangelBlocks(new Point(150, 200), d);
        rectangelBlocks(new Point(550, 200), d);
        Color color1 = new Color(231, 176, 106);
        Block block4 = new Block(new Rectangle(new Point(160, 210), 100, 60, color1));
        Block block5 = new Block(new Rectangle(new Point(560, 210), 100, 60, color1));
        block4.drawOn(d);
        block5.drawOn(d);
        lines(d, new Point(170, 210));
        lines(d, new Point(570, 210));
        // handle
        Block block6 = new Block(new Rectangle(new Point(342, 495), 5, 9, Color.black));
        Block block7 = new Block(new Rectangle(new Point(347, 498), 10, 2, Color.black));
        block6.drawOn(d);
        block7.drawOn(d);



    }
    private void rectangelBlocks(Point upperleftLeft, DrawSurface d) {
        Point upperleftRight = new Point(upperleftLeft.getX() + 110, upperleftLeft.getY() + 10);
        Point downLeft = new Point(upperleftLeft.getX(), upperleftLeft.getY() + 70);
        Color color = new Color(52, 44, 20);

        Block block1 = new Block(new Rectangle(upperleftLeft, 120, 10, color));
        Block block2 = new Block(new Rectangle(upperleftRight, 10, 70, color));
        Block block3 = new Block(new Rectangle(upperleftLeft, 10, 80, color));
        Block block4 = new Block(new Rectangle(downLeft, 120, 10, color));
        block1.drawOn(d);
        block2.drawOn(d);
        block3.drawOn(d);
        block4.drawOn(d);

    }
    private void lines(DrawSurface d, Point upperleft) {
        int[] arr = {0, 20, 40, 60, 80};
        for (int i = 0; i < 5; i++) {
            Block block = new Block(new Rectangle(new Point(upperleft.getX() + arr[i], upperleft.getY()), 3,
                    60, Color.black));
            block.drawOn(d);
        }
    }


    @Override
    public void timePassed() {

    }
}
