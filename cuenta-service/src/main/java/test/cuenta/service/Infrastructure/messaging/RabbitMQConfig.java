package test.cuenta.service.Infrastructure.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String CUENTA_QUEUE = "cuenta-queue";

    // Routing keys for different order processing stages
    public static final String ROUTING_KEY_CUENTA = "cuenta";

    @Bean
    public Queue cuentaQueue() {
        return new Queue(CUENTA_QUEUE);
    }

    // @Bean
    // public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    // RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    // rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(new
    // ObjectMapper())); // Configura Jackson
    // // para enviar JSON
    // return rabbitTemplate;
    // }
}
