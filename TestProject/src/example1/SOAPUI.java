package example1;

import org.junit.Test;

import com.eviware.soapui.tools.SoapUITestCaseRunner;

public class SOAPUI {

	@Test
	public void verifyTheInputValueIsReturned() throws Exception {
        SoapUITestCaseRunner runner = new SoapUITestCaseRunner();
        runner.setProjectFile("C:/CurrencyConvertor-soapui-project.xml");
        String[] properties = new String[2];
        properties[0] = "FromCurrency=USD";
        properties[1] = "ToCurrency=INR";
        runner.setProjectProperties(properties);
        runner.run();
    }
}
