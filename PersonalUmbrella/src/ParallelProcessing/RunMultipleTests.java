package ParallelProcessing;

import org.junit.Test;
import Endorsement.*;


public class RunMultipleTests {
	
	public static void main(String[] args) {
		//FullQuote.Main.DriveFullQuote();
		EndorsementMain driveMain = new EndorsementMain("CR");
		driveMain.DriveEndorsement();
	}

	@Test
	public void MainParallelRun() {
		EndorsementMain driveMain = new EndorsementMain("CR");
		driveMain.DriveEndorsement();
		
	}
	
	
}
