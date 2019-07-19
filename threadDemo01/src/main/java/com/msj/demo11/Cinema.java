package com.msj.demo11;

import java.util.Random;

/**
 * 电影院抢票：加锁机制（锁住共用的资源）
 */
public class Cinema {
    private static Integer availableSeats;  //可用的位置（共用资源）

    public Cinema(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean book(int seats){//seats：抢到的座位（各自的资源）
        synchronized (Cinema.class){
            System.out.println("可用位置为："+availableSeats);
            if(seats>availableSeats){
                System.out.println("出票失败"+Thread.currentThread().getName()+"--"+"没有位置");
                return false;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            availableSeats -= seats;
            System.out.println("出票成功"+Thread.currentThread().getName()+"--"+"位置为"+seats);
            return true;
        }

    }
    public static void main(String[] args) {
        Cinema c = new Cinema(20);
        for(int i=1;i<8;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    int i = random.nextInt(5);
                    c.book(i);
                }
            },"a"+i).start();
        }

    }
}
