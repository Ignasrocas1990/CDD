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
import java.util.concurrent.Semaphore;

/**
 * @author Ignas Rocas
 * @since 22/11/2021
 * Short and long description
 * <p>
 * Task class that threads uses to simulate a a philosopher problem
 * Multiple threads executes this class concurrently.
 * 
 * <p>
 */
public class Table implements Runnable{

    Semaphore[] fork;
    Semaphore footman;
    int j;
    Table() {}
    /**
     * 
     * @param fork - array of shared Semaphores that are set to 1
     * @param phylosopherN - passed in thread number for them to be specified
     * @param footman - prevent more threads that it is possible to enter
     */
    Table(Semaphore[] fork, int phylosopherN, Semaphore footman) {
        this.footman = footman;
        j = phylosopherN;
        this.fork = fork;
    }

    @Override
    public void run() {
        System.out.println(j+" arrived ");
        get_forks(j);
        System.out.println(j+" eating");
        put_forks(j);
        System.out.println(j+" finish eating");
    }
    /**
     * @param j - number declared for the thread in order to distinguish them.
     * Description : Method that let thread to get a right to process a task
     */
    public void get_forks(int j){
        try {

            footman.acquire();
            fork[j].acquire();
            fork[Main.nPhilosphers%j].acquire();

        } catch (Exception e) {
               System.out.println(e.getLocalizedMessage());
        }
    }
    /**
     * @param j - number declared for the thread in order to distinguish them.
     * Description : Method that let thread to give way for other process  try to take right to execute a task
     */
    public void put_forks(int j){
            fork[j].release();
            fork[Main.nPhilosphers%j].release();
            footman.release();
    }
}
