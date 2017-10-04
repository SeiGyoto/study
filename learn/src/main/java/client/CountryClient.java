package client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.sample.ws.GetCountries;
import com.sample.ws.GetCountriesResponse;


public class CountryClient extends WebServiceGatewaySupport{
	public GetCountriesResponse getCountries() {
        GetCountries request = new GetCountries();
        
        GetCountriesResponse response = (GetCountriesResponse) getWebServiceTemplate().marshalSendAndReceive(
            "http://www.webservicex.net/country.asmx?WSDL", request,new SoapActionCallback("http://www.webserviceX.NET/GetCountries"));
        return response;
    }
}
