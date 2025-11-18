package espe.edu.clientes;

import java.util.Scanner;

public class ClienteApiTestMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("   CLIENTE PARA CONSUMIR APIS DISTRIBUIDAS");
        System.out.println("==============================================");
        System.out.println("\nAsegúrate de que los siguientes servicios estén corriendo:");
        System.out.println("1. API SOAP - Puerto 8081");
        System.out.println("2. API gRPC - Puerto 50051 (servidor) / 8082 (Spring Boot)");
        System.out.println("3. API WebSocket - Puerto 8083");
        System.out.println("==============================================\n");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- SELECCIONA LA API A PROBAR ---");
            System.out.println("1. API SOAP");
            System.out.println("2. API gRPC");
            System.out.println("3. API WebSocket");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    testSoapApi();
                    break;
                case 2:
                    testGrpcApi();
                    break;
                case 3:
                    testWebSocketApi();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        scanner.close();
    }

    private static void testSoapApi() {
        System.out.println("\n==============================================");
        System.out.println("           PROBANDO API SOAP");
        System.out.println("==============================================");
        System.out.println("URL: http://localhost:8081/services/cliente");
        System.out.println("WSDL: http://localhost:8081/services/cliente?wsdl");
        System.out.println("\nPara probar esta API, puedes usar:");
        System.out.println("- SoapUI");
        System.out.println("- Postman");
        System.out.println("- Cliente SOAP Java");
        System.out.println("\nEjemplo de Request SOAP:");
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"");
        System.out.println("                  xmlns:ser=\"http://service.soap.edu.espe/\">");
        System.out.println("  <soapenv:Header/>");
        System.out.println("  <soapenv:Body>");
        System.out.println("    <ser:listarClientes/>");
        System.out.println("  </soapenv:Body>");
        System.out.println("</soapenv:Envelope>");
        System.out.println("==============================================\n");
    }

    private static void testGrpcApi() {
        try {
            GrpcClienteConsumer grpcClient = new GrpcClienteConsumer();
            grpcClient.connect();
            grpcClient.testOperations();
            grpcClient.disconnect();
        } catch (Exception e) {
            System.err.println("\nError al conectar con el servidor gRPC:");
            System.err.println("Asegúrate de que el servidor gRPC esté corriendo en localhost:50051");
            System.err.println("Detalle: " + e.getMessage());
        }
    }

    private static void testWebSocketApi() {
        try {
            WebSocketClienteConsumer wsClient = new WebSocketClienteConsumer();
            wsClient.connect();

            // Esperar un poco para asegurar la conexión
            Thread.sleep(1000);

            wsClient.testOperations();
            wsClient.disconnect();
        } catch (Exception e) {
            System.err.println("\nError al conectar con el servidor WebSocket:");
            System.err.println("Asegúrate de que el servidor WebSocket esté corriendo en localhost:8083");
            System.err.println("Detalle: " + e.getMessage());
        }
    }
}

