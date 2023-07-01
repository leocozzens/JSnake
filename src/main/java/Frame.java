import javax.swing.JFrame;

public class Frame extends JFrame {
    Frame() {
        this.add(new Menu());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
    }
}
