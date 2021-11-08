/*
 * Copyright (C) 2021 ignas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycompany.lab3;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @author Ignas Rocas
 * @since 08/11/2021
 * Short and long description
 * <p>
 * Main class used to create threads/thread pool and assign 
 * tasks for them.
 * <p>
 */
public class Main {
    
      // Maximum number of threads in thread pool
    static final int MAX_T = 4;
    /**
     *
     * @param args - not used
     */
    public static void main(String[] args){
        
        
        final Barrier barrier = new Barrier(Main.MAX_T);

        // creates five tasks
         Runnable r1 = new Task(barrier,"task 1");
        Runnable r2 = new Task(barrier,"task 2");
        Runnable r3 = new Task(barrier,"task 3");
        Runnable r4 = new Task(barrier,"task 4");   


        //Runnable r2 = new Task("task 2",before_bar);
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
        // passes the Task objects to the pool to execute (Step 3)

        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);

        
       
          
        // pool shutdown ( Step 4)
        pool.shutdown();    
        
        /*
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("total is: "+total.value);
        */
    }
}
