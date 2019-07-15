package com.msj.demo04;

public class Web12306 implements Runnable{
    //票数
    private int ticketNums = 99;

    public void run() {
        while(true){
            if(ticketNums<=0){
                break;
            }
            //获取当前线程的名字
            System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"A").start();
        new Thread(web,"B").start();
        new Thread(web,"C").start();
    }
}
