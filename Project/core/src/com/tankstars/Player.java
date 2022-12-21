package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.io.Serializable;

public class Player implements Serializable {

    private Tank t;
    private int type;

    private int fuel;
    private int health;

    private float mx;
    private float my;
    private double comp;


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

    public float golaeqn(int i){
        float a = (float) Math.toRadians(this.t.getangle());
        float b = 30f*i*Main.xm;
        float c = 30f*Main.xm*((float) Math.cos(a));
        return (float) (b*Math.tan(a) - (0.9f)*b*b/(2*c*c));
    }

    public void currturn(){
        if(type!=0){
            if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                this.t.setAngle(Math.min(60, this.t.getangle() + 1));
            } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                this.t.setAngle((Math.max(0, this.t.getangle() - 1)));
            }
        }
        int m = type;
        if(m==0) m=1;
        Texture gola = new Texture("Gola.png");
        float x = 0f;
        if(type==1 || type==0) x = this.t.getx()+140*Main.xm;
        else if(type==-1) x = this.t.getx() - 15*Main.xm;
        for(int i=0; i<10; i++){
            Main.game.batch.draw(gola,x + 30*i*m*Main.xm,this.t.gety() + 60*Main.ym + golaeqn(i),9*Main.xm,9*Main.ym);
        }
        this.move();
        if(this.fuel<50 && this.type==0) {
            this.getTank().setBul(new Bullet(this.getTank().gettype(),this.getType()));
            this.setbul();
            Main.shoot();
        }
    }

    public void move(){
        if(this.type==0 && this.fuel>50){
            if(this.fuel==100) comp = Math.random()-0.5;
            if(comp<=0) this.t.moveright();
            else this.t.moveright();
            this.fuel -= 1;
        }
        else if(this.fuel>0){
            if(Gdx.input.getX()>216*Main.xm && Gdx.input.getX()<285*Main.xm && Gdx.input.getY()<720-106.06*Main.ym && Gdx.input.getY()>720-183*Main.ym) {
                if (Gdx.input.isTouched()) {
                    this.mx = 223f;
                    this.fuel -= 1;
                    this.getTank().moveleft();
                }
                else this.mx = 290.05f;
            }
            else if(Gdx.input.getX()>367*Main.xm && Gdx.input.getX()<442*Main.xm && Gdx.input.getY()<720-106.06*Main.ym && Gdx.input.getY()>720-183*Main.ym){
                if(Gdx.input.isTouched()){
                    this.mx = 359f;
                    this.fuel -= 1;
                    this.getTank().moveright();
                }
                else this.mx = 290.05f;
            }
            else this.mx = 290.05f;
        }
        else this.mx = 290.05f;
    }

    public void fire(Tank target){
        Main.game.batch.draw(this.t.getBul().img,this.t.getBul().getPos_x(),this.t.getBul().getPos_y(),60*Main.xm,33*Main.ym);
        this.t.fire(target,this.type);
    }

    public void setbul(){
        if(this.type==1) this.t.getBul().setPos_x(this.getTank().getx() + 124*Main.xm);
        else if(this.type==-1) this.t.getBul().setPos_x(this.getTank().getx()-4*Main.xm);
        this.t.getBul().setPos_y(this.getTank().gety() + 45*Main.ym);
    }

}
