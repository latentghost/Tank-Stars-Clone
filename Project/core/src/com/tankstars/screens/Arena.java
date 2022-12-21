package com.tankstars.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Main;
import com.tankstars.Tankstars;


public class Arena implements Screen {

    Tankstars game;
    Texture img;
    private static final int WIDTH = 336;
    private static final int HEIGHT = 107;
    private static final int RADIUS = 69;

    private static final int TWIDTH = 80;
    private static final int THEIGHT = 80;

    private float elapsed;

    public Arena(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Arena Render.jpg");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render(float delta) {
        Main.arena();
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
