package test.cliente.service.Infrastructure;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IntegrationTest {

    // @Autowired
    // private ClienteJpaRepository clienteJpaRepository;

    // @Autowired
    // private MessageProducer MessageProducer;

    // @Autowired
    // private RabbitTemplate rabbitTemplate;

    // @Test
    // public void testGuardarClienteYEnviarMensaje() {
    // // Crear un cliente
    // Cliente cliente = new Cliente();
    // cliente.setNombre("Carlos");
    // cliente.setTelefono("111222333");
    // cliente.setDireccion("Calle del Sol");
    // cliente.setContrasenia("123456");
    // cliente.setEstado(true);

    // // Guardar el cliente en la base de datos
    // Cliente clienteGuardado = clienteJpaRepository.guardar(cliente);

    // // Verificar que el cliente fue guardado
    // assertThat(clienteGuardado.getId()).isNotNull();

    // // Enviar mensaje a RabbitMQ, para crear cliente
    // MessageProducer.enviarMensaje("crear-cliente", cliente);

    // // Verificar que RabbitTemplate envió el mensaje correctamente
    // verify(rabbitTemplate).convertAndSend("clienteQueue", cliente);
    // }
}