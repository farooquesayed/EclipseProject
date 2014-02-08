package ConcurrencyThreads;

public class ClassB implements Runnable {

	
	public static void threadClassB() {
		Thread t = new Thread(new ClassB());
		t.start();
	}

	
	@Override
	public void run() {
		
		try {
			//threadClassA();
			System.out.println("message 1 of Class B");	
				Thread.sleep(3000);
			System.out.println("message 2 of Class B");	
			Thread.sleep(3000);
			System.out.println("message 3 of Class B");	
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
