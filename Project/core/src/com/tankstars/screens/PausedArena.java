package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
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
        int b = 384;

        int c = 834;
        int d = 504;

        int e = 834;
        int f = 624;

        int j = 834;
        int k = 744;

        if (( (Gdx.input.getX() > a && Gdx.input.getX() < (a + WIDTH) ) && (Gdx.input.getY() > b && Gdx.input.getY() < (b + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new Arena(game));
            }
        }

        else if (( (Gdx.input.getX() > c && Gdx.input.getX() < (c + WIDTH) ) && (Gdx.input.getY() > d && Gdx.input.getY() < (d + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new SaveState(game));
            }
        }

        else if (( (Gdx.input.getX() > e && Gdx.input.getX() < (e + WIDTH) ) && (Gdx.input.getY() > f && Gdx.input.getY() < (f + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new MainScreen(game));
            }
        }

        else if (( (Gdx.input.getX() > j && Gdx.input.getX() < (j + WIDTH) ) && (Gdx.input.getY() > k && Gdx.input.getY() < (k + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new ArenaPauseQuit(game));
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
