package com.tankstars;

import com.badlogic.gdx.graphics.Texture;

public class MainScreenButton implements Buttons {

    private final float WIDTH = 336f;
    private final float HEIGHT = 107f;
    private String t;
    public Texture app;

    private float pos_x;
    private float pos_y;

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
    public void isClicked(){
        return;
    }

    public void norm(){
        app = new Texture("Normal Button.png");
    }

    public void hover(){
        app = new Texture("Normal Button Hover.png");
    }

}
