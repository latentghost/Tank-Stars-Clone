package com.tankstars.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;

public class Start implements Screen {
    Tankstars game;
    Texture img;
    private float elapsed;

    public Start(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Startup.jpg");
    }

    @Override
    public void render(float delta) {
        elapsed += delta;
        game.batch.begin();
        game.batch.draw(img, 0 , 0, 1920, 1080);
        game.batch.end();
        if (elapsed > 1.0) {
            game.setScreen(new MainScreen(game));
        }
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
