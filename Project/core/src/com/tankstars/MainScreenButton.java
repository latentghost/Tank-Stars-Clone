package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class MainScreenButton implements Buttons {

    private final float WIDTH = 336f/1920*1280;
    private final float HEIGHT = 150f/1080*720;
    private String t;
    public Texture app;

    private float pos_x;
    private float pos_y;

    public MainScreenButton(float x, float y){
        this.pos_x = x;
        this.pos_y = y;
        app = new Texture("Normal Button.png");
    }

    public float getWIDTH() {
        return WIDTH;
    }

    public float getHEIGHT() {
        return HEIGHT;
    }

    public void setPos_x(float pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(float pos_y) {
        this.pos_y = pos_y;
    }

    @Override
    public void text(String s){
        app = new Texture("Normal Button.png");
        t = s;
    }

    @Override
    public boolean isClicked(){
        if(Gdx.input.getX()>this.pos_x && Gdx.input.getX()<this.pos_x+this.WIDTH
                && Gdx.input.getY()<720-this.pos_y && Gdx.input.getY()>720-(this.pos_y+this.HEIGHT)){
            return true;
        }
        else return false;
    }

    public void norm(){
        app = new Texture("Normal Button.png");
    }

    public void hover(){
        app = new Texture("Normal Button Hover.png");
    }

}
