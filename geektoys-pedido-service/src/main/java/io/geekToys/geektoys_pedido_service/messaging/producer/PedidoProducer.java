package io.geekToys.geektoys_pedido_service.messaging.producer;

import io.geekToys.geektoys_pedido_service.DTO.PedidoDTO;
import io.geekToys.geektoys_pedido_service.messaging.event.Envelope;
import io.geekToys.geektoys_pedido_service.messaging.event.PedidoCanceladoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PedidoProducer {
    public static final String PEDIDO_CANCELADO = "pedido-cancelado";
    public static final String PEDIDO_RESERVADO = "pedido-reservado";

    @Autowired
    KafkaTemplate<String, Envelope> kafkaTemplate;

    public void publicarPedidoCancelado(PedidoDTO pedidoDTO) {
        PedidoCanceladoEvent pedidoCanceladoEvent = new PedidoCanceladoEvent(
                pedidoDTO.getId(),
                "Falta de stock",
                pedidoDTO.getClienteId(),
                pedidoDTO.getItems(),
                pedidoDTO.getCanalVentas().toString(),
                pedidoDTO.getFechaCreacion()
        );

        Envelope<PedidoCanceladoEvent> mensaje = new Envelope<>(
                "pedido-cancelado-stock",
                "1.0",
                LocalDateTime.now(),
                pedidoCanceladoEvent
        );

        kafkaTemplate.send(PEDIDO_CANCELADO, mensaje);
    }

    public void publicarPedidoReservado(PedidoDTO pedidoDTO) {
        Envelope<PedidoDTO> mensaje = new Envelope<>(
                "pedido-reservado-stock",
                "1.0",
                LocalDateTime.now(),
                pedidoDTO
        );

        kafkaTemplate.send(PEDIDO_RESERVADO, mensaje);
    }
}
