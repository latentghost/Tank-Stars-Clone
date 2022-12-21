package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Main;
import com.tankstars.Tankstars;


public class LoadGame implements Screen {

    protected Tankstars game;
    protected Texture img;
    private static final int WIDTH = 280;
    private static final int HEIGHT = 89;

    private static final int RADIUS = 69;

    public LoadGame(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Home Screen Render.jpg");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render(float delta) {
        Main.loadgame();
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
