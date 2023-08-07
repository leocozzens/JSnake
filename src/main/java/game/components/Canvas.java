package game.components;

// GUI packages
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Canvas extends JPanel implements java.awt.event.ActionListener {
    private static final int DELAY = 75;
    private static final int ELEMENTS_PER = 20;
    private static final Color BG_COLOR = Color.BLACK;

    private int canvasSize;
    private int elementSize;

    public Canvas(int canvasSize) {
        this.canvasSize = canvasSize;
        this.elementSize = canvasSize / ELEMENTS_PER;
        this.setPreferredSize(new Dimension(canvasSize, canvasSize));
        this.setBackground(BG_COLOR);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }

    public int getUnits() {
        return (canvasSize*2) / elementSize;
    }

    public void initCanvas() {

    }

    public void paintComponent(Graphics g) {

    }

    public void draw(Graphics g) {

    }

    public void move() {
        
    }

    public void checkFood() {

    }

    public void checkCollisons() {

    }

    public void endCanvas(Graphics g) {

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
