package io.geekToys.geektoys_pedido_service.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducer {
    public static final String TOPIC = "pedido-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String mensaje) {
        kafkaTemplate.send(TOPIC, mensaje);
    }
}
