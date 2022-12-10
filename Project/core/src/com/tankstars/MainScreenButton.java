package com.tankstars;

public class MainScreenButton implements Buttons {

    private final float WIDTH = 336f;
    private final float HEIGHT = 107f;

    private float pos_x;
    private float pos_y;


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
    public void isClicked(){
        return;
    }

}
