/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.lab3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignas
 */
public class Barrier{
    int total, count=0,startCount=0;
    boolean release;
    Semaphore s_lock;
    boolean localSense=false;

    
    public Barrier(int total,Semaphore s_lock,boolean release){
        this.total = total;
        this.s_lock = s_lock;
        this.release = release;
        
    }
    public void arrival(){
        System.out.println("arrived "+Thread.currentThread().getName());
        startCount++;
        localSense = !localSense;
        while(startCount < Main.MAX_T){
            System.out.print(Thread.currentThread().getName()+" waiting "+"startCount is "+startCount+" maxCount is  "+Main.MAX_T+" ");
            //loop the thread till all threads are completed.s
        }

        System.out.println(Thread.currentThread().getName()+"asks wha is localSense? "+localSense);
        try {
            s_lock.acquire();
            System.out.println(Thread.currentThread().getName()+" locked");
            count++;
            System.out.println("count is "+count);
        } catch (InterruptedException ex) {
            Logger.getLogger(Barrier.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("total is" +total);
        if(count==total){
            count = 0;
            release=localSense;
            System.out.println("release is "+release);
        }
        s_lock.release();
        System.out.println(Thread.currentThread().getName()+" released lock ");
        while (localSense != release) {    
            System.out.print(Thread.currentThread().getName()+" waiting "+"release is "+release+" localSense "+localSense+" ");
            //loop the thread till all threads are completed.s
        }
        if(startCount==Main.MAX_T){startCount=0;}
    }
}
