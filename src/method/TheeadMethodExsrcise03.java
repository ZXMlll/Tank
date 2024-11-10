package method;

public class TheeadMethodExsrcise03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 0; i <= 10; i++) {
            System.out.println("水嫩农村");
                Thread.sleep(1000);
        }


    }
}
class MyDaemonThread extends Thread {
    public void run() {
       for (; ; ) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
           System.out.println("jhkcxidbci");
    }
    }
}
