package game.components;

// GUI packages
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Canvas extends JPanel {
    private static final int ELEMENTS_PER = 20;
    private static final Color BG_COLOR = Color.BLACK;

    private int canvasWidth;
    private int canvasHeight;
    private int elementSize;

    public Canvas(int canvasSize) {
        this.canvasWidth = canvasSize;
        this.canvasHeight = canvasSize;
        this.elementSize = canvasHeight / ELEMENTS_PER;
        this.setPreferredSize(new Dimension(canvasSize, canvasSize));
        this.setBackground(BG_COLOR);
        this.setFocusable(true);
    }

    public int getUnitsX() {
        return canvasWidth / elementSize;
    }
    public int getUnitsY() {
        return  canvasHeight / elementSize;
    }

    public void initCanvas() {

    }

    public void paintComponent(Graphics g) {

    }

    public void draw(Graphics g) {

    }

    public void endCanvas(Graphics g) {

    }
}
