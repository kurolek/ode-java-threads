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
public class Worker {

    // 1 - Tic-
    // 2 - tak
    private int id;
    private Data data;

    public Worker(int id, Data data) {
        this.id = id;
        this.data = data;
    }
    
    public void doWork() throws InterruptedException{
        synchronized(data){
            while (id != data.getState()) {
                data.wait();
            }
            if (id == 1) {
                data.tic();
            } else if (id == 2) {
                data.tak();
            } else {
                data.tuk();
            }
            data.notifyAll();
        }
    }
}
