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
 * @since 11/10/2021
 * Short and long description
 * <p>
 * This class used to impersonate task for
 * thread to complete
 */
public class Task implements Runnable {
private String name;
    String location;
    Semaphore semaphore = new Semaphore(1);
    Barrier barrier = new Barrier(Main.MAX_T,semaphore,false);


    Task(String name) {
        this.name = name;
    }
    
    public void run()
    {
        for (int i = 0; i < 2; i++) {
            System.out.println("running "+Thread.currentThread().getName());
           System.out.println("before barier vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
           
           barrier.arrival();
           //barrier --------
           System.out.println("after barier ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        }

    }
}
