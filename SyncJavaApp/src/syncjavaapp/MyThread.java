/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syncjavaapp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yurii
 */
public class MyThread extends Thread {

    private Worker worker;

    public MyThread(Worker worker) {
        this.worker = worker;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                worker.doWork();
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
