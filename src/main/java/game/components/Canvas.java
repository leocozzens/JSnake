package game.components;

// JDK packages
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
// GUI packages
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
// Local packages
import game.GameController.Direction;

public class Canvas extends JPanel {
    private static final int ELEMENTS_PER = 20;
    private static final Color BG_COLOR = Color.BLACK;
    private static final Color FOOD_COLOR = new Color(200, 50, 50);

    private int canvasWidth;
    private int canvasHeight;
    private int elementSize;
    private int[] foodCoord;
    private Deque<int[]> snakeBody;

    public Canvas(int canvasSize) {
        this.canvasWidth = canvasSize;
        this.canvasHeight = canvasSize;
        this.elementSize = canvasHeight / ELEMENTS_PER;
        this.setPreferredSize(new Dimension(canvasSize, canvasSize));
        this.setBackground(BG_COLOR);
        this.foodCoord = new int[2];
        this.snakeBody = new ArrayDeque<int[]>();
    }

    @Override
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
        Iterator<int[]> snakeIter = this.snakeBody.iterator();
        while(snakeIter.hasNext()) {
            int[] currentPiece = snakeIter.next();
            g.fillRect(currentPiece[0]*this.elementSize, currentPiece[1]*this.elementSize, this.elementSize, this.elementSize);
        }
    }

    public void endCanvas(Graphics g) {

    }

    public void stepSnake(Direction newDirection) {
        int[] nextPiece = this.snakeBody.poll();
        nextPiece[0] = this.snakeBody.peekLast()[0];
        nextPiece[1] = this.snakeBody.peekLast()[1];
        switch(newDirection) {
            case UP:
                nextPiece[1]--;
                break;
            case DOWN:
                nextPiece[1]++;
                break;  
            case LEFT:
                nextPiece[0]--;
            break;
            case RIGHT:
                nextPiece[0]++;
                break;
        }
        this.snakeBody.add(nextPiece);
        this.repaint();
    }

    public void addPiece(int[] newPiece) {
        this.snakeBody.add(newPiece);
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
