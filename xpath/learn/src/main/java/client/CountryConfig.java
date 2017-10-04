package client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfig {
	@Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.sample.ws");
        return marshaller;
    }
    @Bean
    public CountryClient wsClient(Jaxb2Marshaller marshaller) {
    		CountryClient client = new CountryClient();
        client.setDefaultUri("http://www.webservicex.net/country.asmx?WSDL");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
