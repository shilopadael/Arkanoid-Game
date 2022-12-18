package collisionDetection;

import arkadinGame.GameLevel;
import biuoop.DrawSurface;
import geometricShape.Line;
import geometricShape.Point;
import geometricShape.Rectangle;
import geometricShape.ball.Ball;
import geometricShape.ball.Velocity;
import notification.HitListener;
import notification.HitNotifier;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
// 318469830 Shilo Padael
/**
 * The shape of block is rectangle.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private List<HitListener> hitListeners;
    /**
     * The shape of block is rectangle.
     * @param retangel shape.Rectangle.
     */
    public Block(Rectangle retangel) {
        rectangle = retangel;
        hitListeners = new ArrayList<HitListener>();
    }
    /**
     * The shape of block is rectangle.
     * @param rec shape.Rectangle.
     * @param color Color.
     */
    Block(Rectangle rec, Color color) {
        rec.setColor(color);
        rectangle = rec;
        hitListeners = new ArrayList<HitListener>();

    }

    /**
     *
     * @param rectangle shape.Rectangle.
     */
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        if (rectangle != null) {
            return rectangle;
        }
        return null;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity vel = new Velocity(currentVelocity.getDx(), currentVelocity.getDy());
        //If collision in up shape.Line or Down shape.Line
        if (Line.commonPoint(rectangle.getUpperLine(), collisionPoint)
                || Line.commonPoint(rectangle.getDownLine(), collisionPoint)) {
            vel.setYx(-currentVelocity.getDy());
        }
        //If collision in right shape.Line or left shape.Line
        if (Line.commonPoint(rectangle.getRightLine(), collisionPoint)
                || Line.commonPoint(rectangle.getLeftLine(), collisionPoint)) {
            vel.setDx(-currentVelocity.getDx());
        }
        this.notifyHit(hitter);
        return vel;
    }

    /**
     * This method remove this block as collidible from the game.
     * @param gameLevel Game.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * @return shape.Rectangle.
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * @return List.
     */
    public List<HitListener> getListeners() {
        return hitListeners;
    }

    /**
     *
     * @param listeners List<>.
     */
    public void setListeners(List<HitListener> listeners) {
        this.hitListeners = listeners;
    }

    /**
     * @param surface DrawSurface.
     */
    public void drawOn(DrawSurface surface) {
        rectangle.drawOn(surface, this.rectangle);
    }

    @Override
    public void timePassed() {
    }

    /**
     * This method add this block to arkadinGame.Game class.
     * @param g arkadinGame.Game;
     */
    public void addToGame(GameLevel g) {
        g.addCollidable((Collidable) this);
        g.addSprite((Sprite) this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        List<HitListener> listenerList = hitListeners;
        if (listenerList == null) {
            return;
        }
        for (int i = 0; i < listenerList.size(); i++) {
            //equals from rectangle
            if (listenerList.get(i).equals(hl)) {
                listenerList.remove(i);
                return;
            }
        }
    }

    /**
     * This method notify all listeners about a hit even.
     * @param hitter Ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
