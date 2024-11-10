package method;

public class ThreadMethodExsrcise  {
    public static void main(String[] args) throws InterruptedException {
        Thread t =new Thread(new T3());
        for (int i = 1; i <= 10; i++) {
          System.out.println("hi  " +i);
          if (i == 5)
              t.start();
              t.join();

      }
    }

}


class T3 implements Runnable {
    private int count = 0;

    public void run() {
        while (true) {
            System.out.println("hello word   " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                if (count == 10)
                    break;

        }
    }
}