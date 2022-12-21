package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;

public class MainScreen implements Screen {

    public static Tankstars game;
    protected static Texture img;

    private static final int WIDTH = 336;
    private static final int HEIGHT = 107;

    public MainScreen(Tankstars game) {
        this.game = game;
        img = new Texture("Home Screen Render.jpg");
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        new com.tankstars.Main(game);
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}

}
