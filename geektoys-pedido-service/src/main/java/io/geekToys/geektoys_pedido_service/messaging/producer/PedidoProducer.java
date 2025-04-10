package io.geekToys.geektoys_pedido_service.messaging.producer;

import io.geekToys.geektoys_pedido_service.DTO.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducer {
    public static final String TOPIC = "pedido-topic";

    @Autowired
    private KafkaTemplate<String, PedidoDTO> kafkaTemplate;

    public void sendPedidoMessage(String topic, PedidoDTO pedidoDTO) {
        kafkaTemplate.send(TOPIC, pedidoDTO);
    }
}
