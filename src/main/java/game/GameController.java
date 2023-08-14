package game;

// JDK packages
import java.util.Random;

// Local packages
import game.components.Canvas;
import game.components.GameWindow;

public class GameController {
    public static enum Direction { 
        UP(-1, 0),
        DOWN(1, 1),
        LEFT(-2, 2),
        RIGHT(2, 3);

        final int val;
        final int index;
        static final int MAX = 4;
        Direction(int val, int index) {
            this.val = val;
            this.index = index;
        }
    };
    private static final long DELAY_MS = 75;
    private static final int START_LEN = 6;

    private GameWindow gameWindow;
    private Canvas drawCanvas;
    private boolean gameActive;
    private Direction finalDirection;
    private Random gameRNG;
    private long timeStore;
    private int score;

    // Constructor/Destructor
    public GameController(String title, double[] screenDimensions) {
        int canvasSize = (int) (screenDimensions[0]/3);
        this.drawCanvas = new Canvas(canvasSize);
        this.gameRNG = new Random(System.currentTimeMillis());

        this.initSnake(randomDirection());
        this.makeFood();

        this.gameWindow = new GameWindow(title, this.finalDirection, this.drawCanvas);
        this.gameActive = true;
    }

    // Instance methods
    private void initSnake(Direction startDirection) {
        int startX = this.gameRNG.nextInt(this.drawCanvas.getUnitsX());
        int startY = this.gameRNG.nextInt(this.drawCanvas.getUnitsY());
        switch(startDirection) {
            case UP:
            startY = startY % (this.drawCanvas.getUnitsY() - START_LEN + 1) + START_LEN - 1;
            break;
            case DOWN:
            startY %= (this.drawCanvas.getUnitsY() + 1) - START_LEN;
            break;
            case LEFT:
            startX = startX % (this.drawCanvas.getUnitsX() - START_LEN + 1) + START_LEN - 1;
            break;
            case RIGHT:
            startX %= (this.drawCanvas.getUnitsX() + 1) - START_LEN;
            break;
        }
        for(int i = 0; i < START_LEN; i++) {
            int[] newPart = new int[2];
            switch(startDirection) {
                case UP:
                newPart[0] = startX;
                newPart[1] = startY - i;
                break;
                case DOWN:
                newPart[0] = startX;
                newPart[1] = startY + i;
                break;
                case LEFT:
                newPart[0] = startX - i;
                newPart[1] = startY;
                break;
                case RIGHT:
                newPart[0] = startX + i;
                newPart[1] = startY;
                break;
            }
            this.drawCanvas.addPiece(newPart);
        }
        this.finalDirection = startDirection;
    }

    private Direction randomDirection() {
        int index = this.gameRNG.nextInt(Direction.MAX);
        for(Direction tempDirection : Direction.values()) {
            if(tempDirection.index == index) {
                return tempDirection;
            }
        }
        throw new IllegalArgumentException("Incorrect random direction input");
    }

    private void makeFood() {
        int foodX;
        int foodY;
        do {
            foodX = this.gameRNG.nextInt(this.drawCanvas.getUnitsX());
            foodY = this.gameRNG.nextInt(this.drawCanvas.getUnitsY());
        } while(this.drawCanvas.isTaken(foodX, foodY));
        this.drawCanvas.updateFood(foodX, foodY);
    }

    public void playRound() {
        this.timeStore = System.currentTimeMillis();
        setDirection(this.gameWindow.getDirection());
        this.drawCanvas.stepSnake(this.finalDirection);
        if(this.drawCanvas.checkCollisons()) {
            this.gameActive = false;
        }
        if(this.drawCanvas.checkFood()) {
            this.makeFood();
            this.drawCanvas.foodMade();
        }
    }

    public void gameOver() {
        System.exit(0);
    }

    public void fullWait() {
        long elapsedTime = System.currentTimeMillis() - timeStore;
        if(elapsedTime < DELAY_MS) {
            try {
                Thread.sleep(DELAY_MS - elapsedTime);
            }
            catch(Exception e) {
                System.err.println(e);
            }
        }
    }

    // Getters & setters
    public boolean isRunning() {
        return gameActive;
    }

    private void setDirection(Direction newDirection) {
        if(newDirection.val + this.finalDirection.val != 0) this.finalDirection = newDirection;
    }
}
