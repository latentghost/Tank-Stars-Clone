package com.tankstars;

import com.badlogic.gdx.Gdx;

public class Player {

    private Tank t;
    private int type;

    private int fuel;
    private int health;

    private float mx;
    private float my;


    public Player(int ty, int tank){
        this.type = ty;
        this.t = new Tank(tank,ty);

        this.health = 100;
        this.fuel = 100;
        this.mx = 290.05f;
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

    public float getMx() {
        return mx;
    }

    public float getMy() {
        return my;
    }

    public void setTank(Tank tank){
        this.t = tank;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void currturn(){
        this.move();
    }

    public void move(){
        if(this.fuel>0){
            if(Gdx.input.getX()>216*Main.xm && Gdx.input.getX()<285*Main.xm && Gdx.input.getY()<720-106.06*Main.ym && Gdx.input.getY()>720-183*Main.ym) {
                if (Gdx.input.isTouched()) {
                    this.mx = 223f;
                    this.fuel -= 1;
                    this.getTank().moveleft(this.type);
                }
                else this.mx = 290.05f;
            }
            else if(Gdx.input.getX()>367*Main.xm && Gdx.input.getX()<442*Main.xm && Gdx.input.getY()<720-106.06*Main.ym && Gdx.input.getY()>720-183*Main.ym){
                if(Gdx.input.isTouched()){
                    this.mx = 359f;
                    this.fuel -= 1;
                    this.getTank().moveright(this.type);
                }
                else this.mx = 290.05f;
            }
            else this.mx = 290.05f;
        }
        else this.mx = 290.05f;
    }

    public void fire(Tank target){
        Main.game.batch.draw(this.t.getBul().img,this.t.getBul().getPos_x(),this.t.getBul().getPos_y(),60*Main.xm,33*Main.ym);
        this.t.setAngle(30);
        this.t.fire(target,this.type);
    }

    public void setbul(){
        if(this.type==1) this.t.getBul().setPos_x(this.getTank().getx() + 124*Main.xm);
        else if(this.type==-1) this.t.getBul().setPos_x(this.getTank().getx());
        this.t.getBul().setPos_y(this.getTank().gety() + 45*Main.ym);
    }

}
