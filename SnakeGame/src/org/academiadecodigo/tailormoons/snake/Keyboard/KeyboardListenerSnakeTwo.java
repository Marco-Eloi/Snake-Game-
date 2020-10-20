package org.academiadecodigo.tailormoons.snake.Keyboard;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tailormoons.snake.Direction;
import org.academiadecodigo.tailormoons.snake.Snake.Snake;

public class KeyboardListenerSnakeTwo implements KeyboardListener, KeyboardHandler {

    private final Snake player;
    public static final int left = KeyboardEvent.KEY_A;
    public static final int right= KeyboardEvent.KEY_D;
    public static final int down = KeyboardEvent.KEY_S;
    public static final int up = KeyboardEvent.KEY_W;



    public KeyboardListenerSnakeTwo (Snake player) {
        this.player = player;

    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        if(!player.isDirectionChanged()) {
            player.setDirectionChanged(true);
            switch (e.getKey()) {
                case left: {
                    player.changeDirection(Direction.LEFT);
                    break;
                }
                case right: {
                    player.changeDirection(Direction.RIGHT);
                    break;
                }
                case up: {
                    player.changeDirection(Direction.UP);
                    break;
                }
                case down: {
                    player.changeDirection(Direction.DOWN);
                    break;
                }
            }
        }
    }

    public void keyboardHandling() {

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_A);

        player.getKeyboard().addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_W);

        player.getKeyboard().addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_D);

        player.getKeyboard().addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_S);

        player.getKeyboard().addEventListener(down);

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

}
