package espe.edu.common.dao;

import espe.edu.common.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class ClienteDAO {

    private final JdbcTemplate jdbcTemplate;

    // RowMapper para convertir resultados de DB a objeto Cliente
    private final RowMapper<Cliente> clienteRowMapper = (rs, rowNum) -> {
        Cliente c = new Cliente();
        c.setIdCliente(rs.getInt("id_cliente"));
        c.setCedula(rs.getString("cedula"));
        c.setNombre(rs.getString("nombre"));
        c.setTelefono(rs.getString("telefono"));
        c.setEmail(rs.getString("email"));
        c.setDireccion(rs.getString("direccion"));
        c.setFechaRegistro(rs.getDate("fecha_registro"));
        return c;
    };

    // Spring Boot inyecta automáticamente el JdbcTemplate configurado
    @Autowired
    public ClienteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertar(Cliente c) {
        String sql = "INSERT INTO cliente (cedula, nombre, telefono, email, direccion, fecha_registro) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getCedula());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getDireccion());
            // Usamos java.sql.Date directamente
            ps.setDate(6, c.getFechaRegistro()); 
            return ps;
        }, keyHolder);

        // Obtener el ID generado por la base de datos (PostgreSQL SERIAL)
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    @Override
    public Cliente obtenerPorId(int idCliente) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try {
            return jdbcTemplate.queryForObject(sql, clienteRowMapper, idCliente);
        } catch (EmptyResultDataAccessException e) {
            // Retorna null si no se encuentra el cliente
            return null;
        }
    }

    @Override
    public List<Cliente> listar() {
        String sql = "SELECT * FROM cliente";
        return jdbcTemplate.query(sql, clienteRowMapper);
    }

    @Override
    public boolean actualizar(Cliente c) {
        String sql = "UPDATE cliente SET cedula = ?, nombre = ?, telefono = ?, email = ?, direccion = ? WHERE id_cliente = ?";
        int rowsAffected = jdbcTemplate.update(sql,
            c.getCedula(),
            c.getNombre(),
            c.getTelefono(),
            c.getEmail(),
            c.getDireccion(),
            c.getIdCliente()
        );
        return rowsAffected > 0;
    }

    @Override
    public boolean eliminar(int idCliente) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        int rowsAffected = jdbcTemplate.update(sql, idCliente);
        return rowsAffected > 0;
    }
}
