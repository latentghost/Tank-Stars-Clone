package com.tankstars;

public class QuitButton implements Buttons{

    private final float WIDTH = 166f;
    private final float HEIGHT = 80.17f;

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
    public boolean isClicked(){

        return false;
    }
}
