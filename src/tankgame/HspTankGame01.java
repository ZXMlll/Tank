package tankgame;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class HspTankGame01 extends JFrame {
    MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HspTankGame01 hspTankGame01 = new HspTankGame01();

    }

    public HspTankGame01() {
        System.out.println("请输入选择 1：新游戏 2：继续上局");
        String key = scanner.next();
        mp = new MyPanel(key);
        add(mp);
        new Thread(mp).start();
        this.setSize(1300, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.out.println("监听到关闭窗口了");
                System.exit(0);
            }
        });

    }

}
