package com.tankstars.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;

public class Start implements Screen {
    public static Tankstars game;
    Texture img;
    private float elapsed;

    public Start(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Home Screen Render.jpg");
    }

    @Override
    public void render(float delta) {
        game.setScreen(new MainScreen(game));
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
