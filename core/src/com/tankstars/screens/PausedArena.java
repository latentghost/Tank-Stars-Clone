package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;


public class PausedArena implements Screen {

    Tankstars game;
    Texture img;
    private static final int WIDTH = 252;
    private static final int HEIGHT = 81;

    private static final int RADIUS = 84;

    public PausedArena(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Arena - Pause Menu.jpg");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render(float delta) {
        game.batch.begin();
        game.batch.draw(img,0,0,1920,1080);
        int a = 834;
        int b = 624;

        int c = 834;
        int d = 744;

        int e = 834;
        int f = 504;

        if (( (Gdx.input.getX() > a && Gdx.input.getX() < (a + WIDTH) ) && (Gdx.input.getY() > b && Gdx.input.getY() < (b + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.ChooseTankAbramsP1(game));
            }
        }
        else if (( (Gdx.input.getX() > c && Gdx.input.getX() < (c + WIDTH) ) && (Gdx.input.getY() > d && Gdx.input.getY() < (d + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.Start(game));
            }
        }
        else if (( (Gdx.input.getX() > e && Gdx.input.getX() < (e + WIDTH) ) && (Gdx.input.getY() > f && Gdx.input.getY() < (f + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.Start(game));
            }
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
