package espe.edu.clientes;

import com.google.gson.Gson;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class WebSocketClienteConsumer {

    private static final String WS_URL = "http://localhost:8083/ws-clientes";
    private StompSession session;
    private Gson gson = new Gson();

    public void connect() throws Exception {
        System.out.println("\n=== PROBANDO API WEBSOCKET ===");
        System.out.println("Conectando a WebSocket: " + WS_URL);

        StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
        SockJsClient sockJsClient = new SockJsClient(
                Arrays.asList(new WebSocketTransport(webSocketClient)));

        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        CountDownLatch latch = new CountDownLatch(1);

        StompSessionHandler sessionHandler = new StompSessionHandlerAdapter() {
            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                System.out.println("✓ Conectado al WebSocket!");
                WebSocketClienteConsumer.this.session = session;

                // Suscribirse al topic
                session.subscribe("/topic/cliente", new StompFrameHandler() {
                    @Override
                    public Type getPayloadType(StompHeaders headers) {
                        return String.class;
                    }

                    @Override
                    public void handleFrame(StompHeaders headers, Object payload) {
                        System.out.println("\nRespuesta recibida:");
                        System.out.println(payload);
                    }
                });

                latch.countDown();
            }

            @Override
            public void handleException(StompSession session, StompCommand command,
                                       StompHeaders headers, byte[] payload, Throwable exception) {
                System.err.println("Error en WebSocket: " + exception.getMessage());
            }

            @Override
            public void handleTransportError(StompSession session, Throwable exception) {
                System.err.println("Error de transporte: " + exception.getMessage());
            }
        };

        stompClient.connectAsync(WS_URL, sessionHandler);

        if (!latch.await(5, TimeUnit.SECONDS)) {
            throw new Exception("No se pudo conectar al WebSocket");
        }
    }

    public void testOperations() {
        if (session == null || !session.isConnected()) {
            System.out.println("No hay conexión WebSocket activa");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- OPERACIONES WEBSOCKET ---");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Obtener Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Actualizar Cliente");
            System.out.println("5. Eliminar Cliente");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearCliente(scanner);
                    break;
                case 2:
                    obtenerCliente(scanner);
                    break;
                case 3:
                    listarClientes();
                    break;
                case 4:
                    actualizarCliente(scanner);
                    break;
                case 5:
                    eliminarCliente(scanner);
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void crearCliente(Scanner scanner) {
        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        String message = String.format(
            "{\"action\":\"CREATE\",\"cliente\":{\"cedula\":\"%s\",\"nombre\":\"%s\"," +
            "\"telefono\":\"%s\",\"email\":\"%s\",\"direccion\":\"%s\"}}",
            cedula, nombre, telefono, email, direccion
        );

        session.send("/app/cliente", message);
        System.out.println("Solicitud enviada...");
    }

    private void obtenerCliente(Scanner scanner) {
        System.out.print("ID del Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String message = String.format(
            "{\"action\":\"READ\",\"cliente\":{\"idCliente\":%d}}", id
        );

        session.send("/app/cliente", message);
        System.out.println("Solicitud enviada...");
    }

    private void listarClientes() {
        String message = "{\"action\":\"LIST\",\"cliente\":{}}";
        session.send("/app/cliente", message);
        System.out.println("Solicitud enviada...");
    }

    private void actualizarCliente(Scanner scanner) {
        System.out.print("ID del Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nueva Cédula: ");
        String cedula = scanner.nextLine();
        System.out.print("Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Nuevo Email: ");
        String email = scanner.nextLine();
        System.out.print("Nueva Dirección: ");
        String direccion = scanner.nextLine();

        String message = String.format(
            "{\"action\":\"UPDATE\",\"cliente\":{\"idCliente\":%d,\"cedula\":\"%s\"," +
            "\"nombre\":\"%s\",\"telefono\":\"%s\",\"email\":\"%s\",\"direccion\":\"%s\"}}",
            id, cedula, nombre, telefono, email, direccion
        );

        session.send("/app/cliente", message);
        System.out.println("Solicitud enviada...");
    }

    private void eliminarCliente(Scanner scanner) {
        System.out.print("ID del Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String message = String.format(
            "{\"action\":\"DELETE\",\"cliente\":{\"idCliente\":%d}}", id
        );

        session.send("/app/cliente", message);
        System.out.println("Solicitud enviada...");
    }

    public void disconnect() {
        if (session != null && session.isConnected()) {
            session.disconnect();
            System.out.println("Desconectado del WebSocket");
        }
    }
}

