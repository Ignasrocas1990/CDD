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
import java.util.concurrent.Semaphore;
/**
 * @author Ignas Rocas
 * @since 01/11/2021
 * Short and long description
 * <p>
 * Queue class used to control Follower and Leader class
 * <p>
 */
public class DanceFloor{
        Semaphore mutex = new Semaphore(1);
        Semaphore leaderQ = new Semaphore(0);
        Semaphore followerQ = new Semaphore(0);
        Semaphore rendezvous = new Semaphore(0);
        int leaders=0,followers=0;
        
    /**
     * @param name - name of the task,  Follower with number
     */
        public void followerDance(String name){
        try {
           mutex.acquire();

        if(leaders>0){
            leaders--;
            leaderQ.release();

        }else{
            followers++;
            mutex.release();
            followerQ.acquire();
        }
        System.out.println("1 "+name);
        rendezvous.release();
        
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
        /**
         * @param name - name of the task, Leader with number
         * 
         */
        public void leaderDance(String name){
            try {
                mutex.acquire();

            if(followers>0){
                followers--;
                followerQ.release();
            }
            else{
                leaders++;
                mutex.release();
                leaderQ.acquire();
                
            }
            System.out.println("A "+name);
            rendezvous.acquire();
            mutex.release();
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
        }
}
