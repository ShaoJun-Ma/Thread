package com.msj.demo03;

/*
创建线程方法二：
1、创建：实现Runnable+重写run
2、启动：创建实现类对象+Thread对象（代理对象）+start
 */
public class StartThread implements Runnable{

    public void run() {
        for(int i=0;i<=10;i++){
            System.out.println("一边听歌");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //创建实现类对象
        StartThread th = new StartThread();
        //创建代理类对象
        Thread t = new Thread(th);
        //启动
        t.start();

//        new Thread(new StartThread()).start();

        for (int i=0;i<=10;i++){
            System.out.println("一边coding");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
