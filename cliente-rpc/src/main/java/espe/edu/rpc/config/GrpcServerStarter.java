package espe.edu.rpc.config;

import espe.edu.rpc.service.ClienteGrpcServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GrpcServerStarter implements CommandLineRunner {

    @Autowired
    private ClienteGrpcServiceImpl clienteGrpcService;

    @Override
    public void run(String... args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(clienteGrpcService)
                .build();

        server.start();
        System.out.println("Servidor gRPC iniciado en el puerto 50051");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Apagando servidor gRPC...");
            server.shutdown();
        }));
    }
}

