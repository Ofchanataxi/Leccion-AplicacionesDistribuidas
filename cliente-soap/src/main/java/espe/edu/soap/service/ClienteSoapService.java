package espe.edu.soap.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import espe.edu.common.model.Cliente;
import java.util.List;

@WebService
public interface ClienteSoapService {

    @WebMethod
    int crearCliente(Cliente c);

    @WebMethod
    Cliente obtenerClientePorId(int idCliente);

    @WebMethod
    List<Cliente> listarClientes();

    @WebMethod
    boolean actualizarCliente(Cliente c);

    @WebMethod
    boolean eliminarCliente(int idCliente);
}
