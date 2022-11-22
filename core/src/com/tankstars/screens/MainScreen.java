package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;

public class MainScreen implements Screen {

    Tankstars game;
    Texture img;

    float x;
    float y;

    private static final int WIDTH = 336;
    private static final int HEIGHT = 107;

    public MainScreen(Tankstars game) {
        this.game = game;
        img = new Texture("Home Screen.jpg");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        int x = 1468;
        int y = 227;
        int z = 573;
        int a = 746;
        int b = 400;

        if (( (Gdx.input.getX() > x && Gdx.input.getX() < (x + WIDTH) ) && (Gdx.input.getY() > y && Gdx.input.getY() < (y + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                resize(1920,1080 );
                game.setScreen(new com.tankstars.screens.ChooseTankAbramsP2(game));
            }
        }

        else if (( (Gdx.input.getX() > x && Gdx.input.getX() < (x + WIDTH) ) && (Gdx.input.getY() > b && Gdx.input.getY() < (b + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                resize(1920,1080 );
                game.setScreen(new com.tankstars.screens.ChooseTankAbramsP1(game));
            }
        }

        else if ( (Gdx.input.getX() > x && Gdx.input.getX() < (x + WIDTH) ) && (Gdx.input.getY() > z && Gdx.input.getY() < (z + HEIGHT) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                resize(1920,1080 );
                game.setScreen(new LoadGame(game));
            }
        }

        else if( (Gdx.input.getX() > x && Gdx.input.getX() < (x + WIDTH) ) && (Gdx.input.getY() > a && Gdx.input.getY() < (a + HEIGHT) )){
            if (Gdx.input.isTouched()) {
                this.dispose();
                resize(1920,1080 );
                game.setScreen(new com.tankstars.screens.Start(game));
            }
        }

        else{
            game.batch.draw(img, 0,0,1920,1080);
        }
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

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
