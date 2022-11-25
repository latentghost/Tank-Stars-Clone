package com.tankstars;

public abstract class Tank {
    private int type;
    private Bullet bul;
    private float pos_x;
    private float pos_y;
    private int angle;
    private int power;


    public int gettype(){
        return this.type;
    }

    public int getangle(){
        return this.angle;
    }

    public int getpower(){
        return this.power;
    }

    public float getx(){
        return this.pos_x;
    }

    public float gety(){
        return this.pos_y;
    }

    public void moveright(){

    }

    public void moveleft(){

    }

}
