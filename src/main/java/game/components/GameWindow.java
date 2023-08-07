package game.components;

// GUI packages
import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow(String title, Canvas drawCanvas) {
        this.setTitle(title);
        this.add(drawCanvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
