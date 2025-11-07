package espe.edu.common.dao;

import espe.edu.common.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository  // Esta anotación hace que Spring Boot lo reconozca como un bean
public class ClienteDAO {

    public int insertar(Cliente c) {
        System.out.println("Insertando cliente: " + c.getNombre());
        // Aquí iría la lógica JDBC (INSERT)
        return 1; // id generado simulado
    }

    public Cliente obtenerPorId(int idCliente) {
        System.out.println("Obteniendo cliente con id: " + idCliente);
        // Simulación temporal
        Cliente c = new Cliente();
        c.setIdCliente(idCliente);
        c.setNombre("Cliente demo");
        return c;
    }

    public List<Cliente> listar() {
        System.out.println("Listando todos los clientes");
        // Simulación temporal
        return new ArrayList<>();
    }

    public boolean actualizar(Cliente c) {
        System.out.println("Actualizando cliente: " + c.getIdCliente());
        return true;
    }

    public boolean eliminar(int idCliente) {
        System.out.println("Eliminando cliente con id: " + idCliente);
        return true;
    }
}