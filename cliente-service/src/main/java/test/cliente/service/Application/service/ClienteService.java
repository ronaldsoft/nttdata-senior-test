package test.cliente.service.Application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import test.cliente.service.Domain.model.Cliente;
import test.cliente.service.Infrastructure.persistence.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.guardar(cliente);
    }

    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.obtenerPorId(id);
    }

    // Leer todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.obtenerTodosLosClientes();
    }

    // Actualizar un cliente
    public Cliente actualizarCliente(Long id, Cliente clienteDetalles) {
        return clienteRepository.actualizarCliente(id, clienteDetalles);
    }

    // Eliminar un cliente
    public void eliminarCliente(Long id) {
        clienteRepository.eliminarCliente(id);
    }
}