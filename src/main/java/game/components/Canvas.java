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
    private static final int LENGTH_GAINED = 4;
    private static final Color BG_COLOR = Color.BLACK;
    private static final Color FOOD_COLOR = new Color(200, 50, 50);

    private int canvasWidth;
    private int canvasHeight;
    private int elementSize;
    private int leftToAdd;
    private int[] foodCoord;
    private boolean foodEaten;
    private Deque<int[]> snakeBody;
    private Direction headDirection;

    public Canvas(int canvasSize) {
        this.canvasWidth = canvasSize;
        this.canvasHeight = canvasSize;
        this.elementSize = canvasHeight / ELEMENTS_PER;
        this.setPreferredSize(new Dimension(canvasSize, canvasSize));
        this.setBackground(BG_COLOR);
        this.foodCoord = new int[2];
        this.leftToAdd = 0;
        this.foodEaten = false;
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
        g.fillOval(this.foodCoord[0] * this.elementSize, this.foodCoord[1] * this.elementSize, elementSize, elementSize);
        g.setColor(Color.GREEN);
        Iterator<int[]> snakeIter = this.snakeBody.iterator();
        while(true) {
            int[] currentPiece = snakeIter.next();
            if(!snakeIter.hasNext()) {
                int x = currentPiece[0] * this.elementSize;
                int y = currentPiece[1] * this.elementSize;
                int startAngle = 0;
                int arcAngle = 0;
                switch(this.headDirection) {
                    case UP:
                        y = (currentPiece[1] * this.elementSize) + this.elementSize / 2;
                        startAngle = 0;
                        arcAngle = 180;
                        break;
                    case DOWN:
                        y = (currentPiece[1] * this.elementSize) - this.elementSize / 2;
                        startAngle = 180;
                        arcAngle = 180;
                        break;
                    case LEFT:
                        x = currentPiece[0] * this.elementSize + this.elementSize / 2;
                        startAngle = 90;
                        arcAngle = 180;
                        break;
                    case RIGHT:
                        x = currentPiece[0] * this.elementSize - this.elementSize / 2;
                        startAngle = 270;
                        arcAngle = 180;
                        break;
                }
                g.fillArc(x, y, this.elementSize, this.elementSize, startAngle, arcAngle);
                break;
            }
            g.fillRect(currentPiece[0] * this.elementSize, currentPiece[1] * this.elementSize, this.elementSize, this.elementSize);
        }
    }

    public void endCanvas(Graphics g) {

    }

    public void stepSnake(Direction newDirection) {
        int newX = this.snakeBody.peekLast()[0];
        int newY = this.snakeBody.peekLast()[1];
        switch(newDirection) {
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;  
            case LEFT:
                newX--;
            break;
            case RIGHT:
                newX++;
                break;
        }
        int[] nextPiece;
        if((newX == this.foodCoord[0]) && (newY == this.foodCoord[1])) {
            leftToAdd += LENGTH_GAINED;
            this.foodEaten = true;
        }

        if(leftToAdd > 0) {
            nextPiece = new int[2];
            leftToAdd--;
        }
        else {
            nextPiece = this.snakeBody.poll();
        }
        nextPiece[0] = newX;
        nextPiece[1] = newY;
        this.snakeBody.add(nextPiece);
        this.headDirection = newDirection;
        this.repaint(); // TODO: Only repaint head and tail
    }

    public void addPiece(int[] newPiece) {
        this.snakeBody.add(newPiece);
    }

    public void updateFood(int newX, int newY) {
        this.foodCoord[0] = newX;
        this.foodCoord[1] = newY;
    }

    public boolean isTaken(int x, int y) {
        Iterator<int[]> snakeIter = this.snakeBody.iterator();
        while(snakeIter.hasNext()) {
        int[] currentPiece = snakeIter.next();
            if(x == currentPiece[0] && y == currentPiece[1]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFood() {
        return this.foodEaten;
    }

    public void foodMade() {
        this.foodEaten = false;
    }

    public int getUnitsX() {
        return canvasWidth / elementSize;
    }
    public int getUnitsY() {
        return canvasHeight / elementSize;
    }
}
