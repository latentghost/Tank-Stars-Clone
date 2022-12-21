package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.screens.*;

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

    private MainScreenButton vscom;
    private MainScreenButton vsfr;
    private MainScreenButton load;
    private MainScreenButton quit;

    private PauseMenu pmenu;
    private SaveMenu smenu;
    private QuitMenu qmenu;


    public Main(Tankstars game){
        super(game);
        this.vscom = new MainScreenButton();
        this.vsfr = new MainScreenButton();
        this.load = new MainScreenButton();
        this.quit = new MainScreenButton();
        this.pmenu = new PauseMenu();
        this.smenu = new SaveMenu();
        this.qmenu = new QuitMenu();
        this.play();
    }

    public static void setChanged(int changed) {
        Main.changed = changed;
    }

    public static void setCt(int ct) {
        Main.ct = ct;
    }

    public static void setFd(int fd) {
        Main.fd = fd;
    }

    public Player getp1() {
        return Main.p1;
    }

    public Player getp2() {
        return Main.p2;
    }

    public static float getgr() {
        return gr_h;
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
        game.batch.draw(vsfr.app,x,z,vsfr.getWIDTH(),vsfr.getHEIGHT());
        game.batch.draw(load.app,x,a,load.getWIDTH(),load.getHEIGHT());
        game.batch.draw(quit.app,x,b,quit.getWIDTH(),quit.getHEIGHT());

        if (((Gdx.input.getX() > x && Gdx.input.getX() < (x + vscom.getWIDTH())) && (Gdx.input.getY() < 720-y && Gdx.input.getY() > (720-y - vscom.getHEIGHT()) ) )) {
            vscom.hover();
            game.batch.draw(vscom.app,x,y,vscom.getWIDTH(),vscom.getHEIGHT());
            if (Gdx.input.isTouched()) {
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new ChooseTankP2(game));
            }
        }

        else if (( (Gdx.input.getX() > x && Gdx.input.getX() < (x + vscom.getWIDTH()) ) && (Gdx.input.getY() < 720-b && Gdx.input.getY() > (720-b - vscom.getHEIGHT()) ) )) {
            vsfr.hover();
            game.batch.draw(vsfr.app,x,b,vsfr.getWIDTH(),vsfr.getHEIGHT());
            if (Gdx.input.isTouched()) {
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new ChooseTankP1(game));
            }
        }

        else if ( (Gdx.input.getX() > x && Gdx.input.getX() < (x + vscom.getWIDTH()) ) && (Gdx.input.getY() < 720-z && Gdx.input.getY() > (720-z - vscom.getHEIGHT()) )) {
            load.hover();
            game.batch.draw(load.app,x,z,load.getWIDTH(),load.getHEIGHT());
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.resize(1280,720);
//                game.setScreen(new LoadGame(game));
            }
        }

        else if( (Gdx.input.getX() > x && Gdx.input.getX() < (x + vscom.getWIDTH()) ) && (Gdx.input.getY() < 720-a && Gdx.input.getY() > (720-a - vscom.getHEIGHT()) )){
            quit.hover();
            game.batch.draw(quit.app,x,a,quit.getWIDTH(),quit.getHEIGHT());
            if (Gdx.input.isTouched()) {
                quitgame();
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

        game.batch.end();
    }

    public static void choosep1(){

        game.batch.begin();
        img = new Texture("Choose Tank Render.png");
        float bx = 1386f*xm;
        float by = 979f*ym;
        float bw = 69f/1920*1080;

        Texture[] tanks = new Texture[]{new Texture("Abrams Choose.png"), new Texture("Mark 1 Choose.png"), new Texture("Coalition Choose.png")};
        String[] name = new String[]{"Abrams","Mark - I","Coalition"};
        Texture back = new Texture("Back Button.png");
        Texture curr = tanks[ChooseTankP1.ind];
        String cname = name[ChooseTankP1.ind];
        Texture ts = new Texture("Choose Tank.png");
        Texture p = new Texture("p1.png");
        MainScreenButton sel = new MainScreenButton();
        sel.text("Select");

        game.batch.draw(img,0,0,1280,720);
        game.batch.draw(back,bx,by,bw,bw);
        game.batch.draw(ts,1438f*xm,497f*ym,396f*xm,116f*ym);
        game.batch.draw(p,1565f*xm,711f*ym,143f*xm,72f*ym);
        game.batch.draw(sel.app,1468f*xm,212*ym,sel.getWIDTH(),sel.getHEIGHT());
        game.batch.draw(curr,339f*xm,224f*ym,674*xm,432*ym);

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
        game.batch.end();

    }

    public static void choosep2(){

        game.batch.begin();
        img = new Texture("Choose Tank Render.png");
        float bx = 1386f*xm;
        float by = 979f*ym;
        float bw = 69f/1920*1080;
        Texture[] tanks = new Texture[]{new Texture("Abrams Choose.png"), new Texture("Mark 1 Choose.png"), new Texture("Coalition Choose.png")};
        String[] name = new String[]{"Abrams","Mark - I","Coalition"};
        Texture back = new Texture("Back Button.png");
        Texture curr = tanks[ChooseTankP2.ind];
        String cname = name[ChooseTankP2.ind];
        Texture ts = new Texture("Choose Tank.png");
        Texture p = new Texture("p2.png");
        MainScreenButton sel = new MainScreenButton();
        sel.text("Select");

        game.batch.draw(img,0,0,1280,720);
        game.batch.draw(back,bx,by,bw,bw);
        game.batch.draw(ts,1438f*xm,497f*ym,396f*xm,116f*ym);
        game.batch.draw(p,1565f*xm,711f*ym,143f*xm,72f*ym);
        game.batch.draw(sel.app,1468f*xm,212*ym,sel.getWIDTH(),sel.getHEIGHT());
        game.batch.draw(curr,339f*xm,224f*ym,674*xm,432*ym);

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
        game.batch.end();

    }

    public static final void arena(){
        game.batch.begin();
        if(changed==1){
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                ;
            }
            changed = 0;
        }
        Main.drawarena((int)turn);
        if(fd==0) Main.taketurn((int)turn);
        Main.fired();
        if(fd==1){
            Main.shoot();
            if(ct==1) Main.changeturn();
        }
        game.batch.end();
    }

    public static void taketurn(int turn){
        if(turn==1) p1.currturn();
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
        if(turn==1) mx *= p1.getMx();
        else if(turn==-1) mx *= p2.getMx();

        int tf = 0;
        if(turn==1) tf = p1.getFuel();
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

    public static boolean fired(){
        if(Gdx.input.getX()>1310*xm && Gdx.input.getX()<(1310+227)*xm && Gdx.input.getY()<720-113*ym && Gdx.input.getY()>720-200*ym){
            if(Gdx.input.isTouched()) {
                if(turn==1){
                    p1.getTank().setBul(new Bullet(p1.getTank().gettype(),p1.getType()));
                    p1.setbul();
                }
                else if(turn==-1){
                    p2.getTank().setBul(new Bullet(p2.getTank().gettype(),p2.getType()));
                    p2.setbul();
                }
                fd = 1;
                return true;
            }
            else return false;
        }
        else return false;
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
        ct = 0;
    }

    public static void shoot(){
        if(turn==1){
            p1.getTank().setAngle(30);
            p1.fire(p2.getTank());
        }
        else if(turn==-1){
            p2.getTank().setAngle(30);
            p2.fire(p1.getTank());
        }
    }

    public void quitgame(){
        game.getScreen().dispose();
        System.exit(0);
    }

    public void pushdrop(){

    }

    public void pausegame(){

    }

    public void save(){

    }

    public void quitToMenu(){

    }
}
