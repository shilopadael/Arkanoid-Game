package Animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * @param sensor KeyboardSensor
     * @param key String
     * @param animation Animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.sensor = sensor;
        stop = false;
        isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.sensor.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        }
        isAlreadyPressed = false;

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
