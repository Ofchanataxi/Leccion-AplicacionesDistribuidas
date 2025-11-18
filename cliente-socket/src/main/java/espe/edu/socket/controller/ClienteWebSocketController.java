package espe.edu.socket.controller;

import espe.edu.common.dao.ClienteDAO;
import espe.edu.common.model.Cliente;
import espe.edu.socket.model.ClienteData;
import espe.edu.socket.model.ClienteMessage;
import espe.edu.socket.model.ClienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteWebSocketController {

    @Autowired
    private ClienteDAO clienteDAO;

    @MessageMapping("/cliente")
    @SendTo("/topic/cliente")
    public ClienteResponse handleClienteMessage(ClienteMessage message) {
        ClienteResponse response = new ClienteResponse();

        try {
            switch (message.getAction().toUpperCase()) {
                case "CREATE":
                    return crearCliente(message.getCliente());
                case "READ":
                    return obtenerCliente(message.getCliente().getIdCliente());
                case "UPDATE":
                    return actualizarCliente(message.getCliente());
                case "DELETE":
                    return eliminarCliente(message.getCliente().getIdCliente());
                case "LIST":
                    return listarClientes();
                default:
                    response.setSuccess(false);
                    response.setMessage("Acción no válida: " + message.getAction());
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error: " + e.getMessage());
        }

        return response;
    }

    private ClienteResponse crearCliente(ClienteData data) {
        Cliente cliente = dataToCliente(data);
        int id = clienteDAO.insertar(cliente);
        cliente.setIdCliente(id);

        ClienteResponse response = new ClienteResponse(true, "Cliente creado exitosamente");
        response.setCliente(clienteToData(cliente));
        return response;
    }

    private ClienteResponse obtenerCliente(int idCliente) {
        Cliente cliente = clienteDAO.obtenerPorId(idCliente);

        ClienteResponse response = new ClienteResponse();
        if (cliente != null) {
            response.setSuccess(true);
            response.setMessage("Cliente encontrado");
            response.setCliente(clienteToData(cliente));
        } else {
            response.setSuccess(false);
            response.setMessage("Cliente no encontrado");
        }
        return response;
    }

    private ClienteResponse actualizarCliente(ClienteData data) {
        Cliente cliente = dataToCliente(data);
        boolean success = clienteDAO.actualizar(cliente);

        ClienteResponse response = new ClienteResponse(success,
            success ? "Cliente actualizado" : "Error al actualizar cliente");
        if (success) {
            response.setCliente(data);
        }
        return response;
    }

    private ClienteResponse eliminarCliente(int idCliente) {
        boolean success = clienteDAO.eliminar(idCliente);
        return new ClienteResponse(success,
            success ? "Cliente eliminado" : "Error al eliminar cliente");
    }

    private ClienteResponse listarClientes() {
        List<Cliente> clientes = clienteDAO.listar();
        List<ClienteData> clientesData = new ArrayList<>();

        for (Cliente cliente : clientes) {
            clientesData.add(clienteToData(cliente));
        }

        ClienteResponse response = new ClienteResponse(true, "Lista de clientes obtenida");
        response.setClientes(clientesData);
        return response;
    }

    private Cliente dataToCliente(ClienteData data) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(data.getIdCliente());
        cliente.setCedula(data.getCedula());
        cliente.setNombre(data.getNombre());
        cliente.setTelefono(data.getTelefono());
        cliente.setEmail(data.getEmail());
        cliente.setDireccion(data.getDireccion());
        if (data.getFechaRegistro() != null && !data.getFechaRegistro().isEmpty()) {
            cliente.setFechaRegistro(Date.valueOf(data.getFechaRegistro()));
        }
        return cliente;
    }

    private ClienteData clienteToData(Cliente cliente) {
        ClienteData data = new ClienteData();
        data.setIdCliente(cliente.getIdCliente());
        data.setCedula(cliente.getCedula());
        data.setNombre(cliente.getNombre());
        data.setTelefono(cliente.getTelefono());
        data.setEmail(cliente.getEmail());
        data.setDireccion(cliente.getDireccion());
        if (cliente.getFechaRegistro() != null) {
            data.setFechaRegistro(cliente.getFechaRegistro().toString());
        }
        return data;
    }
}

