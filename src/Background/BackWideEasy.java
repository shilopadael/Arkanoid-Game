package Background;

import biuoop.DrawSurface;
import collisionDetection.Block;
import geometricShape.Point;
import geometricShape.Rectangle;
import sprites.Sprite;
import java.awt.Color;
import java.awt.Polygon;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class BackWideEasy implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Block block = new Block(new Rectangle(new Point(20, 20), 800, 600, Color.orange));
        block.drawOn(d);
        rowBlocks(d, new Point(100, 450), 8);
        rowBlocks(d, new Point(135, 410), 7);
        rowBlocks(d, new Point(170, 370), 6);
        rowBlocks(d, new Point(205, 330), 5);
        rowBlocks(d, new Point(240, 290), 4);
        rowBlocks(d, new Point(275, 250), 3);
        rowBlocks(d, new Point(310, 210), 2);
        rowBlocks(d, new Point(345, 170), 1);
        tringle(d);
        platform(d);
        sun(d);

    }
    private void rowBlocks(DrawSurface d, Point upperLeft, int num) {
        int round = 0;
        int colorIndex = 5;
        Color color1 = new Color(183 + colorIndex, 134 + colorIndex, 79 + colorIndex);
        d.setColor(color1);
        int[] xLeft = {(int) upperLeft.getX() - 35, (int) upperLeft.getX(), (int) upperLeft.getX()};
        int[] yLeft = {(int) upperLeft.getY() + 40, (int) upperLeft.getY() + 40, (int) upperLeft.getY()};


        int[] xRight = {(int) upperLeft.getX() + 70 * num + 1, (int) upperLeft.getX() + 1 + 70 * num,
                (int) upperLeft.getX() + 1 + 70 * num + 35};
        int[] yRight = {(int) upperLeft.getY(), (int) upperLeft.getY() + 40, (int) upperLeft.getY() + 40};
        d.fillPolygon(new Polygon(xLeft, yLeft, 3));
        for (int i = 0; i < num; i++) {
            Color color = new Color(183 + colorIndex, 134 + colorIndex, 79 + colorIndex);
            Block block = new Block(new Rectangle(new Point(upperLeft.getX() + round, upperLeft.getY()),
                    70, 40, color));
            round += 70;
            colorIndex += 5;
            block.drawOn(d);
            d.setColor(color);
        }
        d.fillPolygon(new Polygon(xRight, yRight, 3));
    }
    private void tringle(DrawSurface d) {
        int[] xLeft = {345 + 35, 345, 345 + 70};
        int[] yLeft = {170 - 40, 170, 170};
        d.fillPolygon(new Polygon(xLeft, yLeft, 3));
    }
    private void platform(DrawSurface d) {
        Color color = new Color(220, 142, 50);
        Block block = new Block(new Rectangle(new Point(20, 490),
                760, 200, color));
        block.drawOn(d);
    }
    private void sun(DrawSurface d) {
        int roundRadius = 0;
        int roundColor = 5;
        for (int i = 0; i < 5; i++) {
            Color color = new Color(255 - roundColor, 240 - roundRadius, roundRadius);
            d.setColor(color);
            d.fillCircle(670, 150, 40 - roundRadius);
            roundRadius += 4;
            roundColor += 15;
        }
    }


    @Override
    public void timePassed() {

    }
}
