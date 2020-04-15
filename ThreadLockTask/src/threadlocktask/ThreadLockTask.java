/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadlocktask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Юрий
 */
public class ThreadLockTask {


    public static void main(String[] args) throws Exception {
        Data d = new Data();

        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            es.submit(new WorkWData(d));


        TimeUnit.SECONDS.sleep(3);
        es.shutdown();
        //es.shutdownNow();
        es.awaitTermination(10000, TimeUnit.MILLISECONDS);
    }
}

class WorkWData implements Runnable {
    Data obj;


    WorkWData(Data d) {
        obj = d;
    }

    public void run() {
        int n;


        n = obj.read();
        System.out.println("First read" + " " + Thread.currentThread().getName() + " " + new Integer(n).toString());
        obj.write();
        n = obj.read();
        System.out.println("Second read" + " " + Thread.currentThread().getName() + " " + new Integer(n).toString());

    }
}

class Data {
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    int count = 1;

    int read() {
        rwl.writeLock().lock();
        rwl.readLock().lock();

        try {
            int n = count;
            TimeUnit.MILLISECONDS.sleep(100);
            count = n;

        } catch (InterruptedException ex) {

        } finally {
            rwl.writeLock().unlock();
            rwl.readLock().unlock();

        }

        return count;
    }

    void write() {


        rwl.writeLock().lock();
        rwl.readLock().lock();
        try {
            if (rwl.isWriteLocked()) {
                int n = count;
                TimeUnit.MILLISECONDS.sleep(100);
                n++;
                count = n;
            }

        } catch (InterruptedException ex) {

        } finally {
            rwl.readLock().unlock();
            rwl.writeLock().unlock();

        }

    }

}
