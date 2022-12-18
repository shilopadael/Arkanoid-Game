package notification;

import counter.Counter;
import arkadinGame.GameLevel;
import collisionDetection.Block;
import geometricShape.ball.Ball;


/**
 *  a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 *  of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * @param gameLevel GameLevel
     * @param removedBlocks Counter
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;



    }

    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
//        System.out.println(beingHit.getCollisionRectangle().getUpperleft().getX());
        beingHit.removeFromGame(gameLevel);
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(1);
    }
    /**
     * @return Counter
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }
}