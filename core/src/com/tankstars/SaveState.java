package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;


public class SaveState implements Screen {

    Tankstars game;
    Texture img;
    private static final int WIDTH = 185;
    private static final int HEIGHT = 59;

    public SaveState(Tankstars game){
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
        game.batch.begin();

        game.batch.draw(img,0,0,1920,1080);

        int g = 867;
        int i = 397;

        int j = 867;
        int k = 765;

        int height = 336;
        int width = 185;

        if (( (Gdx.input.getX() > g && Gdx.input.getX() < (g + width) ) && (Gdx.input.getY() > i && Gdx.input.getY() < (i + height) ) )){
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.MainScreen(game));
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
