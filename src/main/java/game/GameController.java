package game;

// GUI packages
import javax.swing.JOptionPane;

// Local packages
import game.components.GameFrame;
import game.components.Menu;

public class GameController {
    private GameFrame gameFrame;
    private Menu gameMenu;

    public GameController(String title) {
        this.gameMenu = new Menu();
        this.gameFrame = new GameFrame(title, gameMenu);
    }
}
