package example1;

import javax.xml.ws.Endpoint;

import org.testng.annotations.*;

import com.eviware.soapui.tools.SoapUITestCaseRunner;

public class SimpleTest {

	public static void main(String[] args) throws Exception {
	      SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
	        runner.setProjectFile("C:/CurrencyConvertor-soapui-project.xml");
	        String[] properties = new String[2];
	        properties[0] = "FromCurrency=USD";
	        properties[1] = "ToCurrency=INR";
	        runner.setProjectProperties(properties);
	        runner.run();

		
	}


}
