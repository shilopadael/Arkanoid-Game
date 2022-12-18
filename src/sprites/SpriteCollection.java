package sprites;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for all sprites in arkadinGame.Game.
 */
public class SpriteCollection {
    private List<Sprite> spriteList;

    /**
     * Constructor to creat new list of sprites.
     */
    public SpriteCollection() {
        spriteList = new ArrayList<Sprite>();
    }

    /**
     * Add sprite to sprite list.
     * @param s sprites.Sprite.
     */
    public void addSprite(Sprite s) {
        if (s != null) {
            spriteList.add(s);
        }
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {

        List<Sprite> spr = new ArrayList<Sprite>(this.spriteList);
         for (Sprite sprite: spr) {
            sprite.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d DrawSurface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite: spriteList) {
            sprite.drawOn(d);
        }
    }

    /**
     * @return List
     */
    public List<Sprite> getSpriteList() {
        return spriteList;
    }
}