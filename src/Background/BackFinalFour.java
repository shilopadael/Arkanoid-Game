package Background;

import biuoop.DrawSurface;
import collisionDetection.Block;
import geometricShape.Point;
import sprites.Sprite;
import geometricShape.Rectangle;
import java.awt.Color;
import java.awt.Polygon;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class BackFinalFour implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        Color color = new Color(14, 227, 234);
        Block block = new Block(new geometricShape.Rectangle(new Point(20, 20), 800, 600, color));
        block.drawOn(d);
        sky(d, new Point(150, 400));
        sky(d, new Point(550, 400));
        lines1(d);
        lines2(d);

    }
    private void sky(DrawSurface d, Point p) {
        Color color = new Color(224, 235, 255);
        d.setColor(color);
        d.fillCircle((int) p.getX(), (int) p.getY(), 30);
        d.setColor(new Color(230, 251, 255));
        d.fillCircle((int) p.getX() + 20, (int) p.getY() - 15, 30);
        d.setColor(new Color(232, 242, 255));
        d.fillCircle((int) p.getX() + 40, (int) p.getY() + 15, 30);
        d.setColor(new Color(195, 210, 210));
        d.fillCircle((int) p.getX() + 55, (int) p.getY() - 10, 30);
        d.setColor(Color.white);
        for (int i = 10; i < 70; i++) {
            Block block = new Block(new Rectangle(new Point(p.getX() + i + 10, p.getY()), 2, 80, Color.white));


        }

    }
    private void lines1(DrawSurface d) {
        int round = 0;
        d.setColor(Color.white);
        for (int i = 0; i < 10; i++) {
            int[] x1Left = {150 - 20 + round, 152 - 20 + round, 400 - 20 + round, 402 - 20 + round};
            int[] y1Left = {400, 402, 1110, 1110};
            round += 10;
            d.fillPolygon(new Polygon(x1Left, y1Left, 4));
        }
    }
    private void lines2(DrawSurface d) {
        int round = 0;
        d.setColor(Color.white);
        for (int i = 0; i < 10; i++) {
            int[] x1Left = {550 - 20 + round, 550 - 20 + round, 800 - 20 + round, 802 - 20 + round};
            int[] y1Left = {400, 402, 1110, 1110};
            round += 10;
            d.fillPolygon(new Polygon(x1Left, y1Left, 4));
        }
    }

    @Override
    public void timePassed() {

    }
}
