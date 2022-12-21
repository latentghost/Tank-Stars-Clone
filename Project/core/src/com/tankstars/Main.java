package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.screens.*;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main extends MainScreen {
    private static Player p1;
    private static Player p2;

    private Drops drop;
    
    protected static float xm = 1280f/1920;
    protected static float ym = 720f/1080;

    private static final float gr_h = 363f*ym;
    private static int turn = 1;
    private static int ct = 0;
    private static int fd = 0;
    private static int changed = 0;
    private static int redhel = 0;
    private static int paused = 0;
    private static int saving = 0;

    private static MainScreenButton vscom;
    private static MainScreenButton vsfr;
    private static MainScreenButton load;
    private static MainScreenButton quit;

    private static MainScreenButton l1;
    private static MainScreenButton l2;
    private static MainScreenButton l3;

    private static PauseMenu pmenu;
    private static SaveMenu smenu;
    private static QuitMenu qmenu;


    public Main(Tankstars game){
        super(game);
        vscom = new MainScreenButton(1468f*xm,746f*ym);
        load = new MainScreenButton(1468f*xm,400f*ym);
        quit = new MainScreenButton(1468f*xm,227f*ym);
        vsfr = new MainScreenButton(1468f*xm,573f*ym);
        l2 = new MainScreenButton(1468f*xm,400f*ym);
        l3 = new MainScreenButton(1468f*xm,227f*ym);
        l1 = new MainScreenButton(1468f*xm,573f*ym);
        this.play();
    }

    public static void setSaving(int saving) {
        Main.saving = saving;
    }

    public static void setPaused(int paused) {
        Main.paused = paused;
    }

    public static void setChanged(int changed) {
        Main.changed = changed;
    }

    public static void setRedhel(int redhel) {
        Main.redhel = redhel;
    }

    public static void setCt(int ct) {
        Main.ct = ct;
    }

    public static void setFd(int fd) {
        Main.fd = fd;
    }

    public static Player getp1() {
        return Main.p1;
    }

    public static Player getp2() {
        return Main.p2;
    }

    public static float getgr() {
        return gr_h;
    }


    public static void loadgame(){
        game.batch.begin();
        game.batch.draw(img,0,0,1280,720);

        float x = 1468f*xm;
        float b = 573f*ym;
        float z = 400f*ym;
        float a = 227f*ym;

        Texture text = new Texture("Load Game Render.png");
        game.batch.draw(text,x,746f*ym,l1.getWIDTH(),l1.getHEIGHT()-30*ym);
        game.batch.draw(l1.app,x,b,l1.getWIDTH(),l1.getHEIGHT());
        game.batch.draw(l2.app,x,z,l2.getWIDTH(),l2.getHEIGHT());
        game.batch.draw(l3.app,x,a,l3.getWIDTH(),l3.getHEIGHT());

        if (l1.isClicked()) {
            l1.hover();
            game.batch.draw(l1.app,x,b,l1.getWIDTH(),l1.getHEIGHT());
            if (Gdx.input.isTouched()) {
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new ChooseTankP1(game));
            }
        }

        else if (l2.isClicked()){
            l2.hover();
            game.batch.draw(l2.app,x,z,l2.getWIDTH(),l2.getHEIGHT());
            if (Gdx.input.isTouched()) {
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new LoadGame(game));
            }
        }

        else if(l3.isClicked()){
            l3.hover();
            game.batch.draw(l3.app,x,a,l3.getWIDTH(),l3.getHEIGHT());
            if (Gdx.input.isTouched()) {
                Main.quitgame();
            }
        }

        else{
            l1.norm();
            l2.norm();
            l3.norm();
            game.batch.draw(l1.app,x,b,l1.getWIDTH(),l1.getHEIGHT());
            game.batch.draw(l2.app,x,z,l2.getWIDTH(),l2.getHEIGHT());
            game.batch.draw(l3.app,x,a,l3.getWIDTH(),l3.getHEIGHT());
        }

        float bx = 1386f*xm;
        float by = 979f*ym;
        float bw = 69f/1920*1080;
        Texture back = new Texture("Back Button.png");
        game.batch.draw(back,bx,by,bw,bw);

        if(Gdx.input.getX()>bx && Gdx.input.getX()<bx+bw && Gdx.input.getY()<720-by && Gdx.input.getY()>(720-by-bw)){
            if(Gdx.input.isTouched()) {
                game.getScreen().dispose();
                game.resize(1280, 720);
                game.setScreen(new MainScreen(game));
            }
        }

        Texture t2 = new Texture("Frame 7.png");
        Texture t3 = new Texture("Frame 8.png");
        Texture t4 = new Texture("Frame 9.png");

        game.batch.draw(t2,1491*xm,608*ym+20*ym,290*xm,38*ym);
        game.batch.draw(t3,1487*xm,435*ym+20*ym,299*xm,38*ym);
        game.batch.draw(t4,1494*xm,261*ym+20*ym,285*xm,38*ym);

        ObjectInputStream in = null;
        FileInputStream pl = null;
        FileInputStream tank = null;
        FileInputStream bul = null;

        if(l1.isClicked() && Gdx.input.isTouched()){
            try{
                pl = new FileInputStream("player1.txt");
                in = new ObjectInputStream(pl);
                p1 = (Player) in.readObject();
                tank = new FileInputStream("tank1.txt");
                in = new ObjectInputStream(tank);
                p1.setTank((Tank) in.readObject());
                bul = new FileInputStream("bullet1.txt");
                in = new ObjectInputStream(bul);
                p1.getTank().setBul((Bullet) in.readObject());
                pl = new FileInputStream("player2.txt");
                in = new ObjectInputStream(pl);
                p2 = (Player) in.readObject();
                tank = new FileInputStream("tank2.txt");
                in = new ObjectInputStream(tank);
                p2.setTank((Tank) in.readObject());
                bul = new FileInputStream("bullet2.txt");
                in = new ObjectInputStream(bul);
                p2.getTank().setBul((Bullet) in.readObject());
            }
            catch (Exception e){;}
            finally {
                try{
                    in.close();
                }
                catch (Exception e){;}
            }

            game.getScreen().dispose();
            game.resize(1280,720);
            game.setScreen(new Arena(game));
        }
        else if(l2.isClicked() && Gdx.input.isTouched()){
            try{
                pl = new FileInputStream("player1.txt");
                in = new ObjectInputStream(pl);
                p1 = (Player) in.readObject();
                tank = new FileInputStream("tank1.txt");
                in = new ObjectInputStream(tank);
                p1.setTank((Tank) in.readObject());
                bul = new FileInputStream("bullet1.txt");
                in = new ObjectInputStream(bul);
                p1.getTank().setBul((Bullet) in.readObject());
                pl = new FileInputStream("player2.txt");
                in = new ObjectInputStream(pl);
                p2 = (Player) in.readObject();
                tank = new FileInputStream("tank2.txt");
                in = new ObjectInputStream(tank);
                p2.setTank((Tank) in.readObject());
                bul = new FileInputStream("bullet2.txt");
                in = new ObjectInputStream(bul);
                p2.getTank().setBul((Bullet) in.readObject());
            }
            catch (Exception e){;}
            finally {
                try{
                    in.close();
                }
                catch (Exception e){;}
            }

            game.getScreen().dispose();
            game.resize(1280,720);
            game.setScreen(new Arena(game));
        }
        else if(l3.isClicked() && Gdx.input.isTouched()){
            try{
                pl = new FileInputStream("player1.txt");
                in = new ObjectInputStream(pl);
                p1 = (Player) in.readObject();
                tank = new FileInputStream("tank1.txt");
                in = new ObjectInputStream(tank);
                p1.setTank((Tank) in.readObject());
                bul = new FileInputStream("bullet1.txt");
                in = new ObjectInputStream(bul);
                p1.getTank().setBul((Bullet) in.readObject());
                pl = new FileInputStream("player2.txt");
                in = new ObjectInputStream(pl);
                p2 = (Player) in.readObject();
                tank = new FileInputStream("tank2.txt");
                in = new ObjectInputStream(tank);
                p2.setTank((Tank) in.readObject());
                bul = new FileInputStream("bullet2.txt");
                in = new ObjectInputStream(bul);
                p2.getTank().setBul((Bullet) in.readObject());
            }
            catch (Exception e){;}
            finally {
                try{
                    in.close();
                }
                catch (Exception e){;}
            }

            game.getScreen().dispose();
            game.resize(1280,720);
            game.setScreen(new Arena(game));
        }

        game.batch.end();
    }

    public void play(){
        game.batch.begin();

        game.batch.draw(img,0,0,1280,720);

        vscom.text("VS COMPUTER");
        vsfr.text("VS FRIEND");
        load.text("LOAD GAME");
        quit.text("QUIT");

        float x = 1468f*xm;
        float y = 746f*ym;
        float b = 573f*ym;
        float z = 400f*ym;
        float a = 227f*ym;

        game.batch.draw(vscom.app,x,y,vscom.getWIDTH(),vscom.getHEIGHT());
        game.batch.draw(vsfr.app,x,b,vsfr.getWIDTH(),vsfr.getHEIGHT());
        game.batch.draw(load.app,x,z,load.getWIDTH(),load.getHEIGHT());
        game.batch.draw(quit.app,x,a,quit.getWIDTH(),quit.getHEIGHT());

        if (vscom.isClicked()) {
            vscom.hover();
            game.batch.draw(vscom.app,x,y,vscom.getWIDTH(),vscom.getHEIGHT());
            if (Gdx.input.isTouched()) {
                p1 = new Player(0,ChooseTankP1.ind);
                p1.getTank().setPos_x(151.41f*xm);
                p1.getTank().setPos_y(gr_h);
                turn = 0;
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new ChooseTankP2(game));
            }
        }

        else if (vsfr.isClicked()) {
            vsfr.hover();
            game.batch.draw(vsfr.app,x,b,vsfr.getWIDTH(),vsfr.getHEIGHT());
            if (Gdx.input.isTouched()) {
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new ChooseTankP1(game));
            }
        }

        else if (load.isClicked()){
            load.hover();
            game.batch.draw(load.app,x,z,load.getWIDTH(),load.getHEIGHT());
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.resize(1280,720);
                game.setScreen(new LoadGame(game));
            }
        }

        else if(quit.isClicked()){
            quit.hover();
            game.batch.draw(quit.app,x,a,quit.getWIDTH(),quit.getHEIGHT());
            if (Gdx.input.isTouched()) {
                Main.quitgame();
            }
        }

        else{
            vscom.norm();
            vsfr.norm();
            load.norm();
            quit.norm();
            game.batch.draw(vscom.app,x,y,vscom.getWIDTH(),vscom.getHEIGHT());
            game.batch.draw(vsfr.app,x,b,vsfr.getWIDTH(),vsfr.getHEIGHT());
            game.batch.draw(load.app,x,z,load.getWIDTH(),load.getHEIGHT());
            game.batch.draw(quit.app,x,a,quit.getWIDTH(),quit.getHEIGHT());
        }

        Texture t1 = new Texture("Frame 3.png");
        Texture t2 = new Texture("Frame 4.png");
        Texture t3 = new Texture("Frame 5.png");
        Texture t4 = new Texture("Frame 6.png");

        game.batch.draw(t1,1500*xm,781*ym+20*ym,280*xm,38*ym);
        game.batch.draw(t2,1491*xm,608*ym+20*ym,290*xm,38*ym);
        game.batch.draw(t3,1487*xm,435*ym+20*ym,299*xm,38*ym);
        game.batch.draw(t4,1494*xm,261*ym+20*ym,285*xm,38*ym);

        game.batch.end();
    }

    public static void choosep1(){

        game.batch.begin();
        img = new Texture("Choose Tank Render.png");
        float bx = 1386f*xm;
        float by = 979f*ym;
        float bw = 69f/1920*1080;

        Texture[] tanks = new Texture[]{new Texture("Abrams Choose.png"), new Texture("Mark 1 Choose.png"), new Texture("Coalition Choose.png")};
        Texture[] name = new Texture[]{new Texture("Frame 10.png"),new Texture("Frame 11.png"),new Texture("Frame 12.png")};
        Texture back = new Texture("Back Button.png");
        Texture curr = tanks[ChooseTankP1.ind];
        Texture cname = name[ChooseTankP1.ind];
        Texture ts = new Texture("Choose Tank.png");
        Texture p = new Texture("p1.png");
        MainScreenButton sel = new MainScreenButton(1468f*xm,212*ym);
        sel.text("Select");

        game.batch.draw(img,0,0,1280,720);
        game.batch.draw(back,bx,by,bw,bw);
        game.batch.draw(ts,1438f*xm,497f*ym,396f*xm,116f*ym);
        game.batch.draw(p,1565f*xm,711f*ym,143f*xm,72f*ym);
        game.batch.draw(sel.app,1468f*xm,212*ym,sel.getWIDTH(),sel.getHEIGHT());
        game.batch.draw(curr,339f*xm,224f*ym,674*xm,432*ym);
        game.batch.draw(cname,534*xm,888*ym,285*xm,38*ym);

        if(Gdx.input.getX()>bx && Gdx.input.getX()<bx+bw && Gdx.input.getY()<720-by && Gdx.input.getY()>(720-by-bw)){
            if(Gdx.input.isTouched()) {
                game.getScreen().dispose();
                game.resize(1280, 720);
                game.setScreen(new MainScreen(game));
            }
        }

        if(Gdx.input.getX()>1468f*xm && Gdx.input.getX()<(1468f*xm + sel.getWIDTH()) && Gdx.input.getY()<720f-212f*ym && Gdx.input.getY()>(720f-212f*ym-sel.getHEIGHT())){
            sel.hover();
            game.batch.draw(sel.app,1468f*xm,212f*ym,sel.getWIDTH(),sel.getHEIGHT());
            if(Gdx.input.isTouched()) {
                p1 = new Player(1,ChooseTankP1.ind);
                p1.getTank().setPos_x(151.41f*xm);
                p1.getTank().setPos_y(gr_h);
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new ChooseTankP2(game));
            }
        }
        else{
            sel.norm();
            game.batch.draw(sel.app,1468f*xm,212*ym,sel.getWIDTH(),sel.getHEIGHT());
        }

        if(Gdx.input.getX()>1358*xm && Gdx.input.getX()<(1358*xm+56*xm) && Gdx.input.getY()<720-527*ym && Gdx.input.getY()>(720-527*ym-57*ym)){
            if(Gdx.input.isTouched()){
                ChooseTankP1.ind -= 1;
                if(ChooseTankP1.ind<0) ChooseTankP1.ind += 3;
            }
        }
        if(Gdx.input.getX()>1857*xm && Gdx.input.getX()<1857*xm+56*xm && Gdx.input.getY()<720-527*ym && Gdx.input.getY()>(720-527*ym-57*ym)){
            if(Gdx.input.isTouched()){
                ChooseTankP1.ind += 1;
                if(ChooseTankP1.ind>2) ChooseTankP1.ind -= 3;
            }
        }

        Texture sl = new Texture("Frame 21.png");
        game.batch.draw(sl,1494*xm,266*ym,285*xm,38*ym);

        game.batch.end();

    }

    public static void choosep2(){

        game.batch.begin();
        img = new Texture("Choose Tank Render.png");
        float bx = 1386f*xm;
        float by = 979f*ym;
        float bw = 69f/1920*1080;
        Texture[] tanks = new Texture[]{new Texture("Abrams Choose.png"), new Texture("Mark 1 Choose.png"), new Texture("Coalition Choose.png")};
        Texture[] name = new Texture[]{new Texture("Frame 10.png"),new Texture("Frame 11.png"),new Texture("Frame 12.png")};
        Texture back = new Texture("Back Button.png");
        Texture curr = tanks[ChooseTankP2.ind];
        Texture cname = name[ChooseTankP2.ind];
        Texture ts = new Texture("Choose Tank.png");
        Texture p = new Texture("p2.png");
        MainScreenButton sel = new MainScreenButton(1468f*xm,212*ym);
        sel.text("Select");

        game.batch.draw(img,0,0,1280,720);
        game.batch.draw(back,bx,by,bw,bw);
        game.batch.draw(ts,1438f*xm,497f*ym,396f*xm,116f*ym);
        game.batch.draw(p,1565f*xm,711f*ym,143f*xm,72f*ym);
        game.batch.draw(sel.app,1468f*xm,212*ym,sel.getWIDTH(),sel.getHEIGHT());
        game.batch.draw(curr,339f*xm,224f*ym,674*xm,432*ym);
        game.batch.draw(cname,534*xm,888*ym,285*xm,38*ym);

        if(Gdx.input.getX()>bx && Gdx.input.getX()<bx+bw && Gdx.input.getY()<720-by && Gdx.input.getY()>(720-by-bw)){
            if(Gdx.input.isTouched()) {
                game.getScreen().dispose();
                game.resize(1280, 720);
                game.setScreen(new MainScreen(game));
            }
        }

        if(Gdx.input.getX()>1468f*xm && Gdx.input.getX()<(1468f*xm + sel.getWIDTH()) && Gdx.input.getY()<720f-212f*ym && Gdx.input.getY()>(720f-212f*ym-sel.getHEIGHT())){
            sel.hover();
            game.batch.draw(sel.app,1468f*xm,212f*ym,sel.getWIDTH(),sel.getHEIGHT());
            if(Gdx.input.isTouched()) {
                p2 = new Player(-1,ChooseTankP2.ind);
                p2.getTank().setPos_x(1631.94f*xm);
                p2.getTank().setPos_y(gr_h);
                game.getScreen().dispose();
                game.resize(1280,720);
                Arena ar = new Arena(game);
                game.setScreen(ar);
            }
        }
        else{
            sel.norm();
            game.batch.draw(sel.app,1468f*xm,212*ym,sel.getWIDTH(),sel.getHEIGHT());
        }

        if(Gdx.input.getX()>1358*xm && Gdx.input.getX()<(1358*xm+56*xm)
                && Gdx.input.getY()<720-527*ym && Gdx.input.getY()>(720-527*ym-57*ym)){
            if(Gdx.input.isTouched()){
                ChooseTankP2.ind -= 1;
                if(ChooseTankP2.ind<0) ChooseTankP2.ind += 3;
            }
        }
        if(Gdx.input.getX()>1857*xm && Gdx.input.getX()<1857*xm+56*xm
                && Gdx.input.getY()<720-527*ym && Gdx.input.getY()>(720-527*ym-57*ym)){
            if(Gdx.input.isTouched()){
                ChooseTankP2.ind += 1;
                if(ChooseTankP2.ind>2) ChooseTankP2.ind -= 3;
            }
        }

        Texture sl = new Texture("Frame 22.png");
        game.batch.draw(sl,1494*xm,266*ym,265*xm,38*ym);

        game.batch.end();

    }

    public static final void arena(){
        game.batch.begin();
        if(saving==1){
            game.batch.setColor(1,1,1,0.05f);
            Main.drawarena(turn);
            game.batch.setColor(1,1,1,1);
            Main.drawsave();
            game.batch.end();
            return;
        }
        if(paused==1){
            game.batch.setColor(1,1,1,0.05f);
            Main.drawarena(turn);
            game.batch.setColor(1,1,1,1);
            Main.drawpause();
            game.batch.end();
            return;
        }
        if(changed==1){
            Main.waits();
            changed = 0;
        }
        if(redhel!=0){
            Main.reduce();
            Main.drawarena(turn);
            game.batch.end();
            return;
        }
        Main.drawarena(turn);
        if(fd==0) Main.taketurn(turn);
        Main.pausegame();
        Main.fired();
        if(fd==1){
            Main.shoot();
            if(ct==1) Main.changeturn();
        }
        game.batch.end();
    }

    public static void waits(){
        try{Thread.sleep(500);}
        catch(InterruptedException e){;}
    }

    public static void reduce(){
        if(redhel>0) {
            p1.setHealth(p1.getHealth() - 1);
            redhel--;
            if(p1.getHealth()==0){
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new MainScreen(game));
            }
        }
        else {
            p2.setHealth(p2.getHealth() - 1);
            redhel++;
            if(p2.getHealth()==0){
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new MainScreen(game));
            }
        }
    }

    public static void taketurn(int turn){
        if(turn==1 || turn==0) p1.currturn();
        else if(turn==-1) p2.currturn();
    }

    public static void drawarena(int turn){
        Texture bg = new Texture("Arena Render.jpg");
        Texture p1hb = new Texture("P1 health back.png");
        Texture p2hb = new Texture("P2 health back.png");
        Texture p1hf = new Texture("P1 health front.png");
        Texture p2hf = new Texture("P2 health front.png");
        Texture fire = new Texture("Fire.png");
        Texture mb = new Texture("Move Button.png");
        Texture mg = new Texture("Move gola.png");
        Texture fb = new Texture("Fuel back.png");
        Texture ff = new Texture("Fuel front.png");
        Texture ft = new Texture("Fueltext.png");

        float mx = xm;
        float my = 108.95f*ym;
        if(turn==1 || turn==0) mx *= p1.getMx();
        else if(turn==-1) mx *= p2.getMx();

        int tf = 0;
        if(turn==1 || turn==0) tf = p1.getFuel();
        else if(turn==-1) tf = p2.getFuel();

        game.batch.draw(bg,0,0,1280,720);
        game.batch.draw(p1hb,251*xm,912*ym,626*xm,72*ym);
        game.batch.draw(p2hb,1043*xm,912*ym,626*xm,72*ym);
        game.batch.draw(p1hf,251*xm,912*ym,626*p1.getHealth()/100f*xm,72*ym);
        game.batch.draw(p2hf,(1043 + 626-(626f*p2.getHealth()/100))*xm,912*ym,626f*p2.getHealth()/100*xm,72*ym);
        game.batch.draw(fire,1310*xm,113*ym,227*xm,87.02f*ym);
        game.batch.draw(mb,211*xm,101.06f*ym,236*xm,86.94f*ym);
        game.batch.draw(mg,mx,my,76.94f*xm,71.17f*ym);
        game.batch.draw(fb,216*xm,206*ym,226*xm,36*ym);
        game.batch.draw(ff,216*xm,206*ym,226f*tf/100*xm,36*ym);
        game.batch.draw(ft,261*xm,214*ym,135*xm,20*ym);

        Texture t1 = p1.getTank().img;
        Texture t2 = p2.getTank().img;
        game.batch.draw(t1,p1.getTank().getx(),p1.getTank().gety(),p1.getTank().getWIDTH(),p1.getTank().getHEIGHT());
        game.batch.draw(t2,p2.getTank().getx(),p2.getTank().gety(),p2.getTank().getWIDTH(),p2.getTank().getHEIGHT());
    }

    public static void fired(){
        if(Gdx.input.getX()>1310*xm && Gdx.input.getX()<(1310+227)*xm && Gdx.input.getY()<720-113*ym && Gdx.input.getY()>720-200*ym){
            if(Gdx.input.isTouched()) {
                if(turn==1 ){
                    p1.getTank().setBul(new Bullet(p1.getTank().gettype(),p1.getType()));
                    p1.setbul();
                }
                else if(turn==-1){
                    p2.getTank().setBul(new Bullet(p2.getTank().gettype(),p2.getType()));
                    p2.setbul();
                }
                fd = 1;
            }
        }
    }

    public static void changeturn(){
        turn = -1 * turn;
        if(turn==1) p1.setFuel(100);
        else if(turn==-1) p2.setFuel(100);
        try{
            Thread.sleep(200);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
            game.batch.end();
        }
        if(p1.getType()==0) turn = 0;
        ct = 0;
    }

    public static void shoot(){
        fd=1;
        if(turn==1 || turn==0){
            p1.fire(p2.getTank());
        }
        else if(turn==-1){
            p2.fire(p1.getTank());
        }
    }

    public static void quitgame(){
        game.getScreen().dispose();
        System.exit(0);
    }

    public void pushdrop(){

    }

    public static void pausegame(){
        if(Gdx.input.getX()>1763*xm && Gdx.input.getX()<1847*xm
                && Gdx.input.getY()<720-906*ym && Gdx.input.getY()>720-990*ym){
            if(Gdx.input.isTouched()){
                paused = 1;
                pmenu = PauseMenu.getmenu();
                Main.drawpause();
            }
        }
    }

    public static void drawpause(){
        Texture pm = new Texture("Pause Menu Back.png");
        Texture pbut = new Texture("Choose Game Button.png");
        game.batch.draw(pm,701*Main.xm,158*Main.ym,518*Main.xm,764*Main.ym);
        game.batch.draw(pbut,pmenu.getRes().getPos_x(),pmenu.getRes().getPos_y(),pmenu.getRes().getWIDTH(),pmenu.getRes().getHEIGHT());
        game.batch.draw(pbut,pmenu.getRes().getPos_x(),pmenu.getSave().getPos_y(),pmenu.getRes().getWIDTH(),pmenu.getRes().getHEIGHT());
        game.batch.draw(pbut,pmenu.getRes().getPos_x(),pmenu.getNewg().getPos_y(),pmenu.getRes().getWIDTH(),pmenu.getRes().getHEIGHT());
        game.batch.draw(pbut,pmenu.getRes().getPos_x(),pmenu.getQuit().getPos_y(),pmenu.getRes().getWIDTH(),pmenu.getRes().getHEIGHT());

        Texture  f1 = new Texture("Frame 13.png");
        Texture  f2 = new Texture("Frame 14.png");
        Texture  f3 = new Texture("Frame 15.png");
        Texture  f4 = new Texture("Frame 16.png");

        game.batch.draw(f1,870*xm,646*ym,213*xm,28*ym);
        game.batch.draw(f2,870*xm,526*ym,213*xm,28*ym);
        game.batch.draw(f3,870*xm,406*ym,213*xm,28*ym);
        game.batch.draw(f4,870*xm,286*ym,213*xm,28*ym);

        if(pmenu.getRes().isClicked()) pmenu.resume();
        else if(pmenu.getNewg().isClicked()) pmenu.newgame();
        else if(pmenu.getSave().isClicked()) pmenu.savestate();
        else if(pmenu.getQuit().isClicked()) pmenu.quit();
    }

    public static void savegame(){
        smenu = SaveMenu.getmenu();
        saving = 1;
        drawsave();
    }

    public static void drawsave(){
        Texture sm = new Texture("Save Menu Back.png");
        Texture pbut = new Texture("Choose Game Button.png");
        game.batch.draw(sm,701*Main.xm,203.5f*Main.ym,518*Main.xm,673f*Main.ym);
        game.batch.draw(pbut,pmenu.getRes().getPos_x(),pmenu.getRes().getPos_y(),pmenu.getRes().getWIDTH(),pmenu.getRes().getHEIGHT());
        game.batch.draw(pbut,pmenu.getRes().getPos_x(),pmenu.getSave().getPos_y(),pmenu.getRes().getWIDTH(),pmenu.getRes().getHEIGHT());
        game.batch.draw(pbut,pmenu.getRes().getPos_x(),pmenu.getNewg().getPos_y(),pmenu.getRes().getWIDTH(),pmenu.getRes().getHEIGHT());
        game.batch.draw(pbut,pmenu.getRes().getPos_x(),pmenu.getQuit().getPos_y(),pmenu.getRes().getWIDTH(),pmenu.getRes().getHEIGHT());

        if(smenu.getG1().isClicked()) smenu.save(1);
        else if(smenu.getG2().isClicked()) smenu.save(2);
        else if(smenu.getG3().isClicked()) smenu.save(3);
        else if(smenu.getGx().isClicked()) smenu.cancel();
    }

    public static void quitToMenu(){
        game.getScreen().dispose();
        game.resize(1280,720);
        game.setScreen(new MainScreen(game));
    }
}
