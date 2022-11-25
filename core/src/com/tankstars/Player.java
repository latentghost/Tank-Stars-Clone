package com.tankstars;

public class Player {

    private Tank t;
    private int type;
    private int fuel;
    private int health;


    public int gettype(){
        return this.type;
    }

    public int gethealth(){
        return this.health;
    }

    public int getfuel(){
        return this.fuel;
    }

    public void addhealth(int x){
        this.health += x;
    }

    public void move(){

    }

    public void fire(){
        
    }

}
