package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;


class ChooseTankAbramsP2 implements Screen {

    Tankstars game;
    Texture img;

    private static final int WIDTH = 336;
    private static final int HEIGHT = 107;
    private static final int RADIUS = 69;

    private static final int RADIUS1 = 116;

    public ChooseTankAbramsP2(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Choose Tank - P1 - 1.jpg");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render(float delta) {
        game.batch.begin();

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
