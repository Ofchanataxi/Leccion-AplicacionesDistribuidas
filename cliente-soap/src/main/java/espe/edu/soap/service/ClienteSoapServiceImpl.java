package espe.edu.soap.service;

import jakarta.jws.WebService;
import org.springframework.stereotype.Service;
import espe.edu.common.dao.ClienteDAO;
import espe.edu.common.model.Cliente;

import java.util.List;

@Service
@WebService(endpointInterface = "espe.edu.soap.service.ClienteSoapService",
        serviceName = "ClienteSoapService")
public class ClienteSoapServiceImpl implements ClienteSoapService {

    private final ClienteDAO clienteDAO;

    public ClienteSoapServiceImpl(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public int crearCliente(Cliente c) {
        return clienteDAO.insertar(c);
    }

    @Override
    public Cliente obtenerClientePorId(int idCliente) {
        return clienteDAO.obtenerPorId(idCliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }

    @Override
    public boolean actualizarCliente(Cliente c) {
        return clienteDAO.actualizar(c);
    }

    @Override
    public boolean eliminarCliente(int idCliente) {
        return clienteDAO.eliminar(idCliente);
    }
}
