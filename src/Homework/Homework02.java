package Homework;

public class Homework02 {
    public static void main(String[] args) {
        T t = new T();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();

    }
}

class T implements Runnable {
    private int maney = 10000;

    public void run() {
        while (true) {

            synchronized (this) {
                if (maney <= 1000) {
                    System.out.println("余额不足");
                    break;
                }
                maney -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出了1000 当前余额=" + maney);
            }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);


            }
        }
    }
}
