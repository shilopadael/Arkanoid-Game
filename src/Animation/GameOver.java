package Animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import sprites.SpriteCollection;
import java.awt.Color;

/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class GameOver implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;
    private SpriteCollection spriteCollection;

    /**
     * @param k KeyboardSensor
     * @param score int
     * @param spriteCollection SpriteCollection
     */
    public GameOver(KeyboardSensor k, int score, SpriteCollection spriteCollection) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
        this.spriteCollection = spriteCollection;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        spriteCollection.drawAllOn(d);
        Color color = new Color(52, 96, 121);
        d.setColor(color);
        d.drawText(100, d.getHeight() / 2, "Game Over!", 100);
        d.drawText(150, (d.getHeight() / 2) + 50,
                String.format("Your score is: %s", score), 50);

    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}