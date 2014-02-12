package ParallelProcessing;

import org.junit.Test;

import Endorsement.*;
import FullQuote.FullQuoteMain;


public class RunMultipleTests {
	
	public static void main(String[] args) {  //To run using Java main
		
		RunMultipleTests t = new RunMultipleTests();
		t.DriveFullQuote();
		
		RunMultipleTests DE = new RunMultipleTests();
		DE.DriveEndorsement();
	}

	@Test  /// To run using Junit
	public void MainParallelRun() {
		RunMultipleTests t = new RunMultipleTests();
		t.DriveFullQuote();
		
		RunMultipleTests DE = new RunMultipleTests();
		DE.DriveEndorsement();
		
	}
	
	public void DriveFullQuote() {
		Thread t1 = new Thread(new FullQuoteMain("FF"));
		t1.start();

		Thread t2 = new Thread(new FullQuoteMain("CR"));
		t2.start();
	}
	
	public void DriveEndorsement() {
		Thread t1 = new Thread(new EndorsementMain("CR"));
		t1.start();
	
		Thread t2 = new Thread(new EndorsementMain("IE"));
		t2.start();
	}
	
}
