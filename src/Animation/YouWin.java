package Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class YouWin implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;

    /**
     * @param k KeyboardSensor
     * @param score int
     */
    public YouWin(KeyboardSensor k, int score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(150, d.getHeight() / 2, "You Win!", 100);
        d.drawText(220, (d.getHeight() / 2) + 50,
                String.format("Your score is: %s", score), 30);

    }
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}