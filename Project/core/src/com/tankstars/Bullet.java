package com.tankstars;

import com.badlogic.gdx.graphics.Texture;

public class Bullet {

    private float pos_x;
    private float pos_y;
    private float vel;
    private float dist;

    transient protected Texture img;


    public Bullet(int type,int p){
        if(p==1 || p==0){
            if(type==0) this.img = new Texture("Bullet - Abrams P1.png");
            else if(type==2) this.img = new Texture("Bullet - Coalition P1.png");
            else this.img = new Texture("Bullet - Mark 1 P1.png");
        }
        else{
            if(type==0) this.img = new Texture("Bullet - Abrams.png");
            else if(type==2) this.img = new Texture("Bullet - Coalition.png");
            else this.img = new Texture("Bullet - Mark 1.png");
        }
        this.pos_x = 0f;
        this.pos_y = 0f;
        this.vel = 10*Main.xm;
        this.dist = 0f;
    }

    public float getPos_x() {
        return pos_x;
    }

    public void setPos_x(float pos_x) {
        this.pos_x = pos_x;
    }

    public float getPos_y() {
        return pos_y;
    }

    public void setPos_y(float pos_y) {
        this.pos_y = pos_y;
    }

    public void travel(float angle, int mul){
        this.pos_x += mul*vel;
        this.dist += mul*vel;
        this.pos_y = Main.getgr() + 45f*Main.xm + (float) (mul*this.dist*Math.tan(Math.toRadians(angle)) - (0.1f)*(this.dist/this.vel)*(this.dist/this.vel));
    }

    public int impact(){
        Texture exp = new Texture("Explosion.png");
        Main.game.batch.draw(exp,this.pos_x-50*Main.xm,Main.getgr(),283*Main.xm,122*Main.ym);
        if(Math.abs(this.pos_x-Main.getp1().getTank().getx())<100){
            Main.setRedhel(15);
        }
        else if(Math.abs(this.pos_x-Main.getp2().getTank().getx())<100){
            Main.setRedhel(-15);
        }
        Main.setChanged(1);
        return 0;
    }

    public int impact(Tank t,int ty){
        Texture exp = new Texture("Explosion.png");
        Main.game.batch.draw(exp,t.getx()-50*Main.xm,Main.getgr(),283*Main.xm,122*Main.ym);
        Main.setRedhel(-1*ty*(30));
        Main.setChanged(1);
        return 0;
    }
}
