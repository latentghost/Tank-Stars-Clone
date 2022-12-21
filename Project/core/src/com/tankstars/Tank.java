package com.tankstars;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Null;

public class Tank {
    private int type;
    private Bullet bul;
    transient protected Texture img;

    private final float WIDTH = 131f/1920*1280;
    private final float HEIGHT = 76f/1080*720;

    private float pos_x;
    private float pos_y;

    private int angle;
    private int power;


    public Tank(int tnk,int ty){
        this.type = tnk;
        if(ty==1 || ty==0){
            if(tnk==0) this.img = new Texture("Abrams - P1.png");
            else if(tnk==1) this.img = new Texture("Mark 1 - P1.png");
            else this.img = new Texture("Coalition - P1.png");
        }
        else{
            if(tnk==0) this.img = new Texture("Abrams - P2.png");
            else if(tnk==1) this.img = new Texture("Mark 1 - P2.png");
            else this.img = new Texture("Coalition - P2.png");
        }
        this.angle = 45;
    }

    public void setBul(Bullet bul) {
        this.bul = bul;
    }

    public float getHEIGHT() {
        return HEIGHT;
    }

    public float getWIDTH() {
        return WIDTH;
    }

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

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setPos_x(float pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(float pos_y) {
        this.pos_y = pos_y;
    }

    public int gettype() {
        return type;
    }

    public void moveleft(){
        this.setPos_x(this.pos_x - 2);
        this.setPos_y(Main.getgr());
    }

    public void moveright(){
        this.setPos_x(this.pos_x + 2);
        this.setPos_y(Main.getgr());
    }

    public Bullet getBul() {
        return bul;
    }

    public void fire(Tank target, int ty){
        this.bul.travel(this.angle,ty);
        if((this.getBul().getPos_x()>=target.getx() && this.getBul().getPos_x()<=target.getx()+120*Main.xm)
                && (this.getBul().getPos_y()<=target.gety()+71*Main.ym && this.getBul().getPos_y()>=target.gety()))
        {
            Main.setFd(this.getBul().impact(target,ty));
            Main.setCt(1);
        }
        else if(this.getBul().getPos_y()<Main.getgr())
        {
            Main.setFd(this.getBul().impact());
            Main.setCt(1);
        }
    }

}
