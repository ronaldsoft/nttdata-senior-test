package test.cliente.service.Infrastructure.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import test.cliente.service.Domain.model.Cliente;
import test.cliente.service.Infrastructure.persistence.ClienteJpaRepository;

public class MessageConsumer {
    private final ClienteJpaRepository clienteJpaRepository;

    public MessageConsumer(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    // Consumidor para crear clientes
    @RabbitListener(queues = "crear-cliente")
    public void crear(Cliente cliente) {
        clienteJpaRepository.guardar(cliente);
        System.out.println("Cliente creado: " + cliente.getNombre());
    }

    // Consumidor para actualizar clientes
    @RabbitListener(queues = "actualizar-cliente")
    public void actualizar(Long clienteId, Cliente cliente) {
        clienteJpaRepository.actualizarCliente(clienteId, cliente);
        System.out.println("Cliente actualizado: " + cliente.getNombre());
    }

    // Consumidor para eliminar clientes
    @RabbitListener(queues = "eliminar-cliente")
    public void eliminar(Long clienteId) {
        clienteJpaRepository.eliminarCliente(clienteId);
        System.out.println("Cliente eliminado: " + clienteId);
    }
}