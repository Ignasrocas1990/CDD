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

/**
 * @author Ignas Rocas
 * @since 08/11/2021
 * Short and long description
 * <p>
 * This class used to impersonate task for
 * thread to complete
 */
public class Task implements Runnable {
private String name;
    String location;
    Barrier barrier;

    /**
     * 
     * @param barrier - Barrier to split the code
     * @param name - name of the task
     */
    Task(Barrier barrier,String name) {
        this.name = name;
        this.barrier = barrier;
    }
    /**
     * all threads runs before barrier first
     * and then goes through barrier
     * and runs after barrier
     */
    public void run()
    {
        for (int i = 0; i < 2; i++) {
           System.out.println("before barrier vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
           barrier.arrival();
           System.out.println("after barrier ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        }

    }
}
