package test.cuenta.service.Infrastructure.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensaje(String cola, Object mensaje) {
        rabbitTemplate.convertAndSend(cola, mensaje);
    }

    public Object recibirMensaje(String cola, String mensaje) {
        return rabbitTemplate.convertSendAndReceive(cola, mensaje);
    }
}
