package test.cliente.service.Infrastructure.persistence;

import java.util.List;

import test.cliente.service.Domain.model.Cliente;

public interface ClienteRepository {
    Cliente guardar(Cliente cliente);

    Cliente obtenerPorId(Long id);

    List<Cliente> obtenerTodosLosClientes();

    Cliente actualizarCliente(Long id, Cliente clienteDetalles);

    void eliminarCliente(Long id);
}
