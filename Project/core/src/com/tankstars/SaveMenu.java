package com.tankstars;

import com.tankstars.screens.MainScreen;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveMenu extends Menu {

    private static SaveMenu menu;
    private static LoadScreenButton g1;
    private static LoadScreenButton g2;
    private static LoadScreenButton g3;
    private static LoadScreenButton gx;


    private SaveMenu(){
        g1 = new LoadScreenButton(834*Main.xm,615.83f*Main.ym);
        g2 = new LoadScreenButton(834*Main.xm,495.83f*Main.ym);
        g3 = new LoadScreenButton(834*Main.xm,375.83f*Main.ym);
        gx = new LoadScreenButton(834*Main.xm,255.83f*Main.ym);
    }

    public LoadScreenButton getG1() {
        return g1;
    }

    public LoadScreenButton getG2() {
        return g2;
    }

    public LoadScreenButton getG3() {
        return g3;
    }

    public LoadScreenButton getGx() {
        return gx;
    }

    public static SaveMenu getmenu(){
        if(menu==null) return new SaveMenu();
        else return menu;
    }

    public void save(int i){
        ObjectOutputStream out = null;
        FileOutputStream pl = null;
        FileOutputStream tank = null;
        FileOutputStream bul = null;

        try{
            pl = new FileOutputStream("player1.txt");
            tank = new FileOutputStream("tank1.txt");
            bul = new FileOutputStream("bullet1.txt");
            out = new ObjectOutputStream(pl);
            out.writeObject(Main.getp1());
            out = new ObjectOutputStream(tank);
            out.writeObject(Main.getp1().getTank());
            out = new ObjectOutputStream(bul);
            out.writeObject(Main.getp1().getTank().getBul());
            pl = new FileOutputStream("player2.txt");
            tank = new FileOutputStream("tank2.txt");
            bul = new FileOutputStream("bullet2.txt");
            out = new ObjectOutputStream(pl);
            out.writeObject(Main.getp2());
            out = new ObjectOutputStream(tank);
            out.writeObject(Main.getp2().getTank());
            out = new ObjectOutputStream(bul);
            out.writeObject(Main.getp2().getTank().getBul());
        }
        catch (Exception e){;}
        finally {
            try{
                out.close();
            }
            catch (Exception e){;}
        }

        Main.setPaused(0);
        Main.setSaving(0);
        Main.setFd(0);
        Main.setCt(0);
        Main.setRedhel(0);
        Main.game.getScreen().dispose();
        Main.game.resize(1280,720);
        Main.game.setScreen(new MainScreen(Main.game));
    }

    public void cancel(){
        Main.setSaving(0);
    }

}
