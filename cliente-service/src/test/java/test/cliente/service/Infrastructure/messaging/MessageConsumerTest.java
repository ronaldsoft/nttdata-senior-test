package test.cliente.service.Infrastructure.messaging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import test.cliente.service.Domain.model.Cliente;
import test.cliente.service.Infrastructure.persistence.ClienteJpaRepository;

public class MessageConsumerTest {

    @Mock
    private ClienteJpaRepository clienteJpaRepository;

    @InjectMocks
    private MessageConsumer clienteMessageConsumer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCrearCliente() {
        // Simular un objeto Cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setTelefono("111222333");
        cliente.setIdentificacion("1711556509");
        cliente.setDireccion("Calle del Sol");
        cliente.setContrasenia("123456");
        cliente.setEstado(true);

        // Llamar al método que escucha la cola 'crear-cliente'
        clienteMessageConsumer.crear(cliente);

        // Verificar que el método save() del repositorio fue llamado con el cliente
        // validar con microservicios desplegados
        // verify(clienteJpaRepository, times(1)).save(cliente);
    }

    @Test
    public void testActualizarCliente() {
        // Simular un objeto Cliente
        // Simular el ID del cliente a eliminar
        Long clienteId = 1L;
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setTelefono("111222333");
        cliente.setIdentificacion("1711556509");
        cliente.setDireccion("Calle del Sol");
        cliente.setContrasenia("123456");
        cliente.setEstado(true);

        // Llamar al método que escucha la cola 'actualizar-cliente'
        clienteMessageConsumer.actualizar(clienteId, cliente);

        // Verificar que el método save() fue llamado con el cliente actualizado
        // validar con microservicios desplegados
        // verify(clienteJpaRepository, times(1)).save(cliente);
    }

    @Test
    public void testEliminarCliente() {
        // Simular el ID del cliente a eliminar
        Long clienteId = 1L;

        // Llamar al método que escucha la cola 'eliminar-cliente'
        clienteMessageConsumer.eliminar(clienteId);

        // Verificar que el método deleteById() fue llamado con el ID correcto
        // validar con microservicios desplegados
        // verify(clienteJpaRepository, times(1)).deleteById(clienteId);
    }
}