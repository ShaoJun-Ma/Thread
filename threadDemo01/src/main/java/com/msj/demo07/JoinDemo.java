package com.msj.demo07;

public class JoinDemo {
    public static void main(String[] args) {
        MotherThread motherThread = new MotherThread();
        new Thread(motherThread).start();
    }
}
class MotherThread implements Runnable{
    public void run() {
        System.out.println("M：想做饭，发现没有盐，让儿子买盐");
        System.out.println("M：拿钱给儿子");
        Thread t = new Thread(new SonThread());
        t.start();
        try {
            t.join();
            System.out.println("M:拿到盐，可以继续做饭");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class SonThread implements Runnable{
    public void run() {
        System.out.println("S：拿过钱出门");
        for(int i=8;i>0;i--){
            System.out.println(i+"秒过去了。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("S：赶紧买盐回家");
    }
}
