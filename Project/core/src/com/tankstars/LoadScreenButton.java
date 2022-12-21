package com.tankstars;

import com.badlogic.gdx.Gdx;

public class LoadScreenButton implements Buttons {

    private final float WIDTH = 280f*Main.xm;
    private final float HEIGHT = 89.17f*Main.ym;

    private float pos_x;
    private float pos_y;


    public LoadScreenButton(float x, float y){
        this.pos_x = x;
        this.pos_y = y;
    }

    public float getWIDTH() {
        return WIDTH;
    }

    public float getHEIGHT() {
        return HEIGHT;
    }

    public float getPos_x() {
        return pos_x;
    }

    public float getPos_y() {
        return pos_y;
    }

    public void setPos_x(float pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(float pos_y) {
        this.pos_y = pos_y;
    }

    @Override
    public void text(String s){
        return;
    }

    @Override
    public boolean isClicked(){
        if(Gdx.input.getX()>this.pos_x && Gdx.input.getX()<this.pos_x+this.WIDTH
                && Gdx.input.getY()<720-this.pos_y && Gdx.input.getY()>720-(this.pos_y+this.HEIGHT)){
            if(Gdx.input.isTouched()){
                return true;
            }
            else return false;
        }
        else return false;
    }
}
