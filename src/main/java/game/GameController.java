package game;

// JDK packages
import java.util.Random;

// Local packages
import game.components.Canvas;
import game.components.GameWindow;
import game.components.GameWindow.Direction;
import game.utils.ScreenManager;
import javax.swing.Timer;

public class GameController {
    private static final int DELAY = 75;
    private static final int START_LEN = 6;

    private GameWindow gameWindow;
    private Canvas drawCanvas;
    private boolean gameActive;
    private Direction finalDirection;
    private Timer gameTimer;
    private Random gameRNG;

    private int snakeLen;
    private int foodEaten;

    // Constructor/Destructor
    public GameController(String title, double[] screenDimensions) {
        int canvasSize = (int) (screenDimensions[0]/3);
        this.drawCanvas = new Canvas(canvasSize);
        this.finalDirection = Direction.RIGHT;
        this.gameRNG = new Random(System.currentTimeMillis());

        this.snakeLen = 6;
        this.foodEaten = 0;
        this.drawCanvas.updateFood(this.gameRNG.nextInt(this.drawCanvas.getUnitsX()), this.gameRNG.nextInt(this.drawCanvas.getUnitsY()));
        this.gameWindow = new GameWindow(title, this.finalDirection, this.drawCanvas);
        this.gameTimer = new Timer(DELAY, this.gameWindow);
        this.gameActive = true;
        this.gameTimer.start();
    }

    // Instance methods
    public void playRound() {
        this.finalDirection = this.gameWindow.getDirection();
    }

    // private void step() {
    //     for(int i = snakeLen; i > 0; i--) {
    //     }
    //     switch(this.finalDirection) {
    //         case UP:
    //         break;
    //         case DOWN:
    //         break;
    //         case LEFT:
    //         break;
    //         case RIGHT:
    //         break;
    //     }
    // }

    private void checkFood() {

    }

    private void checkCollisons() {

    }

    // Getters
    public boolean isRunning() {
        return gameActive;
    }
}
