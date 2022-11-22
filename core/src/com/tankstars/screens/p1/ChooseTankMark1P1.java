package com.tankstars.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.Tankstars;


class ChooseTankMark1P1 implements Screen {

    Tankstars game;
    Texture img;

    private static final int WIDTH = 336;
    private static final int HEIGHT = 107;
    private static final int RADIUS = 69;

    private static final int RADIUS1 = 116;

    public ChooseTankMark1P1(Tankstars game){
        this.game = game;
    }

    @Override
    public void show() {
        img = new Texture("Choose Tank - P1 - 3.jpg");
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render(float delta) {
        game.batch.begin();

        int x = 1468;
        int y = 761;

        int a = 1386;
        int b = 32;

        int ax = 1438;
        int ay = 467;

        int bx = 1578;
        int by = 467;

        int cx = 1718;
        int cy = 467;

        if ( (Gdx.input.getX() > a && Gdx.input.getX() < (a + RADIUS) ) && (Gdx.input.getY() > b && Gdx.input.getY() < (b + RADIUS) ) ) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new MainScreen(game));
            }
        }
        else if ( (Gdx.input.getX() > x && Gdx.input.getX() < (x + WIDTH) ) && (Gdx.input.getY() > y && Gdx.input.getY() < (y + HEIGHT) ) ) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.ChooseTankAbramsP2(game));
            }
        }
        else if ( (Gdx.input.getX() > ax && Gdx.input.getX() < (ax + RADIUS1) ) && (Gdx.input.getY() > ay && Gdx.input.getY() < (ay + RADIUS1) ) ) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.ChooseTankAbramsP1(game));
            }
        }
        else if ( (Gdx.input.getX() > bx && Gdx.input.getX() < (bx + RADIUS1) ) && (Gdx.input.getY() > by && Gdx.input.getY() < (by + RADIUS1) ) ) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.ChooseTankMark1P1(game));
            }
        }
        else if ( (Gdx.input.getX() > cx && Gdx.input.getX() < (cx + RADIUS1) ) && (Gdx.input.getY() > cy && Gdx.input.getY() < (cy + RADIUS1) ) ) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new com.tankstars.screens.ChooseTankCoalitionP1(game));
            }
        }
        else{
            game.batch.draw(img, 0,0,1920,1080);
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
