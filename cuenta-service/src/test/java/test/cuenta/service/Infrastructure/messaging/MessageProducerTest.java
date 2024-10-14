package test.cuenta.service.Infrastructure.messaging;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import test.cuenta.service.Domain.model.Cuenta;

@SpringBootTest
public class MessageProducerTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private MessageProducer messageProducer;

    @Test
    public void testEnviarMensaje() {

        // Crear y guardar un cuenta
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("478758");
        cuenta.setTipoCuenta("Ahorros");
        cuenta.setSaldoInicial(2000D);
        cuenta.setEstado("Activo");
        cuenta.setClienteid(1L);

        // Enviar el mensaje
        messageProducer.enviarMensaje("crear-cuenta", cuenta);

        // Verificar que RabbitTemplate envió el mensaje correctamente
        verify(rabbitTemplate, times(1)).convertAndSend("crear-cuenta", cuenta);
    }
}