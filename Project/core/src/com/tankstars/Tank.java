package com.tankstars;

public abstract class Tank {
    private int type;
    private Bullet bul;

    private float pos_x;
    private float pos_y;

    private int angle;
    private int power;


    public float getx() {
        return pos_x;
    }

    public float gety() {
        return pos_y;
    }

    public int getangle() {
        return angle;
    }

    public int getpower() {
        return power;
    }

    public int gettype() {
        return type;
    }

    public void moveleft(){

    }

    public void moveright(){

    }

}
