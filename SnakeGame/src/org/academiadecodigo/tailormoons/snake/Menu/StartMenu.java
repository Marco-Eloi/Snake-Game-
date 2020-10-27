package org.academiadecodigo.tailormoons.snake.Menu;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tailormoons.snake.Keyboard.KeyHandler;
import org.academiadecodigo.tailormoons.snake.Keyboard.OurKeyboardHandler;
import org.academiadecodigo.tailormoons.snake.SnakeGame.SnakeGame;
import org.academiadecodigo.tailormoons.snake.SnakeGrid.SnakeGridNormal;
import org.academiadecodigo.tailormoons.snake.SnakeGrid.SnakeGridObstacles;

import java.security.Key;


public class StartMenu implements KeyHandler {


    private Picture snakeLogo = new Picture(375, 150, "assets/Menu/snake1.png");
    private Picture startButtonSelected = new Picture(540, 500, "assets/Menu/PLAY Selected-300x100.png");
    private Picture startButton = new Picture(540, 500, "assets/Menu/PLAY unselected-300x100.png");
    private Picture exitButtonSelected = new Picture(540, 600, "assets/Menu/EXIT Selected-300x100.png");
    private Picture exitButton = new Picture(540, 600, "assets/Menu/EXIT unselected-300x100.png");
    private Picture scoresButtonSelected = new Picture(540, 700, "assets/Menu/SCORES selected-300x100.png");
    private Picture scoresButton = new Picture(540, 700, "assets/Menu/SCORES unselected-300x100.png");
    private Picture picture = new Picture(0, 0, Menu.BACKGROUND_IMAGE);
    private Picture noObstacles = new Picture(540, 500, "assets/Menu/original1-300x100.png");
    private Picture obstacles = new Picture(540, 600, "assets/Menu/obstacles-300x100.png");
    private Picture obstaclesSelected = new Picture(540, 600, "assets/Menu/obstaclesEdge-300x100.png");
    private Picture noObstaclesSelected = new Picture(540, 500, "assets/Menu/originalEdge-300x100.png");


    private Picture player1ButtonSelected = new Picture(540, 500, "assets/Menu/1PlayerEdge-300x100.png");
    private Picture player1Button = new Picture(540, 500, "assets/Menu/1Player-300x100.png");
    private Picture player2ButtonSelected = new Picture(540, 600, "assets/Menu/2PlayersEdge-300x100.png");
    private Picture player2Button = new Picture(540, 600, "assets/Menu/TWOPlayers unselected-300x100.png");

    private boolean  isP1;
    private  boolean isSpacePress;
    private boolean isP2;
    private boolean isStartButtonSelected = true;
    private boolean isPlayer1Selected;
    private boolean isPlayer2Selected;
    private boolean isScoreButtonSelected;
    private boolean isExitButtonSelected;
    private boolean isObstaclesSelected;
    private boolean isNoobSelected;
    private OurKeyboardHandler handler;
    private volatile int playerType;
    private  int gameType;
    private Sound music;
    private static final String[] MUSICS = {
            "/assets/Sounds/Music/1.wav",
            "/assets/Sounds/Music/2.wav",
            "/assets/Sounds/Music/3.wav",
            "/assets/Sounds/Music/4.wav"
    };

    public StartMenu() {

        int randomMusic = (int) (Math.random() * MUSICS.length);

        music = new Sound(MUSICS[randomMusic]);
    }

    public void init(){


        music.play(true);
        picture.draw();
        snakeLogo.draw();
        //start button selected - Default
        startButtonSelected.draw();
        //exit button
        exitButton.draw();
        //scores button
        scoresButton.draw();

        //instructions
 /*       Text text = new Text(630, 510, "Press Space Key to select");
        text.setColor(Color.RED);
        text.grow(85, 15);
        text.draw(); */

    }


    public void navigationUpdate() {

        if(isSpacePress) {
            if(isP1) playerType = 1;
            else if(isP2) playerType = 2;
            if (isObstaclesSelected) gameType = 2;
            else if (isNoobSelected) gameType = 1;
        }
    }


    @Override
    public void pressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                if (isStartButtonSelected) {
                    startButtonSelected.delete();
                    startButton.draw();
                    exitButtonSelected.draw();
                    isStartButtonSelected = false;
                    isExitButtonSelected = true;
                    break;
                } else if (isPlayer1Selected) {
                    player1ButtonSelected.delete();
                    player1Button.draw();
                    player2ButtonSelected.draw();
                    player2Button.delete();
                    isPlayer1Selected = false;
                    isPlayer2Selected = true;
                    break;
                } else if (isNoobSelected) {
                    isNoobSelected = false;
                    noObstaclesSelected.delete();
                    noObstacles.draw();
                    obstaclesSelected.draw();
                    obstacles.delete();
                    isObstaclesSelected = true;
                    break;
                }
                else if (isExitButtonSelected) break;
                else if (isPlayer2Selected) break;

            case KeyboardEvent.KEY_UP:
                if (isScoreButtonSelected) {
                    scoresButtonSelected.delete();
                    exitButtonSelected.draw();
                    startButtonSelected.draw();
                    isScoreButtonSelected = false;
                    isStartButtonSelected = true;
                    break;

                } else if (isExitButtonSelected) {
                    startButton.delete();
                    exitButtonSelected.delete();
                    startButtonSelected.draw();
                    isExitButtonSelected = false;
                    isStartButtonSelected = true;
                    break;

                } else if (isPlayer2Selected) {
                    player2Button.draw();
                    player2ButtonSelected.delete();
                    player1ButtonSelected.draw();
                    isPlayer1Selected = true;
                    isPlayer2Selected = false;
                    break;
                } else if (isObstaclesSelected) {
                    isObstaclesSelected = false;
                    obstaclesSelected.delete();
                    obstacles.draw();
                    noObstacles.delete();
                    noObstaclesSelected.draw();
                    isNoobSelected = true;
                    break;
                } else if (isStartButtonSelected) {
                    break;
                } else if (isPlayer1Selected) {
                    break;
                } else if (isNoobSelected) {
                    break;
                }

            case KeyboardEvent.KEY_SPACE:
                if (isStartButtonSelected) {
                    isStartButtonSelected = false;
                    isPlayer1Selected = true;
                    scoresButton.delete();
                    exitButton.delete();
                    startButtonSelected.delete();
                    startButton.delete();
                    player1ButtonSelected.draw();
                    player2Button.draw();
                    break;
                } else if (isExitButtonSelected) {
                    System.out.println("Bye bye! Maybe we finish it next....");
                    System.exit(1);
                    break;
                } else if (isPlayer1Selected) {
                    isPlayer1Selected = false;
                    isP1 = true;
                    player1ButtonSelected.delete();
                    player2Button.delete();
                    obstacles.draw();
                    noObstaclesSelected.draw();
                    isNoobSelected = true;
                    break;
                } else if (isPlayer2Selected) {
                    isPlayer2Selected = false;
                    isP2 = true;
                    player1ButtonSelected.delete();
                    player2Button.delete();
                    obstacles.draw();
                    noObstaclesSelected.draw();
                    isNoobSelected = true;
                    break;
                } else if (isNoobSelected) {
                    music.close();
                    obstaclesSelected.delete();
                    noObstaclesSelected.delete();
                    picture.delete();
                    snakeLogo.delete();
                    isSpacePress = true;
                    break;
                }
                if (isObstaclesSelected) {
                    music.close();
                    obstaclesSelected.delete();
                    noObstacles.delete();
                    picture.delete();
                    snakeLogo.delete();
                    isSpacePress = true;
                    break;
                }

        }
    }



    public void setHandler(OurKeyboardHandler handler) {
        this.handler = handler;
    }
    public int getPlayerType() {
        return playerType;
    }
    public int getGameType() {
        return gameType;
    }

}
