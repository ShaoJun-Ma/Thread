package com.msj.demo10;
/*
优先级：
Thread.NORM_PRIORITY  默认5
Thread.MIN_PRIORITY   1
Thread.MAX_PRIORITY   10
获得调度的概率高低
不代表绝对的先后顺序
 */
public class PriorityTest {
    public static void main(String[] args) {
        for(int i=1;i<10;i++){
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"  " +
                            Thread.currentThread().getPriority());
                }
            },"a"+i);
            t1.setPriority(i);
            t1.start();


        }
        Thread.yield();
        for(int i=30;i<60;i++){
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  " +
                            Thread.currentThread().getPriority());
                }
            }, "b" + i);
            t2.setPriority(Thread.MIN_PRIORITY);
            t2.start();
        }

    }
}
