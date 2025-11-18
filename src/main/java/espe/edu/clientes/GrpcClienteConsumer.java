package espe.edu.clientes;

import espe.edu.rpc.grpc.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GrpcClienteConsumer {

    private static final String GRPC_HOST = "localhost";
    private static final int GRPC_PORT = 50051;

    private ManagedChannel channel;
    private ClienteServiceGrpc.ClienteServiceBlockingStub blockingStub;

    public void connect() {
        System.out.println("\n=== PROBANDO API gRPC ===");
        System.out.println("Conectando a gRPC: " + GRPC_HOST + ":" + GRPC_PORT);

        channel = ManagedChannelBuilder.forAddress(GRPC_HOST, GRPC_PORT)
                .usePlaintext()
                .build();

        blockingStub = ClienteServiceGrpc.newBlockingStub(channel);
        System.out.println("✓ Conectado al servidor gRPC!");
    }

    public void testOperations() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- OPERACIONES gRPC ---");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Obtener Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Actualizar Cliente");
            System.out.println("5. Eliminar Cliente");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            try {
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
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
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

        ClienteRequest request = ClienteRequest.newBuilder()
                .setCedula(cedula)
                .setNombre(nombre)
                .setTelefono(telefono)
                .setEmail(email)
                .setDireccion(direccion)
                .build();

        ClienteResponse response = blockingStub.crearCliente(request);
        System.out.println("\n✓ Cliente creado:");
        System.out.println("ID: " + response.getIdCliente());
        System.out.println("Nombre: " + response.getNombre());
        System.out.println("Email: " + response.getEmail());
    }

    private void obtenerCliente(Scanner scanner) {
        System.out.print("ID del Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        ClienteIdRequest request = ClienteIdRequest.newBuilder()
                .setIdCliente(id)
                .build();

        ClienteResponse response = blockingStub.obtenerCliente(request);

        if (response.getIdCliente() > 0) {
            System.out.println("\n✓ Cliente encontrado:");
            System.out.println("ID: " + response.getIdCliente());
            System.out.println("Cédula: " + response.getCedula());
            System.out.println("Nombre: " + response.getNombre());
            System.out.println("Teléfono: " + response.getTelefono());
            System.out.println("Email: " + response.getEmail());
            System.out.println("Dirección: " + response.getDireccion());
        } else {
            System.out.println("Cliente no encontrado");
        }
    }

    private void listarClientes() {
        Empty request = Empty.newBuilder().build();
        ClienteListResponse response = blockingStub.listarClientes(request);

        System.out.println("\n✓ Lista de clientes (" + response.getClientesCount() + "):");
        for (ClienteResponse cliente : response.getClientesList()) {
            System.out.println("- ID: " + cliente.getIdCliente() +
                             ", Nombre: " + cliente.getNombre() +
                             ", Email: " + cliente.getEmail());
        }
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

        ClienteRequest request = ClienteRequest.newBuilder()
                .setIdCliente(id)
                .setCedula(cedula)
                .setNombre(nombre)
                .setTelefono(telefono)
                .setEmail(email)
                .setDireccion(direccion)
                .build();

        BoolResponse response = blockingStub.actualizarCliente(request);

        if (response.getSuccess()) {
            System.out.println("✓ Cliente actualizado exitosamente");
        } else {
            System.out.println("✗ Error al actualizar cliente");
        }
    }

    private void eliminarCliente(Scanner scanner) {
        System.out.print("ID del Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        ClienteIdRequest request = ClienteIdRequest.newBuilder()
                .setIdCliente(id)
                .build();

        BoolResponse response = blockingStub.eliminarCliente(request);

        if (response.getSuccess()) {
            System.out.println("✓ Cliente eliminado exitosamente");
        } else {
            System.out.println("✗ Error al eliminar cliente");
        }
    }

    public void disconnect() {
        if (channel != null && !channel.isShutdown()) {
            try {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                System.out.println("Desconectado del servidor gRPC");
            } catch (InterruptedException e) {
                System.err.println("Error al cerrar el canal: " + e.getMessage());
            }
        }
    }
}

