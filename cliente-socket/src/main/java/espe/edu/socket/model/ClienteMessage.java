package espe.edu.socket.model;

public class ClienteMessage {
    private String action; // CREATE, READ, UPDATE, DELETE, LIST
    private ClienteData cliente;

    public ClienteMessage() {}

    public ClienteMessage(String action, ClienteData cliente) {
        this.action = action;
        this.cliente = cliente;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ClienteData getCliente() {
        return cliente;
    }

    public void setCliente(ClienteData cliente) {
        this.cliente = cliente;
    }
}

