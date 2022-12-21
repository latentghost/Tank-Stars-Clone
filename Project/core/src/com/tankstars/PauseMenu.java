package com.tankstars;

public class PauseMenu extends Menu {

    private LoadScreenButton res;
    private LoadScreenButton save;
    private LoadScreenButton newg;
    private LoadScreenButton quit;


    public PauseMenu(){
        this.res = new LoadScreenButton();
        this.save = new LoadScreenButton();
        this.newg = new LoadScreenButton();
        this.quit = new LoadScreenButton();
        this.getRes().setPos_x(834*Main.xm);
        this.getNewg().setPos_x(834*Main.xm);
        this.getQuit().setPos_x(834*Main.xm);
        this.getSave().setPos_x(834*Main.xm);
        this.getRes().setPos_y(615.83f*Main.ym);
        this.getSave().setPos_y(495.83f*Main.ym);
        this.getNewg().setPos_y(375.83f*Main.ym);
        this.getQuit().setPos_y(255.83f*Main.ym);
    }

    public LoadScreenButton getRes() {
        return res;
    }

    public LoadScreenButton getSave() {
        return save;
    }

    public LoadScreenButton getNewg() {
        return newg;
    }

    public LoadScreenButton getQuit() {
        return quit;
    }

    public void resume(){
        Main.setPaused(0);
    }

    public void savestate(){

    }

    public void newgame(){

    }

    public void quit(){
        Main.quitToMenu();
    }
}
