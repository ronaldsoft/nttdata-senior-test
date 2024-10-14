package test.cuenta.service.Infrastructure.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CUENTA_QUEUE = "cuenta-queue";

    // Routing keys for different order processing stages
    public static final String ROUTING_KEY_CUENTA = "cuenta";

    @Bean
    public Queue clientQueue() {
        return new Queue(CUENTA_QUEUE);
    }

    // Configurar Jackson como el convertidor de mensajes
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // Configurar RabbitTemplate para usar Jackson como el convertidor
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
