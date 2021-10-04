package com.itcarlow.runnabletest;

/**
 * @author Ignas Rocas C001357830
 * @since 04/10/2021
 * @version 1.0
 * 
 */
class RunnableDemo implements Runnable {
    //fields and methods
    /**
     * Here is where we put our thread created by start() method
     */
   private Thread t;
    /**
    * Every thread is given a name
    */
   private String threadName;
   
   /**
    * This method display's thread created with given Name
    * @param name String that assign's thread a name.
    */
   RunnableDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   @Override
   public void run() {
      System.out.println("Running " +  threadName );
      try {
              /**
              * Prints out message four times
              */
         for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
       /**
       * Prints exit message
       */
      System.out.println("Thread " +  threadName + " exiting.");
   }
   /**
    * Method used to create & start new thread
    */
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
