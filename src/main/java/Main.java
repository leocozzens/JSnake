// Local packages
import game.GameController;
import game.utils.ScreenManager;

public class Main {
    private static final String GAME_TITLE = "JSnake";
    public static void main(String args[]) {
        GameController controller = new GameController(GAME_TITLE, ScreenManager.getScreenDim());
        while(controller.isRunning()) {
            controller.playRound(); 
            controller.fullWait();
        }
        controller.gameOver();
    }
}