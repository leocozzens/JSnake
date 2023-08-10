package game.components;

// JDK packages
import java.util.ArrayList;
// GUI packages
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Canvas extends JPanel {
    private static final int ELEMENTS_PER = 20;
    private static final Color BG_COLOR = Color.BLACK;
    private static final Color FOOD_COLOR = new Color(200, 50, 50);

    private int canvasWidth;
    private int canvasHeight;
    private int elementSize;
    private int[] foodCoord;
    private ArrayList<int[]> snakeBody;

    public Canvas(int canvasSize) {
        this.canvasWidth = canvasSize;
        this.canvasHeight = canvasSize;
        this.elementSize = canvasHeight / ELEMENTS_PER;
        this.setPreferredSize(new Dimension(canvasSize, canvasSize));
        this.setBackground(BG_COLOR);
        this.setFocusable(true);
        this.foodCoord = new int[2];
        this.snakeBody = new ArrayList<int[]>(6);
        for(int i = 0; i < 6; i++) {
            int[] newPart = new int[2];
            newPart[0] = 0;
            newPart[1] = i;
            this.snakeBody.add(newPart);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        int yCount = getUnitsX();
        for(int i = 0; i < yCount; i++) {
            g.drawLine(i*elementSize, 0, i*elementSize, this.canvasHeight);
        }
        for(int i = 0; i < yCount; i++) {
            g.drawLine(0, i*elementSize, this.canvasWidth, i*elementSize);
        }
        g.setColor(FOOD_COLOR);
        g.fillOval(this.foodCoord[0], this.foodCoord[1], elementSize, elementSize);
        g.setColor(Color.GREEN);
        for(int i = 0; i < this.snakeBody.size(); i++) {
            g.fillRect(this.snakeBody.get(i)[0]*this.elementSize, this.snakeBody.get(i)[1]*this.elementSize, this.elementSize, this.elementSize);
        }
    }

    public void endCanvas(Graphics g) {

    }

    

    public void updateFood(int newX, int newY) {
        this.foodCoord[0] = newX * this.elementSize;
        this.foodCoord[1] = newY * this.elementSize;
    }

    public int getUnitsX() {
        return canvasWidth / elementSize;
    }
    public int getUnitsY() {
        return canvasHeight / elementSize;
    }
}
