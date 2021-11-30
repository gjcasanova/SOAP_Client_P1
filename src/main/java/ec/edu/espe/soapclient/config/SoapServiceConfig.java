package ec.edu.espe.soapclient.config;

import ec.edu.espe.soapclient.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapServiceConfig {

    @Autowired
    private DemoService demoService;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("soapserver.wsdl");
        return marshaller;
    }

    @Bean
    @Primary
    public DemoService countryClient(Jaxb2Marshaller marshaller) {
        demoService.setMarshaller(marshaller);
        demoService.setUnmarshaller(marshaller);
        return demoService;
    }

}
