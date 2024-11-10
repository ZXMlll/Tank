package Threaduse;

public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread t3 = new Thread(t1);
        Thread t4 = new Thread(t2);
        t3.start();
        t4.start();

    }
}

class T1 implements Runnable {
    int count = 0;

    public void run() {
        while (true) {
            System.out.println("hello work " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 5) {
                break;
            }
        }

    }
}

class T2 implements Runnable {
    int count = 0;

    public void run() {
        while (true) {
            System.out.println("hi" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }

        }
    }

}

