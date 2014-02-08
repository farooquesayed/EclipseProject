package ConcurrencyThreads;

import org.junit.Test;

public class MainThreadClass {

	public static void main(String[] args) {
		
		System.out.println("Creating thread for ClassA");
		ClassA tc1 = new ClassA();
		tc1.threadClassA();
		
		ClassB.threadClassB();
	}	

}
