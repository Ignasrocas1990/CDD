package com.itcarlow.extendthread;
/**
 * @author Ignas Rocas C001357830
 * @since 04/10/2021
 * @version 1.0
 * 
 * Create two threads and run them.
 */
public class TestThread {
    /**
     * @param args Unused
     */
    public static void main(String args[]) {
      ThreadDemo T1 = new ThreadDemo( "Thread-1");
      T1.start();
      ThreadDemo T2 = new ThreadDemo( "Thread-2");
      T2.start();
   } 
}
