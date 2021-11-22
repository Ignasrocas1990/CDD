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
package lab7;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Ignas Rocas
 * @since 22/11/2021
 * Short and long description
 * <p>
 * Main class used to create threads, queue and thread pool and assign 
 * tasks for them.
 * It also creates an array of semaphores needed to simulate a philosopher problem
 * <p>
 */
public class Main {
    static final int MAX_T = 4; 
    static final int nPhilosphers = 5;
    static int phylosopherN=0;

    /**
     * @param args - not used
     */
    public static void main(String[] args){
        Semaphore footman = new Semaphore(nPhilosphers-1);
        Semaphore[] fork = new Semaphore[nPhilosphers];
        for (int i = 0; i < nPhilosphers; i++) {
            fork[i] = new Semaphore(1);
        }

        // creates producer and consumber
        Runnable p1 = new Table(fork,++phylosopherN,footman);
        Runnable p2 = new Table(fork,phylosopherN++,footman);
        Runnable p3 = new Table(fork,phylosopherN++,footman);
        Runnable p4 = new Table(fork,phylosopherN++,footman);
        Runnable p5 = new Table(fork,phylosopherN++,footman);

        // creates a thread pool with MAX_T no. of 
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
        
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(p1);
        pool.execute(p2);
        pool.execute(p3);
        pool.execute(p4);
        pool.execute(p5);

        // pool shutdown ( Step 4)
        pool.shutdown();    
       
    }
}
