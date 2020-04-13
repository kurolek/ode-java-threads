package demo2;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        Data d=new Data();
        MyThread t1=new MyThread(d);
        MyThread t2=new MyThread(d);

        Thread.sleep(3000);
        System.out.println(d.count);
        System.out.println(Data.countSt);
    }
}

class Data
{
    int count =0;
    static int countSt =0;
}

class MyThread implements Runnable {
  
    Data obj;
    
    MyThread(Data d){
        obj = d;
        new Thread(this).start();
    }
    
    //TODO: синхронизировать работу обоих методов с полями count и countSt
    
    void Add(){
        // try {
            //Thread.sleep(10);
            synchronized(obj){
                // int n=obj.count;
                // n++;
                //Thread.sleep(10);
                // obj.count=n;
                obj.count++;
            }
        // } catch (InterruptedException ex) {       }
    }
    // static void AddStatic() {
    synchronized static void AddStatic() {
        // try {
            // Thread.sleep(10);
            // int n=Data.countSt;
            // n++;
            // Thread.sleep(10);
            // Data.countSt=n;
            Data.countSt++;
        // } catch (InterruptedException ex) {       }
    }
    public void run() {
        for(int i=0; i<10000; i++) Add();
        for(int i=0; i<10000; i++) AddStatic();
    }
}
