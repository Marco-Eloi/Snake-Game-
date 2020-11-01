package org.academiadecodigo.tailormoons.snake.Node;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.snake.SnakeGame.SnakeGame;

public class Consumable extends Node{

    private Picture planet;
    String[] BACKGROUNDS = {
            "assets/Consumables/earth.png",
            "assets/Consumables/saturn.png",
            "assets/Consumables/weird.png",
            "assets/Consumables/ice.png",
            "assets/Consumables/moon.png",
            "assets/Consumables/green.png",
            "assets/Consumables/red.png"
    };

    public Consumable(int x, int y) {
        super(x, y);

        int randomConsumableBackground = (int) (Math.random() * BACKGROUNDS.length);
        planet = new Picture(x* SnakeGame.CELL_SIZE, y* SnakeGame.CELL_SIZE-4, BACKGROUNDS[randomConsumableBackground]);

    }

    public void hide() {
        planet.delete();
    }

    public void show(){
        planet.draw();
    }
}
