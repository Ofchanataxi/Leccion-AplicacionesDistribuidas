package espe.edu.rpc.service;

import espe.edu.common.dao.ClienteDAO;
import espe.edu.common.model.Cliente;
import espe.edu.rpc.grpc.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ClienteGrpcServiceImpl extends ClienteServiceGrpc.ClienteServiceImplBase {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public void crearCliente(ClienteRequest request, StreamObserver<ClienteResponse> responseObserver) {
        Cliente cliente = new Cliente();
        cliente.setCedula(request.getCedula());
        cliente.setNombre(request.getNombre());
        cliente.setTelefono(request.getTelefono());
        cliente.setEmail(request.getEmail());
        cliente.setDireccion(request.getDireccion());
        if (request.getFechaRegistro() != null && !request.getFechaRegistro().isEmpty()) {
            cliente.setFechaRegistro(Date.valueOf(request.getFechaRegistro()));
        }

        int id = clienteDAO.insertar(cliente);
        cliente.setIdCliente(id);

        ClienteResponse response = clienteToResponse(cliente);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void obtenerCliente(ClienteIdRequest request, StreamObserver<ClienteResponse> responseObserver) {
        Cliente cliente = clienteDAO.obtenerPorId(request.getIdCliente());

        if (cliente != null) {
            ClienteResponse response = clienteToResponse(cliente);
            responseObserver.onNext(response);
        } else {
            responseObserver.onNext(ClienteResponse.getDefaultInstance());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void listarClientes(Empty request, StreamObserver<ClienteListResponse> responseObserver) {
        List<Cliente> clientes = clienteDAO.listar();

        ClienteListResponse.Builder builder = ClienteListResponse.newBuilder();
        for (Cliente cliente : clientes) {
            builder.addClientes(clienteToResponse(cliente));
        }

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void actualizarCliente(ClienteRequest request, StreamObserver<BoolResponse> responseObserver) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(request.getIdCliente());
        cliente.setCedula(request.getCedula());
        cliente.setNombre(request.getNombre());
        cliente.setTelefono(request.getTelefono());
        cliente.setEmail(request.getEmail());
        cliente.setDireccion(request.getDireccion());
        if (request.getFechaRegistro() != null && !request.getFechaRegistro().isEmpty()) {
            cliente.setFechaRegistro(Date.valueOf(request.getFechaRegistro()));
        }

        boolean success = clienteDAO.actualizar(cliente);

        BoolResponse response = BoolResponse.newBuilder()
                .setSuccess(success)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void eliminarCliente(ClienteIdRequest request, StreamObserver<BoolResponse> responseObserver) {
        boolean success = clienteDAO.eliminar(request.getIdCliente());

        BoolResponse response = BoolResponse.newBuilder()
                .setSuccess(success)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private ClienteResponse clienteToResponse(Cliente cliente) {
        ClienteResponse.Builder builder = ClienteResponse.newBuilder()
                .setIdCliente(cliente.getIdCliente())
                .setNombre(cliente.getNombre() != null ? cliente.getNombre() : "");

        if (cliente.getCedula() != null) builder.setCedula(cliente.getCedula());
        if (cliente.getTelefono() != null) builder.setTelefono(cliente.getTelefono());
        if (cliente.getEmail() != null) builder.setEmail(cliente.getEmail());
        if (cliente.getDireccion() != null) builder.setDireccion(cliente.getDireccion());
        if (cliente.getFechaRegistro() != null) builder.setFechaRegistro(cliente.getFechaRegistro().toString());

        return builder.build();
    }
}

