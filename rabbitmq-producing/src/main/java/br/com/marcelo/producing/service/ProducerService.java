package br.com.marcelo.producing.service;

import br.com.marcelo.producing.infraestructure.RabbitConfig;
import br.com.marcelo.producing.messaging.MessageProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService implements MessageProducer {

    private final RabbitConfig rabbitConfig;
    private final AmqpTemplate rabbitTemplate;

    public ProducerService(RabbitConfig rabbitConfig, AmqpTemplate rabbitTemplate) {
        this.rabbitConfig = rabbitConfig;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(Object message) {
        rabbitTemplate.convertAndSend(rabbitConfig.getExchange(), rabbitConfig.getRoutingkey(), message);
    }
}
