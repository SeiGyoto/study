package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.ws.GetCountriesResponse;

@RestController
public class CountryController {
	@Autowired
    private CountryClient wsClient;
    @RequestMapping("callws")
    public Object callWs() {
        GetCountriesResponse response = wsClient.getCountries();
        return response.getGetCountriesResult();
    }
}
