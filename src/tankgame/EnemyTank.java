package tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Shot s = null;

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public boolean isTouchEnemyTank() {
        for (int i = 0; i < enemyTanks.size() ; i++) {
            for (int j = 0; j < enemyTanks.size(); j++) {
                EnemyTank enemytank1 = enemyTanks.get(i);
                EnemyTank enemyTank2 = enemyTanks.get(j);
                switch (enemytank1.getDirect()) {
                    case 0:

                        if (enemytank1 != enemyTank2) {
                            if (enemyTank2.getDirect() == 0 || enemyTank2.getDirect() == 2) {
                                if (enemytank1.getX() >= enemyTank2.getX()
                                        && enemytank1.getX() <= enemyTank2.getX() + 40
                                        && enemytank1.getY() >= enemyTank2.getY() &&
                                        enemytank1.getY() <= enemyTank2.getY() + 60)
                                    return true;
                                if (enemytank1.getX() + 40 >= enemyTank2.getX()
                                        && enemytank1.getX() + 40 <= enemyTank2.getX() + 40
                                        && enemytank1.getY() >= enemyTank2.getY() &&
                                        enemytank1.getY() <= enemyTank2.getY() + 60)
                                    return true;
                            }
                            if (enemyTank2.getDirect() == 1 || enemyTank2.getDirect() == 3) {
                                if (enemytank1.getX() >= enemyTank2.getX()
                                        && enemytank1.getX() <= enemyTank2.getX() + 60
                                        && enemytank1.getY() >= enemyTank2.getY() &&
                                        enemytank1.getY() <= enemyTank2.getY() + 40)
                                    return true;
                                if (enemytank1.getX() + 40 >= enemyTank2.getX()
                                        && enemytank1.getX() + 40 <= enemyTank2.getX() + 60
                                        && enemytank1.getY() >= enemyTank2.getY() &&
                                        enemytank1.getY() <= enemyTank2.getY() + 40)
                                    return true;
                            }
                        }
                        break;
                    case 1:

                        if (enemytank1 != enemyTank2) {
                            if (enemyTank2.getDirect() == 0 || enemyTank2.getDirect() == 2) {
                                if (enemytank1.getX() + 60 >= enemyTank2.getX()
                                        && enemytank1.getX() + 60 <= enemyTank2.getX() + 40
                                        && enemytank1.getY() >= enemyTank2.getY() &&
                                        enemytank1.getY() <= enemyTank2.getY() + 60)
                                    return true;
                                if (enemytank1.getX() + 60 >= enemyTank2.getX()
                                        && enemytank1.getX() + 60 <= enemyTank2.getX() + 40
                                        && enemytank1.getY() + 40 >= enemyTank2.getY() &&
                                        enemytank1.getY() + 40 <= enemyTank2.getY() + 60)
                                    return true;
                            }
                            if (enemyTank2.getDirect() == 1 || enemyTank2.getDirect() == 3) {
                                if (enemytank1.getX() + 60 >= enemyTank2.getX()
                                        && enemytank1.getX() + 60 <= enemyTank2.getX() + 60
                                        && enemytank1.getY() >= enemyTank2.getY() &&
                                        enemytank1.getY() <= enemyTank2.getY() + 40)
                                    return true;
                                if (enemytank1.getX() + 60 >= enemyTank2.getX()
                                        && enemytank1.getX() + 60 <= enemyTank2.getX() + 60
                                        && enemytank1.getY() + 40 >= enemyTank2.getY() &&
                                        enemytank1.getY() + 40 <= enemyTank2.getY() + 40)
                                    return true;
                            }
                        }
                        break;


                    case 2:

                        if (enemytank1 != enemyTank2) {
                            if (enemyTank2.getDirect() == 0 || enemyTank2.getDirect() == 2) {
                                if (enemytank1.getX() >= enemyTank2.getX()
                                        && enemytank1.getX() <= enemyTank2.getX() + 40
                                        && enemytank1.getY() + 60 >= enemyTank2.getY() &&
                                        enemytank1.getY() + 60 <= enemyTank2.getY() + 60)
                                    return true;
                                if (enemytank1.getX() + 40 >= enemyTank2.getX()
                                        && enemytank1.getX() + 40 <= enemyTank2.getX() + 40
                                        && enemytank1.getY() + 60 >= enemyTank2.getY() &&
                                        enemytank1.getY() + 60 <= enemyTank2.getY() + 60)
                                    return true;
                            }
                            if (enemyTank2.getDirect() == 1 || enemyTank2.getDirect() == 3) {
                                if (enemytank1.getX() >= enemyTank2.getX()
                                        && enemytank1.getX() <= enemyTank2.getX() + 60
                                        && enemytank1.getY() + 60 >= enemyTank2.getY() &&
                                        enemytank1.getY() + 60 <= enemyTank2.getY() + 40)
                                    return true;
                                if (enemytank1.getX() + 40 >= enemyTank2.getX()
                                        && enemytank1.getX() + 40 <= enemyTank2.getX() + 60
                                        && enemytank1.getY() + 60 >= enemyTank2.getY() &&
                                        enemytank1.getY() + 60 <= enemyTank2.getY() + 40)
                                    return true;
                            }
                        }

                        break;
                    case 3:

                        if (enemytank1 != enemyTank2) {
                            if (enemyTank2.getDirect() == 0 || enemyTank2.getDirect() == 2) {
                                if (enemytank1.getX() >= enemyTank2.getX()
                                        && enemytank1.getX() <= enemyTank2.getX() + 40
                                        && enemytank1.getY() >= enemyTank2.getY() &&
                                        enemytank1.getY() <= enemyTank2.getY() + 60)
                                    return true;
                                if (enemytank1.getX() >= enemyTank2.getX()
                                        && enemytank1.getX() <= enemyTank2.getX() + 40
                                        && enemytank1.getY() + 40 >= enemyTank2.getY() &&
                                        enemytank1.getY() + 40 <= enemyTank2.getY() + 60)
                                    return true;
                            }
                            if (enemyTank2.getDirect() == 1 || enemyTank2.getDirect() == 3) {
                                if (enemytank1.getX() >= enemyTank2.getX()
                                        && enemytank1.getX() <= enemyTank2.getX() + 60
                                        && enemytank1.getY() >= enemyTank2.getY() &&
                                        enemytank1.getY() <= enemyTank2.getY() + 40)
                                    return true;
                                if (enemytank1.getX() >= enemyTank2.getX()
                                        && enemytank1.getX() <= enemyTank2.getX() + 60
                                        && enemytank1.getY() + 40 >= enemyTank2.getY() &&
                                        enemytank1.getY() + 40 <= enemyTank2.getY() + 40)
                                    return true;
                            }
                        }
                        break;
                }
            }
        }
        return  false;
    }



    @Override
    public void  run() {
        while (true) {
            if (isLive && shots.size() < 5) {
                switch (getDirect()) {
                    case 0:
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2:
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }


            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        if (getY() > 0 && !isTouchEnemyTank()) {
                            moveup();

                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if (getX() + 60 < 1000 && !isTouchEnemyTank()) {

                            moveRight();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;

                case 2:
                    for (int i = 0; i < 30; i++) {
                        if (getY() + 60 < 750 && !isTouchEnemyTank()) {
                            moveDown();

                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if (getX() > 0 && !isTouchEnemyTank()) {

                            moveLeft();
                            try {
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    break;
            }
            setDirect(1);
            if (!isLive)
                break;

        }
    }
}