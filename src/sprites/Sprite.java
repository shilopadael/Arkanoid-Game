package sprites;

import biuoop.DrawSurface;

/**
 * This interface collect all sprite classes.
 * and with when method know when to draw them.
 */
public interface Sprite {
    /**
     * This method draw the sprite to the screen.
     * @param d DrawSurface.
     */
    void drawOn(DrawSurface d);

    /**
     * This method notify the sprite that time has passed.
     */
    void timePassed();
}