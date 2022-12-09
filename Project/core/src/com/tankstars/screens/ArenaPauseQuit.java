package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;


public class ArenaPauseQuit implements Screen {

    Tankstars game;
    Texture img;
    private static final int WIDTH = 166;
    private static final int HEIGHT = 80;

    private float elapsed;

    public ArenaPauseQuit(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Arena - Pause - Select.jpg");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render(float delta) {
        elapsed += delta;

        game.batch.begin();

        game.batch.draw(img, 0 , 0, 1920, 1080);
        int x = 867;
        int y = 765;
        if (( (Gdx.input.getX() > x && Gdx.input.getX() < (x + WIDTH) ) && (Gdx.input.getY() > y && Gdx.input.getY() < (y + HEIGHT) ) )) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new PausedArena(game));
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
