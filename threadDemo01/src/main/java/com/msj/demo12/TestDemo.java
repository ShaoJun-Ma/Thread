package com.msj.demo12;

/**
 * 生产者和消费者
 */
public class TestDemo{
    private int count=1;//产品数

    //生产者
    public void product(){
        synchronized (this){
            if(count<10){
                count++;
                System.out.println(Thread.currentThread().getName()+"--生产了---"+count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //消费者
    public void consume(){
        synchronized (this){
            if(count>0){
                count--;
                System.out.println(Thread.currentThread().getName()+"--消费了---"+count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void main(String[] args) {
        TestDemo t = new TestDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    t.product();
                }

            }
        },"生产者").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    t.consume();
                }

            }
        },"消费者").start();
    }
}
