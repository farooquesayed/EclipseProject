package com.zakir.java;

//import org.junit.Before;
//import org.junit.Test;

public class Class2 implements Runnable {
	

	public static void main(String[] args) {
		Thread t = new Thread(new Class2());
		t.start();
		String threadName =
	            Thread.currentThread().getName();
	    System.out.println(threadName);	
	    try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			System.out.println("Interrupt reached.");
			e.printStackTrace();
		}
	    if(t.isAlive()) {
	    	System.out.println("It's taking longer to complete.. trying to interrup");	
		    t.interrupt();
		    try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    System.out.println(t.interrupted());
	    }
	    	
	}
		
	static void interruptthreadMessage() {

	}
	
	@Override
	public void run() {
		String importantInfo[] = {
	            "Mares eat oats",
	            "Does eat oats",
	            "Little lambs eat ivy",
	            "A kid will eat ivy too"
	        };

	        for (int i = 0;
	             i < importantInfo.length;
	             i++) {
	            //Pause for 4 seconds
	            try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            //Print a message
	            System.out.println(importantInfo[i]);
	        }
	}	
		


}
