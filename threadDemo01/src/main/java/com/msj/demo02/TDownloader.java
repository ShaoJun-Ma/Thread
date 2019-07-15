package com.msj.demo02;

public class TDownloader extends Thread {
    private String url; //远程路径
    private String name; //存储名字

    public TDownloader(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        //新建WebDownloader()对象
        WebDownloader wb = new WebDownloader();
        wb.download(url,name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        String url1 = "https://f12.baidu.com/it/u=1165816337,2187748178&fm=72";
        String url2 = "https://f11.baidu.com/it/u=378294897,2044571698&fm=72";
        String url3 = "https://f10.baidu.com/it/u=2823417446,3545571241&fm=72";
        TDownloader td1 = new TDownloader(url1, "pic1.jpg");
        TDownloader td2= new TDownloader(url2, "pic2.jpg");
        TDownloader td3 = new TDownloader(url3, "pic3.jpg");
        //启动三个线程
        td1.start();
        td2.start();
        td3.start();
    }
}
