package br.com.marcelo.producing.infraestructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${producing.rabbitmq.queue:producingqueue}")
    private String queueName;

    @Value("${producing.rabbitmq.exchange:producingexchange}")
    private String exchange;

    @Value("${producing.rabbitmq.routingkey:producingrouting}")
    private String routingkey;

    public String getQueueName() {
        return queueName;
    }

    public String getExchange() {
        return exchange;
    }

    public String getRoutingkey() {
        return routingkey;
    }
}
