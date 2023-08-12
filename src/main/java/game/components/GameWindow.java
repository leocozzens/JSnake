package game.components;

// GUI packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
// Local packages
import game.GameController.Direction;

public class GameWindow extends JFrame {
    private Direction currDirection;

    public GameWindow(String title, Direction initDirection, Canvas drawCanvas) {
        this.setTitle(title);
        this.add(drawCanvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.addKeyListener(new MyKeyAdapter(this));
        this.setFocusable(true);

        this.currDirection = initDirection;
    }

    public Direction getDirection() {
        return currDirection;
    }

    public void setDirection(Direction newDirection) {
        this.currDirection = newDirection;
    }

    public class MyKeyAdapter extends KeyAdapter {
        private GameWindow parent;
        public MyKeyAdapter(GameWindow parent) {
            this.parent = parent;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    parent.setDirection(Direction.UP);
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    parent.setDirection(Direction.DOWN);
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    parent.setDirection(Direction.LEFT);
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    parent.setDirection(Direction.RIGHT);
                    break;
            }
        }
    }
}
