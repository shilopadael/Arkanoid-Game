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
public class BackGreen implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Block block1 = new Block(new Rectangle(new Point(20, 20), 800, 600, Color.GREEN));
        d.setColor(Color.GREEN);
        block1.drawOn(d);
        Color color = new Color(168, 2, 27);
        d.setColor(color);
        Block block = new Block(new Rectangle(new Point(20, 150), 800, 160, color));
        block.drawOn(d);
        drawLeftEye(d, new Point(150, 200));
        drawRightEye(d, new Point(550, 400));


    }
    private void drawRightEye(DrawSurface d, Point upperLeft) {
//        Point bleackeye = new Point(upperLeft.getX() + 30, upperLeft.getY() + 50);
        //the white part
        d.setColor(Color.white);
        d.fillOval(550, 200, 160, 80);

        //the black art
        d.setColor(Color.black);
        d.fillCircle(600, 240, 20);
        //the green part
        Color color = new Color(57, 107, 29);
        Color color1 = new Color(168, 2, 27);

        d.setColor(color1);
        d.fillOval(550, 200, 160, 40);

    }
    private void drawLeftEye(DrawSurface d, Point upperLeft) {
        Point bleackeye = new Point(upperLeft.getX() + 30, upperLeft.getY() + 50);
        //the white part
        d.setColor(Color.white);
        d.fillOval(150, 200, 160, 80);

        //the black art
        d.setColor(Color.black);
        d.fillCircle(210, 240, 20);
        //the green part
        Color color = new Color(57, 107, 29);
        Color color1 = new Color(168, 2, 27);
        d.setColor(color1);
        d.fillOval(150, 200, 160, 40);
    }

    @Override
    public void timePassed() {

    }
}
