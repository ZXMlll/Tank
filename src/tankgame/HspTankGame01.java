package tankgame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HspTankGame01 extends JFrame  {
      MyPanel mp = null;
    public static void main(String[] args) {
        HspTankGame01 hspTankGame01 = new HspTankGame01();

    }
    public HspTankGame01() {
        mp = new MyPanel();
        add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


}
