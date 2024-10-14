package test.cuenta.service.Infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.cuenta.service.Infrastructure.messaging.MessageProducer;
import test.cuenta.service.Infrastructure.persistence.CuentaJpaRepository;

@SpringBootTest
public class IntegrationTest {

    @Autowired
    private CuentaJpaRepository cuentaJpaRepository;

    @Autowired
    private MessageProducer MessageProducer;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testGuardarCuentaYEnviarMensaje() {
        // Crear un cuenta
        // Cuenta cuenta = new Cuenta();

        // cuenta.setNumeroCuenta("423778");
        // cuenta.setTipoCuenta("Ahorros");
        // cuenta.setSaldoInicial(2000D);
        // cuenta.setEstado("Activo");
        // cuenta.setClienteid(1L);

        // // Guardar el cuenta en la base de datos
        // Cuenta cuentaGuardado = cuentaJpaRepository.guardar(cuenta);

        // // Verificar que el cuenta fue guardado
        // assertThat(cuentaGuardado.getNumeroCuenta()).isNotNull();

        // // Enviar mensaje a RabbitMQ, para crear cuenta
        // MessageProducer.enviarMensaje("crear-cuenta", cuenta);

        // Verificar que RabbitTemplate envió el mensaje correctamente
        // verify(rabbitTemplate).convertAndSend("crear-cuenta", cuenta);
    }
}