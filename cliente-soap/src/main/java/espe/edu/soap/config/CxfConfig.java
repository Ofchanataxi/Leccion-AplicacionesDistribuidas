package espe.edu.soap.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import espe.edu.soap.service.ClienteSoapService;
import jakarta.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    @Bean
    public Endpoint clienteSoapEndpoint(Bus bus, ClienteSoapService service) {
        EndpointImpl endpoint = new EndpointImpl(bus, service);
        endpoint.publish("/ClienteSoap"); // -> /services/ClienteSoap (por cxf.path)
        return endpoint;
    }
}
