package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;
import com.tankstars.screens.MainScreen;


 public class ChooseTankMark1P2 implements Screen {

    Tankstars game;
    Texture img;

    private static final int WIDTH = 336;
    private static final int HEIGHT = 107;
    private static final int RADIUS = 69;

    private static final int TWIDTH = 80;
    private static final int THEIGHT = 80;

    public ChooseTankMark1P2(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Choose Tank - P2 - 2.jpg");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(img,0,0,1920,1080);

        int a = 1386;
        int b = 32;

        int x = 1468;
        int y = 761;

        int x1 = 1370;
        int y1 = 450;

        int x2 = 1850;
        int y2 = 450;

        if ( (Gdx.input.getX() > a && Gdx.input.getX() < (a + RADIUS) ) && (Gdx.input.getY() > b && Gdx.input.getY() < (b + RADIUS) ) ) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new MainScreen(game));
            }
        }
        else if ( (Gdx.input.getX() > x && Gdx.input.getX() < (x + WIDTH) ) && (Gdx.input.getY() > y && Gdx.input.getY() < (y + HEIGHT) ) ) {
            img = new Texture("Choose Tank - P2 - 2 - Hover.jpg");
            game.batch.draw(img,0,0,1920,1080);
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.Arena(game));
            }
        }
        else if ( (Gdx.input.getX() > x1 && Gdx.input.getX() < (x1 + TWIDTH) ) && (Gdx.input.getY() > y1 && Gdx.input.getY() < (y1 + THEIGHT) ) ) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.ChooseTankAbramsP2(game));
            }
        }
        else{
            img = new Texture("Choose Tank - P2 - 2.jpg");
            game.batch.draw(img,0,0,1920,1080);
        }
        game.batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
