package example1;

import javax.ws.rs.core.MultivaluedMap;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class JerseyPractice {

	static String wsPATH = "http://rpc.geocoder.us/service/csv?";
	protected static QName serviceName;
	protected static QName portName;

	   static {
	      serviceName = new QName("http://www.example.org/contract/DoubleIt",
	         "DoubleItService");
	      portName = new QName("http://www.example.org/contract/DoubleIt", "DoubleItPort");
	   }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		callGeoCoderRESTService("address", "605+S+Verdugo+rd,+Glendale+CA");
		callGeoCoderService();
	}
	
	static void SOAPserviceCall() {
		Service javaservice = Service.create(serviceName);
	}
	
	 static void callGeoCoderRESTService(String key, String value) {
		 ClientConfig cc = new DefaultClientConfig();
		 cc.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
		 Client c = Client.create(cc);
		 
		 WebResource r = c.resource(wsPATH);
	 
		 String response = r.path(wsPATH).queryParam(key, value).get(String.class);
		 
		 System.out.println(response);
		
	}
	
	 static void callGeoCoderService() {
		 ClientConfig cc = new DefaultClientConfig();
		 cc.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
		 Client c = Client.create(cc);
		 
		 WebResource r = c.resource("http://rpc.geocoder.us/service/csv?");
	 
		 MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		 params.add("address", "605+S+Verdugo+rd,+Glendale+CA");
		 
		 String response = r.path("").queryParams(params).get(String.class);
		 
		 System.out.println(response);
		
	}

}
