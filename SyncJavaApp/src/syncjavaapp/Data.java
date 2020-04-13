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
public class Data {
    
    // 1, 2, 3
    private int state = 1;
    
    public void tic(){
        System.out.print("tic-");
        state = 2;
    }
    
    public void tak(){
        System.out.print("tak-");
        state = 3;
    }
    
    public void tuk(){
        System.out.println("tuk");
        state = 1;
    }

    public int getState() {
        return state;
    }
}
