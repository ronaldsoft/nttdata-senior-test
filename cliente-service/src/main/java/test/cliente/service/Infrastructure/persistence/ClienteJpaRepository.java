package test.cliente.service.Infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.cliente.service.Domain.model.Cliente;

@Repository
public interface ClienteJpaRepository extends JpaRepository<Cliente, Long>, ClienteRepository {
    // funciones crud en el repositorio
    @Override
    default Cliente guardar(Cliente cliente) {
        return save(cliente);
    }

    @Override
    default Cliente obtenerPorId(Long id) {
        return findById(id).orElse(null);
    }

    @Override
    default List<Cliente> obtenerTodosLosClientes() {
        return findAll();
    }

    @Override
    default Cliente actualizarCliente(Long id, Cliente clienteDetalles) {
        Cliente clienteExistente = findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        clienteExistente.setNombre(clienteDetalles.getNombre());
        clienteExistente.setDireccion(clienteDetalles.getDireccion());
        clienteExistente.setTelefono(clienteDetalles.getTelefono());
        clienteExistente.setContrasenia(clienteDetalles.getContrasenia());
        clienteExistente.setEstado(clienteDetalles.getEstado());

        return save(clienteExistente);
    }

    @Override
    default void eliminarCliente(Long id) {
        deleteById(id);
    }
}
