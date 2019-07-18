package com.msj.demo10;

public class DaemonTest {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("用户线程");
                }
                System.out.println("用户"+Thread.currentThread().isAlive());
            }
        }).start();

        Thread daemon = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("守护-"+i);
                }
                System.out.println("守护-"+Thread.currentThread().isAlive());
            }
        });
        daemon.setDaemon(true);
        daemon.start();

    }
}
