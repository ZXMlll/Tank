package tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    Hero hero = null;
    Vector<EnemyTank> EnmyTanks = new Vector();
    Vector<Bomd> bomds = new Vector();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    int enemyTankSize = 5;
    Vector<Node> n = new Vector();


    public MyPanel(String key) {
        hero = new Hero(600, 100);
        hero.setSpeed(8);
        Recorder.setEnemyTanks(EnmyTanks);
        switch (key) {
            case "1":
                for (int i = 0; i < enemyTankSize; i++) {
                    EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
                    enemyTank.setEnemyTanks(EnmyTanks);
                    enemyTank.setDirect(2);
                    EnmyTanks.add(enemyTank);
                    new Thread(enemyTank).start();
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60,
                            enemyTank.getDirect());
                    enemyTank.shots.add(shot);
                    new Thread(shot).start();
                }
                break;
            case "2":
                n = Recorder.getNodes();

                    for (int i = 0; i < n.size(); i++) {
                        Node node = n.get(i);
                        EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                        enemyTank.setEnemyTanks(EnmyTanks);
                        enemyTank.setDirect(node.getDirect());
                        EnmyTanks.add(enemyTank);
                        new Thread(enemyTank).start();
                        Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60,
                                enemyTank.getDirect());
                        enemyTank.shots.add(shot);
                        new Thread(shot).start();
                    }

                break;
            default:
                System.out.println("输入信息有误");
        }
        image1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/boom1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/boom2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/boom3.png"));
    }

    public void showInfo(Graphics g) {
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("您累计击毁敌方坦克", 1020, 30);
        drawTank(1020, 60, g, 0, 0);
        g.setColor(Color.black);
        g.drawString(Recorder.getAllEnemyTankNum() + "", 1080, 100);

    }


    public void paint(Graphics g) {
        super.paint(g);
        showInfo(g);
        g.fillRect(0, 0, 1000, 750);
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        }
        for (int i = 0; i < bomds.size(); i++) {
            Bomd bomd = bomds.get(i);
            if (bomd.live > 6)
                g.drawImage(image1, bomd.x, bomd.y, 60, 60, this);
            else if (bomd.live > 3)
                g.drawImage(image2, bomd.x, bomd.y, 60, 60, this);
            else
                g.drawImage(image3, bomd.x, bomd.y, 60, 60, this);
            bomd.lifeDown();
            bomds.remove(bomd);
        }

        for (int i = 0; i < EnmyTanks.size(); i++) {
            EnemyTank enemyTank = EnmyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.islive)
                        g.fillOval(shot.x, shot.y, 3, 3);
                    else
                        enemyTank.shots.remove(j);
                }
            } else
                EnmyTanks.remove(i--);


        }
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.islive) {
                System.out.println("子弹被绘制...");
                g.fillOval(shot.x, shot.y, 10, 10);
            } else
                hero.shots.remove(shot);
        }
    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;

        }
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y - 40);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 100, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 100);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x - 40, y + 20);
                break;
            default:
                System.out.println("暂时没有处理");

        }
    }


    public void HitHero() {
        for (int i = 0; i < EnmyTanks.size(); i++) {
            EnemyTank enemyTank = EnmyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (shot.islive && hero.isLive) {
                    HitTank(shot, hero);
                }
            }
        }
    }

    public void HitTank(Shot s, Tank tank) {
        switch (tank.getDirect()) {
            case 0:
            case 2:
                if (s.x > tank.getX() && s.x < tank.getX() + 40 &&
                        s.y > tank.getY() && s.y < tank.getY() + 60) {
                    s.islive = false;
                    tank.isLive = false;
                    if (tank instanceof EnemyTank) {
                        Recorder recorder = new Recorder();
                        recorder.AllEnemyTankNum();
                    }
                    Bomd bomd = new Bomd(tank.getX(), tank.getY());
                    bomds.add(bomd);
                }
                break;
            case 3:
            case 1:
                if (s.x > tank.getX() && s.x < tank.getX() + 60 &&
                        s.y > tank.getY() && s.y < tank.getY() + 40) {
                    s.islive = false;
                    tank.isLive = false;
                    if (tank instanceof EnemyTank) {
                        Recorder recorder = new Recorder();
                        recorder.AllEnemyTankNum();
                    }
                    Bomd bomd = new Bomd(tank.getX(), tank.getY());
                    bomds.add(bomd);
                }
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            if (hero.getY() > 0) {
                hero.moveup();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            System.out.println("用户按下了J，开始射击");
            hero.shotEnemyTank();
        }
        repaint();


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < hero.shots.size(); i++) {

                Shot s = hero.shots.get(i);
                if (s.islive) {
                    for (int j = 0; j < EnmyTanks.size(); j++) {
                        EnemyTank enemyTank = EnmyTanks.get(j);

                        HitTank(s, enemyTank);
                    }
                }
            }
            HitHero();
            if (!hero.isLive) {
                hero.setX(1200);
                hero.setY(1200);
            }
            this.repaint();
        }
    }
}
