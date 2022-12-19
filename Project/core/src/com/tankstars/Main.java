package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.screens.*;

public class Main extends MainScreen {
    private Player p1;
    private Player p2;

    private Drops drop;
    
    protected static float xm = 1280f/1920;
    protected static float ym = 720f/1080;

    private final float gr_h = 322.5f*ym;

    private MainScreenButton vscom;
    private MainScreenButton vsfr;
    private MainScreenButton load;
    private MainScreenButton quit;

    private PauseMenu pmenu;
    private SaveMenu smenu;
    private QuitMenu qmenu;


    public Main(Tankstars game){
        super(game);
        this.p1 = new Player(1);
        this.p2 = new Player(2);
        this.vscom = new MainScreenButton();
        this.vsfr = new MainScreenButton();
        this.load = new MainScreenButton();
        this.quit = new MainScreenButton();
        this.pmenu = new PauseMenu();
        this.smenu = new SaveMenu();
        this.qmenu = new QuitMenu();
        this.play();
    }

    public Player getp1() {
        return p1;
    }

    public Player getp2() {
        return p2;
    }

    public float getgr() {
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
        Texture p1 = new Texture("p1.png");
        MainScreenButton sel = new MainScreenButton();
        sel.text("Select");

        game.batch.draw(img,0,0,1280,720);
        game.batch.draw(back,bx,by,bw,bw);
        game.batch.draw(ts,1438f*xm,497f*ym,396f*xm,116f*ym);
        game.batch.draw(p1,1565f*xm,711f*ym,143f*xm,72f*ym);
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
//                this.p1.setTank(new Tank(ChooseTankP1.ind));
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
        Texture curr = tanks[ChooseTankP1.ind];
        String cname = name[ChooseTankP1.ind];
        Texture ts = new Texture("Choose Tank.png");
        Texture p2 = new Texture("p2.png");
        MainScreenButton sel = new MainScreenButton();
        sel.text("Select");

        game.batch.draw(img,0,0,1280,720);
        game.batch.draw(back,bx,by,bw,bw);
        game.batch.draw(ts,1438f*xm,497f*ym,396f*xm,116f*ym);
        game.batch.draw(p2,1565f*xm,711f*ym,143f*xm,72f*ym);
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
//                this.p2.setTank(new Tank(ChooseTankP2.ind));
                game.getScreen().dispose();
                game.resize(1280,720);
                game.setScreen(new Arena(game));
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

    public void quitgame(){
        this.dispose();
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
