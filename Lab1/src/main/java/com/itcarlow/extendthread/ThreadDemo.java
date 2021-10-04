package com.itcarlow.extendthread;
/**
 * @author Ignas Rocas C00135830
 * @since 04/10/2021
 * @version 1.0
 * 
 * 
 */
class ThreadDemo extends Thread {
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
   ThreadDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   @Override
   public void run() {
       /**
        * Prints out start of thread message
        */
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
             /**
              * Prints out message four times
              */
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
   
   @Override
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
