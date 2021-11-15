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

import java.util.Random;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * @author Ignas Rocas
 * @since 01/15/2021
 * Short and long description
 * <p>
 * Producer class imitating a mover 
 * that create items and moves them into a buffer 
 * <p>
 */
public class Producer implements Runnable
 {
    Queue<Character> buffer;
    Semaphore items,  mutex,  spaces;
    int item;

    public Producer() {}
    
    /**
     * @param buffer - place for storing items
     * @param items - shared number of items in the buffer
     * @param mutex - shared mutex to synchronize the adding items to the buffer
     * @param spaces -shared number of spaces in the buffer
     */
    Producer(Queue<Character> buffer, Semaphore items, Semaphore mutex, Semaphore spaces) {
        this.buffer = buffer;
        this.items = items;
        this.mutex = mutex;
        this.spaces = spaces;
        
    }
    
    /**
     * thread method used to create a character and add it to the buffer
     */
    @Override
    public void run() {
        Random r = new Random();
        try {
            for (int i = 0; i < Main.bufferSize; i++) {
            spaces.acquire();
            mutex.acquire();
            char temp = (char)(r.nextInt(26) + 'a');
            System.out.println(temp);
            buffer.add(temp);
            mutex.release();
            items.release();
            
        }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
       
    }
}
