package tankgame;

public class Shot implements Runnable {
    public int x;
    public int y;
    private int speed = 40;
    private int direct = 0;
    public boolean islive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            System.out.println("子弹 x=" + x + " y=" + y);
            if (!(x >= 0 && x<= 1000 && y >= 0 && y <= 750)) {
                System.out.println("子弹线程退出");
                        this.islive = false;
                        break;
            }
        }

    }

}
