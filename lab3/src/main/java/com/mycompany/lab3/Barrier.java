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

import java.util.concurrent.Semaphore;

/**
 * @author Ignas Rocas
 * @since 08/11/2021
 * Short and long description
 * <p>
 * This class used for barrier implementation.
 * Threads have to run through two phases
 * 
 */
public class Barrier{
    /*
    total is number of threads initialized
    count is number threads arrived at the point
    */
    int total, count=0,startCount=0;
    Semaphore s_lock1;
    Semaphore s_lock2;
    Semaphore mutex;

    /**
     * 
     * @param total - number of threads initialized
     */
    public Barrier(int total){
        this.total = total;
        this.s_lock1 = new Semaphore(0);
        this.s_lock2 = new Semaphore(0);
        this.mutex = new Semaphore(1);

    }
    /**
     * Threads are forced to go through arrival method in stages,
     * first stage increment count till all threads arrive(using s_lock1)
     * second stage decrement count till all threads arrive(using s_lock2)
     */
    public void arrival(){
        try {
            mutex.acquire();
            count++;
            if(count==total){
                s_lock1.release(total);
            }
            mutex.release();
            s_lock1.acquire();
            
            mutex.acquire();
            count--;
            if(count == 0){
                s_lock2.release(total);
            }
            mutex.release();
            s_lock2.acquire();
            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
