package game;

// JDK packages
import java.util.Random;
import java.util.Timer;

// Local packages
import game.components.Canvas;
import game.components.GameWindow;
import game.utils.ScreenManager;

public class GameController {
    private static enum Direction { UP, DOWN, LEFT, RIGHT };

    private GameWindow gameWindow;
    private Canvas drawCanvas;
    private boolean gameActive;
    private Timer gameTimer;
    private Random gameRNG;

    private Direction currDirection;
    private int snakeLen;
    private int foodEaten;
    private int foodX;
    private int foodY;
    private int[] x;
    private int[] y;

    // Constructor/Destructor
    public GameController(String title) {
        double[] dimensions = ScreenManager.getScreenDim();
        int canvasSize = (int) (dimensions[0]*.3);
        this.drawCanvas = new Canvas(canvasSize);
        this.gameWindow = new GameWindow(title, this.drawCanvas);
        this.gameActive = true;
        this.gameRNG = new Random();

        this.snakeLen = 6;
        this.foodEaten = 0;
        this.x = new int[this.drawCanvas.getUnits()];
        this.y = new int[this.drawCanvas.getUnits()];
    }

    // Instance methods
    public void playRound() {
        
    }

    // Getters
    public boolean isRunning() {
        return gameActive;
    }
}
