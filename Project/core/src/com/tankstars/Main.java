package com.tankstars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.screens.MainScreen;
import com.tankstars.screens.MainScreen.*;

public class Main extends MainScreen {
    private Player p1;
    private Player p2;

    private Drops drop;

    private final float gr_h = 322.5f;

    private MainScreenButton vscom;
    private MainScreenButton vsfr;
    private MainScreenButton load;
    private MainScreenButton quit;

    private PauseMenu pmenu;
    private SaveMenu smenu;
    private QuitMenu qmenu;


    public Main(Tankstars game){
        super(game);
        this.p1 = new Player();
        this.p2 = new Player();
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

        vscom.text("VS COMPUTER");
        vsfr.text("VS FRIEND");
        load.text("LOAD GAME");
        quit.text("QUIT");
        game.batch.draw(vscom.app,1468,227,1468+vscom.getWIDTH(),227+vscom.getHEIGHT());
        game.batch.draw(vsfr.app,1468,400,1468+vsfr.getWIDTH(),400+vsfr.getHEIGHT());
        game.batch.draw(load.app,1468,573,1468+load.getWIDTH(),573+load.getHEIGHT());
        game.batch.draw(quit.app,1468,746,1468+quit.getWIDTH(),746+quit.getHEIGHT());

        int x = 1468;
        int y = 227;
        int z = 573;

        int a = 746;
        int b = 400;

        if (((Gdx.input.getX() > x && Gdx.input.getX() < (x + vscom.getWIDTH())) && (Gdx.input.getY() > y && Gdx.input.getY() < (y + vscom.getHEIGHT()) ) )) {
            vscom.hover();
            game.batch.draw(vscom.app,1468,227,1468+vscom.getWIDTH(),227+vscom.getHEIGHT());
            if (Gdx.input.isTouched()) {
                this.dispose();
                resize(1920,1080 );
                game.setScreen(new com.tankstars.screens.p2.ChooseTankAbramsP2(game));
            }
        }

        else if (( (Gdx.input.getX() > x && Gdx.input.getX() < (x + vscom.getWIDTH()) ) && (Gdx.input.getY() > b && Gdx.input.getY() < (b + vscom.getHEIGHT()) ) )) {
            vsfr.hover();
            game.batch.draw(vsfr.app,1468,400,1468+vsfr.getWIDTH(),400+vsfr.getHEIGHT());
            if (Gdx.input.isTouched()) {
                this.dispose();
                resize(1920,1080 );
                game.setScreen(new com.tankstars.screens.p1.ChooseTankAbramsP1(game));
            }
        }

        else if ( (Gdx.input.getX() > x && Gdx.input.getX() < (x + vscom.getWIDTH()) ) && (Gdx.input.getY() > z && Gdx.input.getY() < (z + vscom.getHEIGHT()) )) {
            load.hover();
            game.batch.draw(load.app,1468,573,1468+load.getWIDTH(),573+load.getHEIGHT());
            if (Gdx.input.isTouched()) {
                this.dispose();
                resize(1920,1080 );
//                game.setScreen(new LoadGame(game));
            }
        }

        else if( (Gdx.input.getX() > x && Gdx.input.getX() < (x + vscom.getWIDTH()) ) && (Gdx.input.getY() > a && Gdx.input.getY() < (a + vscom.getHEIGHT()) )){
            quit.hover();
            game.batch.draw(quit.app,1468,746,1468+quit.getWIDTH(),746+quit.getHEIGHT());
            if (Gdx.input.isTouched()) {
                this.dispose();
                System.exit(0);
            }
        }

        else{
            vscom.norm();
            vsfr.norm();
            load.norm();
            quit.norm();
            game.batch.draw(vscom.app,1468,227,1468+vscom.getWIDTH(),227+vscom.getHEIGHT());
            game.batch.draw(vsfr.app,1468,400,1468+vsfr.getWIDTH(),400+vsfr.getHEIGHT());
            game.batch.draw(load.app,1468,573,1468+load.getWIDTH(),573+load.getHEIGHT());
            game.batch.draw(quit.app,1468,746,1468+quit.getWIDTH(),746+quit.getHEIGHT());
        }

        game.batch.end();
    }

    public void quit(){

    }

    public void pushdrop(){

    }

    public void pause(){

    }

    public void save(){

    }

    public void quitToMenu(){

    }
}
