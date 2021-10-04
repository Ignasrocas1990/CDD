package com.itcarlow.runnabletest;
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
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();
        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();
    }   
    
}
