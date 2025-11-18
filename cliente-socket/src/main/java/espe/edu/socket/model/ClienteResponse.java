package espe.edu.socket.model;

import java.util.List;

public class ClienteResponse {
    private boolean success;
    private String message;
    private ClienteData cliente;
    private List<ClienteData> clientes;

    public ClienteResponse() {}

    public ClienteResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ClienteData getCliente() {
        return cliente;
    }

    public void setCliente(ClienteData cliente) {
        this.cliente = cliente;
    }

    public List<ClienteData> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteData> clientes) {
        this.clientes = clientes;
    }
}

