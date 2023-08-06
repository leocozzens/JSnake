package game.components;

// GUI packages
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame(String title, Menu menu) {
        this.setTitle(title);
        this.add(menu);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
