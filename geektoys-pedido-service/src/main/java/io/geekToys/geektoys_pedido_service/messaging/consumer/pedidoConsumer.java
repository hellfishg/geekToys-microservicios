package io.geekToys.geektoys_pedido_service.messaging.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class pedidoConsumer {

    @KafkaListener(topics = "pedido-topic", groupId = "pedido-group")
    public void escucharPedido(String mensaje) {
        System.out.println("Mensaje recibido <-- " + mensaje);
    }
}
