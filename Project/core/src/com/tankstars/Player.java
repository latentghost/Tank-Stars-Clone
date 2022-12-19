package com.tankstars;

public class Player {

    private Tank t;
    private int type;

    private int fuel;
    private int health;


    public Player(int ty){
        this.type = ty;
    }

    public Tank getTank() {
        return t;
    }

    public int getType() {
        return type;
    }

    public int getFuel() {
        return fuel;
    }

    public int getHealth() {
        return health;
    }

    public void setTank(Tank tank){
        this.t = tank;
    }

    public void move(){

    }

    public void fire() {

    }

}
