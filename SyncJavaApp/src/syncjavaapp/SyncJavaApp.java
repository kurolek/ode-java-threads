/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncjavaapp;

/**
 *
 * @author yurii
 */
public class SyncJavaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Data data = new Data();
        Worker worker1 = new Worker(1, data);
        Worker worker2 = new Worker(2, data);
        Worker worker3 = new Worker(3, data);
        
        /* new Thread(()->{
            for (int i = 0; i < 10; i++) {
                worker1.doWork();
            }
        }).start();
        
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                worker2.doWork();
            }
        }).start(); */
        
        new MyThread(worker2).start();
        new MyThread(worker3).start();
        new MyThread(worker1).start();
    }
    
    
}
