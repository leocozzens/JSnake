package game.components;

// GUI packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class GameWindow extends JFrame implements ActionListener {
    public static enum Direction { UP, DOWN, LEFT, RIGHT };

    private Direction currDirection;

    public GameWindow(String title, Direction initDirection, Canvas drawCanvas) {
        this.setTitle(title);
        this.add(drawCanvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.addKeyListener(new MyKeyAdapter());

        this.currDirection = initDirection;
    }

    public Direction getDirection() {
        return currDirection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

        }
    }
}
