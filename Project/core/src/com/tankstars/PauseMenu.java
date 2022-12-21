package com.tankstars;

import com.tankstars.screens.ChooseTankP1;

public class PauseMenu extends Menu {

    private static PauseMenu menu = null;
    private static LoadScreenButton res;
    private static LoadScreenButton save;
    private static LoadScreenButton newg;
    private static LoadScreenButton quit;


    private PauseMenu(){
        res = new LoadScreenButton(834*Main.xm,615.83f*Main.ym);
        save = new LoadScreenButton(834*Main.xm,495.83f*Main.ym);
        newg = new LoadScreenButton(834*Main.xm,375.83f*Main.ym);
        quit = new LoadScreenButton(834*Main.xm,255.83f*Main.ym);
    }

    public static PauseMenu getmenu(){
        if(menu==null) return new PauseMenu();
        else return menu;
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
        Main.savegame();
    }

    public void newgame(){
        Main.setPaused(0);
        Main.setSaving(0);
        Main.setFd(0);
        Main.setCt(0);
        Main.setRedhel(0);
        Main.game.getScreen().dispose();
        Main.game.resize(1280,720);
        Main.game.setScreen(new ChooseTankP1(Main.game));
    }

    public void quit(){
        Main.quitToMenu();
    }
}
