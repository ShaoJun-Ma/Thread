package com.msj.demo07;
/*
yield:礼让线程，暂停线程，直接进入就绪状态
 */
public class YieldDemo {
    public static void main(String[] args) {
        MyYield my = new MyYield();
        new Thread(my,"A").start();
        new Thread(my,"B").start();
    }
}
class MyYield implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName()+"---start");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+"---end");
    }
}
