package ConcurrencyThreads;

import org.junit.Test;

public class ClassA implements Runnable {
	
	
	public static void threadClassA() {
		Thread t = new Thread(new ClassA());
		t.start();
	}

	
	@Override
	public void run() {
		
		try {
			//threadClassA();
			System.out.println("ClassA message 1");	
				Thread.sleep(5000);
			System.out.println("ClassA message 2");	
			Thread.sleep(5000);
			System.out.println("ClassA message 3");	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
