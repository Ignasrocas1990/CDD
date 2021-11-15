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
package com.mycompany.lab6;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Ignas Rocas
 * @since 01/15/2021
 * Short and long description
 * <p>
 * Main class used to create threads, queue and thread pool and assign 
 * tasks for them.
 * <p>
 */
public class Main {
    static final int MAX_T = 4; 
    static final int bufferSize = 4;
  
    /**
     * @param args - not used
     */

    public static void main(String[] args){
        final Queue<Character> buffer = new LinkedList<>();
        Semaphore items = new Semaphore(0);//number of items in the queue
        Semaphore mutex = new Semaphore(1);//buffer control
        Semaphore spaces = new Semaphore(bufferSize);//number of items

        

        // creates producer and consumber
        Runnable l1 = new Producer(buffer,items,mutex,spaces);
        Runnable l2 = new Consumer(buffer,items,mutex,spaces);


        // creates a thread pool with MAX_T no. of 
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
        
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(l1);
        pool.execute(l2);

        
        
        // pool shutdown ( Step 4)
        pool.shutdown();    
       
    }
}
