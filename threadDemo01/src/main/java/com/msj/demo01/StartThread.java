package com.msj.demo01;
/*
创建线程的方法之一：
1、创建：继承Thread+重写run方法
2、启动：创建子类对象+start
 */
public class StartThread extends Thread{

    /*
    线程入口点
     */
    @Override
    public void run() {
        for (int i=0;i<=5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {
        //创建子类对象(创建线程对象)
        StartThread th = new StartThread();
        //启动新的线程，不保证立即运行，由cpu调用
        th.start();

        //普通方法调用
//        th.run();
        for (int i=0;i<=5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一边coding");
        }
    }
}
