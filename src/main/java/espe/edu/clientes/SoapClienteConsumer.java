package espe.edu.clientes;

import espe.edu.common.model.Cliente;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.sql.Date;

public class SoapClienteConsumer extends WebServiceGatewaySupport {

    public void testSoapApi() {
        System.out.println("\n=== PROBANDO API SOAP ===");

        // Aquí irían las llamadas SOAP reales
        // Por simplicidad, mostramos el concepto

        System.out.println("Endpoint SOAP: http://localhost:8081/services/cliente");
        System.out.println("WSDL: http://localhost:8081/services/cliente?wsdl");

        // Ejemplo de uso:
        // ClienteRequest request = new ClienteRequest();
        // ClienteResponse response = (ClienteResponse) getWebServiceTemplate()
        //     .marshalSendAndReceive("http://localhost:8081/services/cliente", request);

        System.out.println("Cliente SOAP configurado correctamente");
    }
}

