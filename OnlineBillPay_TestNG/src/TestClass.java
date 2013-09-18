import org.testng.annotations.Test;






public class TestClass {

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		int tempString = 121;
//		double output;
//		
//		output = Math.random() + 1;
//		System.out.println(output * tempString);
//	}
	@Test
	public void fClass1() {
		System.out.println("Printing from Class1");
	}

	
	@Test
	public void fClass3() {
		System.out.println("Printing from Class3");
	}	@Test
	public void fClass4() {
		System.out.println("Printing from Class4");
	}
	@Test
	public void fClass2() {
		String a = System.getProperty("Dev");
		System.out.println(a);
		System.out.println("Printing from Class2");
	}
}
