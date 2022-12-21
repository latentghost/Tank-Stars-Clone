package com.tankstars;

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
            pl = new FileOutputStream("player.txt");
            tank = new FileOutputStream("tank.txt");
            bul = new FileOutputStream("bullet.txt");
            out = new ObjectOutputStream(pl);
            out.writeObject(Main.getp1());
            out = new ObjectOutputStream(tank);
            out.writeObject(Main.getp1().getTank());
            out = new ObjectOutputStream(bul);
            out.writeObject(Main.getp1().getTank().getBul());
        }
        catch (Exception e){;}
    }

    public void cancel(){
        Main.setSaving(0);
    }

}
