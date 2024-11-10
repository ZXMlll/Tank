package com.zxm.Draw.com.zxm.Draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {
    private MyPanpel mq = null;
    public static void main(String[] args) {
        new DrawCircle();
    }
    public DrawCircle() {
        mq = new MyPanpel();
        this.add(mq);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    class MyPanpel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            g.drawOval(10, 60, 300, 100);
        }
    }
}
