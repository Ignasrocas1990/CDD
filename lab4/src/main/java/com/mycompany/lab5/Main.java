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
package com.mycompany.lab5;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Ignas Rocas
 * @since 01/11/2021
 * Short and long description
 * <p>
 * Main class used to create threads, queue and thread pool and assign 
 * tasks for them.
 * <p>
 */
public class Main {
    
      // Maximum number of threads in thread pool
    static final int MAX_T = 4;     
  
    /**
     * @param args - not used
     */

    public static void main(String[] args){
        final DanceFloor queue = new DanceFloor();

        // creates seight tasks
        Runnable l1 = new Leader("Leader 1",queue);
        Runnable l2 = new Leader("Leader 2",queue);
        Runnable l3 = new Leader("Leader 3",queue);
        Runnable l4 = new Leader("Leader 4",queue);
        
        Runnable f1 = new Follower("Follower 1",queue);
        Runnable f2 = new Follower("Follower 2",queue);
        Runnable f3 = new Follower("Follower 3",queue);
        Runnable f4 = new Follower("Follower 4",queue);

        // creates a thread pool with MAX_T no. of 
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
        
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(l1);
        pool.execute(l2);
        pool.execute(l3);  
        pool.execute(f3);
        pool.execute(l4);
        
        pool.execute(f1);
        pool.execute(f2);
        pool.execute(f4);
        
        
        // pool shutdown ( Step 4)
        pool.shutdown();    
       
    }
}
