package br.com.marcelo.producing.controller;

import br.com.marcelo.producing.messaging.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/")
public class RabbitProducerController {

    private final MessageProducer messageProducer;

    public RabbitProducerController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @GetMapping(value = "/producer")
    public ResponseEntity producer(@RequestParam("message") String message) {
        messageProducer.sendMessage(message);
        return ResponseEntity.ok().build();
    }

}