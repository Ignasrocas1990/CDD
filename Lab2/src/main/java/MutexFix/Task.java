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
package MutexFix;
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
    private IntegerObj total;

    /**
     *
     * @param task_1 - name for tread
     * @param total - task counter
     */
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;
    }
    
    /**
     * run's 500 tasks with sleep between 100
     */
    public void run()
    {
        try
        {
            for (int i = 0; i<500; i++)
            {
                total.inc();
                if (i%100==0){
                   Thread.sleep(100); 
                }
                
            }
            System.out.println(name+" complete");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
