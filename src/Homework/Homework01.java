package Homework;

import java.util.Scanner;

public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }
}
class A extends Thread{
    private boolean loop = true;
    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void run(){
        while(loop){
            System.out.println((int) (Math.random() *100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B extends Thread{
     private A a;
     private Scanner scanner = new Scanner(System.in);
    public B(A a) {
        this.a = a;
    }

    public void run(){
        while(true){
            System.out.println("请输入你的指令");
            char c = scanner.next().toUpperCase().charAt(0);
            if (c == 'Q')
                a.setLoop(false);
                break;
        }
    }
}
