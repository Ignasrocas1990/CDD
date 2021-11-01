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


/**
 * @author Ignas Rocas
 * @since 01/11/2021
 * Short and long description
 * <p>
 * Follower class as a Task 
 * <p>
 */
public class Follower implements Runnable{
    DanceFloor queue;
    String name;
/**
 * 
 * @param name - name of the task
 * @param queue - controller of tasks
 */
    Follower(String name, DanceFloor queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        queue.followerDance(name);
    }
}
