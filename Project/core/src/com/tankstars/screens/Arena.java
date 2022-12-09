package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;


public class Arena implements Screen {

    Tankstars game;
    Texture img;
    private static final int WIDTH = 252;
    private static final int HEIGHT = 81;

    private static final int RADIUS = 84;

    private float elapsed;

    public Arena(Tankstars game){
        this.game = game;

    }

    @Override
    public void show() {
        img = new Texture("Arena - P1 Turn.jpg");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render(float delta) {
        elapsed += delta;

        game.batch.begin();

        game.batch.draw(img, 0 , 0, 1920, 1080);
        if (elapsed > 1.0 && elapsed < 2.0) {
            img = new Texture("Arena - Bullet Shoot - 1.jpg");
            game.batch.draw(img, 0 , 0, 1920, 1080);
        }
        if (elapsed > 2.0 && elapsed < 3.0) {
            img = new Texture("Arena - Bullet Shoot - 2.jpg");
            game.batch.draw(img, 0 , 0, 1920, 1080);
        }
        if (elapsed > 3.0 && elapsed < 4.0) {
            img = new Texture("Arena - Bullet Shoot - 3.jpg");
            game.batch.draw(img, 0 , 0, 1920, 1080);
        }
        if (elapsed > 4.0 && elapsed < 5.0) {
            img = new Texture("Arena - Bullet Shoot - 4 (Impact).jpg");
            game.batch.draw(img, 0 , 0, 1920, 1080);
        }
        if (elapsed > 5.0 && elapsed < 6.0) {
            img = new Texture("Arena - P2 Turn.jpg");
            game.batch.draw(img, 0, 0, 1920, 1080);
        }
        else{
            int x = 1763;
            int y = 90;

            if (( (Gdx.input.getX() > x && Gdx.input.getX() < (x + RADIUS) ) && (Gdx.input.getY() > y && Gdx.input.getY() < (y + RADIUS) ) )) {
                if (Gdx.input.isTouched()) {
                    this.dispose();
                    game.setScreen(new PausedArena(game));
                }
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
