package example1;

import java.util.HashSet;
import java.util.Set;

import javax.xml.ws.Endpoint;

import org.testng.annotations.*;

public class SimpleTest {

	public static void main(String[] args) throws Exception {

		Set<String> zakirSets = new HashSet<String>();
		zakirSets.add("This is first string");
		zakirSets.add("This is second string");
		
		System.out.println(zakirSets);

		
	}


}
