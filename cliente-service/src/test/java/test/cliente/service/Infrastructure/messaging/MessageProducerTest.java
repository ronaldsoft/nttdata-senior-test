package test.cliente.service.Infrastructure.messaging;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import test.cliente.service.Domain.model.Cliente;

@SpringBootTest
public class MessageProducerTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private MessageProducer clienteMessageProducer;

    @Test
    public void testEnviarMensaje() {

        // Crear y guardar un cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setTelefono("111222333");
        cliente.setIdentificacion("1711556540");
        cliente.setDireccion("Calle del Sol");
        cliente.setContrasenia("123456");
        cliente.setEstado(true);

        // Enviar el mensaje
        clienteMessageProducer.enviarMensaje("crear-cliente", cliente);

        // Verificar que RabbitTemplate envió el mensaje correctamente
        verify(rabbitTemplate, times(1)).convertAndSend("crear-cliente", cliente);
    }
}