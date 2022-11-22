package com.tankstars.screens.p2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;
import com.tankstars.screens.MainScreen;


class ChooseTankMark1P2 implements Screen {

    Tankstars game;
    Texture img;

    float x;
    float y;

    public ChooseTankMark1P2(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Choose Tank - P2 - 3.jpg");
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
