package org.academiadecodigo.tailormoons.snake.Node;
import org.academiadecodigo.tailormoons.snake.SnakeGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tailormoons.snake.Direction;
import org.academiadecodigo.tailormoons.snake.Snake;

public class SnakeParts extends org.academiadecodigo.tailormoons.snake.Node.Node {

    private Rectangle figure;
    private Direction direction;
    private Direction previousDirection;

    public SnakeParts(int x, int y) {
        super(x, y);
        direction = Direction.UP;
        previousDirection= Direction.UP;
        figure = new Rectangle(x * SnakeGame.CELL_SIZE + SnakeGame.PADDING, y * SnakeGame.CELL_SIZE + SnakeGame.PADDING, SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
        figure.setColor(Color.GREEN);
        figure.fill();
    }

    public void setColor(Color color){
        figure.setColor(color);
    }

    public Direction getDirection() {
        return direction;
    }

    public void moveInDirection() {

        switch (direction) {
            case LEFT:
                if (x == 0) {
                    x = SnakeGame.COLS - 1;
                    figure.delete();
                    figure = new Rectangle(x * SnakeGame.CELL_SIZE + SnakeGame.PADDING, y * SnakeGame.CELL_SIZE + SnakeGame.PADDING, SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
                    figure.setColor(Color.GREEN);
                    figure.fill();
                    return;
                }
                x--;
                figure.translate(-SnakeGame.CELL_SIZE, 0);
                break;
            case DOWN:
                if (y == SnakeGame.ROWS - 1) {
                    y = 0;
                    figure.delete();
                    figure = new Rectangle(x * SnakeGame.CELL_SIZE + SnakeGame.PADDING, y * SnakeGame.CELL_SIZE + SnakeGame.PADDING, SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
                    figure.setColor(Color.GREEN);
                    figure.fill();
                    return;
                }
                y++;
                figure.translate(0, SnakeGame.CELL_SIZE);
                break;
            case UP:
                if (y == 0) {
                    y = SnakeGame.ROWS - 1;
                    figure.delete();
                    figure = new Rectangle(x * SnakeGame.CELL_SIZE + SnakeGame.PADDING, y * SnakeGame.CELL_SIZE + SnakeGame.PADDING, SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
                    figure.setColor(Color.GREEN);
                    figure.fill();
                    return;
                }
                y--;
                figure.translate(0, -SnakeGame.CELL_SIZE);
                break;
            case RIGHT:
                if (x == SnakeGame.COLS - 1) {
                    x = 0;
                    figure.delete();
                    figure = new Rectangle(x * SnakeGame.CELL_SIZE + SnakeGame.PADDING, y * SnakeGame.CELL_SIZE + SnakeGame.PADDING, SnakeGame.CELL_SIZE, SnakeGame.CELL_SIZE);
                    figure.setColor(Color.GREEN);
                    figure.fill();
                    return;
                }
                x++;
                figure.translate(SnakeGame.CELL_SIZE, 0);
                break;
        }
    }


    public void setDirection(SnakeParts previous, SnakeParts next) {
        direction = previous.getPreviousDirection();
    }

    public void copyDirection(SnakeParts part) {
        previousDirection = part.getPreviousDirection();
        direction = part.getDirection();
    }

    public Direction getPreviousDirection() {
        return previousDirection;
    }

    public void setPreviousDirection(Direction direction) {
        previousDirection = direction;
    }

    public void setDirection(Direction direction) {
        if (this.direction.isOpposite(direction)) {
            return;
        }
        this.direction = direction;
        System.out.println("Changed Direction of Head" + direction);
    }
}
