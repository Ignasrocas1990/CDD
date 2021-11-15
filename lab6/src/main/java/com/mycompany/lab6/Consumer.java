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

import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * @author Ignas Rocas
 * @since 01/15/2021
 * Short and long description
 * <p>
 * Consumer class imitating a mover that removes items from the buffer
 * and removes them
 * <p>
 */
public class Consumer implements Runnable
 {
    Queue<Character> buffer;
    Semaphore items,  mutex,  spaces;

        /**
     * @param buffer - place for storing items
     * @param items - shared number of items in the buffer
     * @param mutex - shared mutex to synchronize the removing items from the buffer
     * @param spaces -shared number of spaces in the buffer
     */
    Consumer(Queue<Character> buffer, Semaphore items, Semaphore mutex, Semaphore spaces) {
        this.buffer = buffer;
        this.items = items;
        this.mutex = mutex;
        this.spaces = spaces;
    }
    
    /**
     * thread method used to remove characters from buffer
     * change them into large case and print them to the screen
     */
    @Override
    public void run() {
        try {
            char event;
            for (int i = 0; i < Main.bufferSize; i++) {
                items.acquire();
                mutex.acquire();
                event = buffer.remove();
                mutex.release();
                spaces.release();
                
                System.out.println(Character.toUpperCase(event));
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
    }
    
    
}
