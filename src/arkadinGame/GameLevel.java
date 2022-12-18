package arkadinGame;

import Animation.Animation;
import Levels.LevelInformation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collisionDetection.Collidable;
import collisionDetection.GameEnvironment;
import collisionDetection.Paddle;
import counter.Counter;
import geometricShape.ball.Ball;
import geometricShape.Point;
import geometricShape.Rectangle;
import collisionDetection.Block;
import geometricShape.ball.Velocity;
import notification.BallRemover;
import notification.BlockRemover;
import notification.ScoreTrackingListener;
import sprites.SpriteCollection;
import sprites.Lives;
import sprites.LevelInfo;
import sprites.ScoreIndicator;
import sprites.Decorate;
import sprites.Sprite;

import java.awt.Color;
import java.util.List;
import java.util.Random;
import Animation.AnimationRunner;
import Animation.PauseScreen;
import Animation.CountdownAnimation;
import Animation.GameOver;
import Animation.KeyPressStoppableAnimation;
// 318469830 Shilo Padael
/**
 * @author Shilo Padael
 * @version ass2
 * @since 2022/03/09
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Rectangle border;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreTrackingListener score;
    private ScoreIndicator scoreIndicator;
    private Decorate decorate;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboardSensor;
    private LevelInformation levelInformation;
    private Lives lives;
    private LevelInfo levelDraw;
    private Paddle paddle;

    /**
     * Create sprites.SpriteCollection and GameEnvironmen.
     * @param levelInformation LevelInformation
     */
    public GameLevel(LevelInformation levelInformation) {
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        blockRemover = new BlockRemover(this, new Counter("RB", 100));
        ballRemover = new BallRemover(this, new Counter("RG", 100));
        score = new ScoreTrackingListener(new Counter("SC", 10000));
        scoreIndicator = new ScoreIndicator(score.getCurrentScore());
        lives = new Lives(new Counter("Live", 7));
        lives.getLives().increase(7);
        sprites.addSprite(lives);
        sprites.addSprite(scoreIndicator);
        runner = new AnimationRunner();
        keyboardSensor = runner.getGui().getKeyboardSensor();
        this.levelInformation = levelInformation;
        levelDraw = new LevelInfo(levelInformation);
        sprites.addSprite(levelDraw);
    }

    /**
     * @param levelInfo LevelInformation
     * @param score ScoreTrackingListener
     * @param ks KeyboardSensor
     * @param ar AnimationRunner
     * @param live Lives
     */
    public GameLevel(LevelInformation levelInfo, ScoreTrackingListener score, KeyboardSensor ks,
                     AnimationRunner ar, Lives live) {
        levelInformation = levelInfo;
        this.score = score;
        scoreIndicator = new ScoreIndicator(score.getCurrentScore());
        keyboardSensor = ks;
        runner = ar;
        sprites = new SpriteCollection();
        environment = new GameEnvironment();
        blockRemover = new BlockRemover(this, new Counter("RB", 100));
        ballRemover = new BallRemover(this, new Counter("RG", 100));
        score = new ScoreTrackingListener(new Counter("SC", 10000));
        sprites.addSprite(scoreIndicator);
        lives = live;
        sprites.addSprite(lives);
        levelDraw = new LevelInfo(levelInformation);
        sprites.addSprite(levelDraw);



    }

    /**
     * @return BallRemover.
     */
    public BallRemover getBallRemover() {
        return ballRemover;
    }

    /**
     * This method add Cllidable object to this environment.
     * @param c collisionDetection.Collidable.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }
    /**
     * This method add Cllidable list to this environment.
     * @param c List.
     */
    public void addCollidable(List<Collidable> c) {
        environment.addCollidable(c);
    }

    /**
     * @param i int
     * @return Color
     */
    public static Color randomColor(int i) {
        Random rand = new Random();
        return new Color(i, i + 5, i + 15);
    }
    /**
     * This method add sprites.Sprite list to this sprites.Sprite collection.
     * @param s sprites.Sprite
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * @param c Collidable
     */
    private void searchCollidible(Collidable c) {
        List<Collidable> collidList = environment.getCollidList();
        if (collidList == null) {
            return;
        }
        for (int i = 0; i < collidList.size(); i++) {
            if (collidList.get(i).equals(c)) {
                collidList.remove(i);
                return;
            }
        }
     }

    /**
     * @param s Sprite
     */
    private void searchSprite(Sprite s) {
        List<Sprite> spriteList = sprites.getSpriteList();
        if (spriteList == null) {
            return;
        }
        for (int i = 0; i < spriteList.size(); i++) {
            //this method equal can give true only if the two object are blocks exept the
            // paddael(its wont remove the ball as well)
            if (spriteList.get(i).equals(s)) {
                spriteList.remove(i);
                return;
            }
        }
    }

    /**
     * removing collidible from the game.
     * @param c Collidable.
     */
    public void removeCollidable(Collidable c) {
        //serching collideble c from the list
         searchCollidible(c);

        // poping from the list.
    }

    /**
     * removing Sprite from the game.
     * @param s Sprite
     */
    public void removeSprite(Sprite s) {
        searchSprite(s);
    }

    /**
     * This method initialize a new game.
     * create the Blocks geometricShape.ball.Ball and collisionDetection.Paddle, then add them to the game.
     */
    public void initialize() {
        Rectangle borders = new Rectangle(new Point(0, 0), 800, 600, Color.gray);
        border = borders;
        // print background
        this.addSprite(levelInformation.getBackground());

        //creat 3 balls
        creatSomeBalls(levelInformation.numberOfBalls(), levelInformation.initialBallVelocities());

        //creat paddael
        creatPaddle();

        // creat blocks
        createAllBlocks(levelInformation.blocks());

        //creat borders of blocks
        createBorder(600, 30, new Color(80, 34, 43), new Point(0, 20));
        createBorder(600, 30, new Color(80, 34, 43), new Point(770, 20));
        createBorder(30, 800, new Color(80, 34, 43), new Point(0, 20));
        deathRegion(30, 800, new Color(80, 34, 43), new Point(0, 601));

    }

    /**
     * creat paddle.
     */
    private void creatPaddle() {
        int paddleXCor = (800 - levelInformation.paddleWidth()) / 2;
        this.paddle = new Paddle(keyboardSensor, border, new Color(30, 29, 65),
                new Rectangle(new Point(paddleXCor, 550), levelInformation.paddleWidth(), 20),
                levelInformation.paddleSpeed());
        paddle.addToGame(this);

    }

    /**
     * @param num int
     * @param ballVel List
     */
    private void creatSomeBalls(int num, List<Velocity> ballVel) {
        for (Velocity velocity: ballVel) {
            creatBall(new Point(400, 500), environment, velocity);


        }
    }

    /**
     * @param point Point
     * @param environment GameEnvironment
     * @param velocity Velocity
     */
    private void creatBall(Point point, GameEnvironment environment, Velocity velocity) {
        Ball newBall = new Ball(point, 8, Color.blue, environment);
        newBall.setVelocity(velocity);
        newBall.addToGame(this);
        ballRemover.getRemainingBalls().increase(1);

    }

    /**
     * @param blockList List
     */
    private void createAllBlocks(List<Block> blockList) {
        for (Block block: blockList) {
            block.addHitListener(blockRemover);
            block.addHitListener(score);
            blockRemover.getRemainingBlocks().increase(1);
            block.addToGame(this);
        }
    }

    /**
     * @param height double
     * @param width double
     * @param color Color
     * @param upperLeft Point
     */
    private void createBorder(double height, double width, Color color, Point upperLeft) {
        Block block = new Block(new Rectangle(upperLeft, width, height, color));
        block.addToGame(this);
    }

    /**
     * @param height double
     * @param width double
     * @param color Color
     * @param upperLeft Point
     */
    private void deathRegion(double height, double width, Color color, Point upperLeft) {
        Block block = new Block(new Rectangle(upperLeft, width, height, color));
        block.addHitListener(ballRemover);
        block.addToGame(this);

    }
    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(3, 3, this.sprites, runner)); // countdown before turn starts.
        this.running = true;
        this.runner.run(this);
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (ballRemover.getRemainingBalls().getCount() == 0) {
            if (lives.getLives().getCount() < 1) {
                this.runner.run(new KeyPressStoppableAnimation(keyboardSensor,
                        KeyboardSensor.SPACE_KEY, new GameOver(this.keyboardSensor, score.getCurrentScore().getCount(),
                        sprites)));
                this.running = false;
                return;
            }
            this.lives.getLives().decrease(1);
            paddle.removePaddle(this);
            creatPaddle();
            creatSomeBalls(levelInformation.numberOfBalls(), levelInformation.initialBallVelocities());
            this.runner.run(new CountdownAnimation(3, 3, this.sprites, runner));
        }
        if (blockRemover.getRemainingBlocks().getCount() == 0) {
            score.getCurrentScore().increase(100);
            this.running = false;
        }
        if (this.keyboardSensor.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(this.keyboardSensor)));
        }

    }

    /**
     * @return BlockRemover
     */
    public BlockRemover getBlockRemover() {
        return blockRemover;
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

}