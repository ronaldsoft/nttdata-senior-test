package test.cliente.service.Infrastructure.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import test.cliente.service.Domain.model.Cliente;
import test.cliente.service.Infrastructure.persistence.ClienteJpaRepository;

@Component
public class MessageConsumer {
    private final ClienteJpaRepository clienteJpaRepository;

    public MessageConsumer(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    // Consumidor para crear clientes
    @RabbitListener(queues = {})
    public void crear(Cliente cliente) {
        clienteJpaRepository.guardar(cliente);
        System.out.println("Cliente creado: " + cliente.getNombre());
    }

    @RabbitListener(queues = RabbitMQConfig.CLIENT_QUEUE)
    public Cliente obtenerClientePorId(String clienteId) {
        long id = Long.parseLong(clienteId);
        System.out.println("Consulta: " + clienteId);
        Cliente response = clienteJpaRepository.obtenerPorId(id);
        if (response != null) {
            System.out.println("Consulta: " + response.getNombre());
            return response;
        } else {
            return null;
        }
    }

    // Consumidor para actualizar clientes
    @RabbitListener(queues = {})
    public void actualizar(Long clienteId, Cliente cliente) {
        clienteJpaRepository.actualizarCliente(clienteId, cliente);
        System.out.println("Cliente actualizado: " + cliente.getNombre());
    }

    // Consumidor para eliminar clientes
    @RabbitListener(queues = {})
    public void eliminar(Long clienteId) {
        clienteJpaRepository.eliminarCliente(clienteId);
        System.out.println("Cliente eliminado: " + clienteId);
    }
}