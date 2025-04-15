package io.geekToys.geektoys_notificaciones_service.messaging.consumer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.geekToys.geektoys_notificaciones_service.messaging.event.Envelope;
import io.geekToys.geektoys_notificaciones_service.messaging.event.PedidoCanceladoEvent;
import io.geekToys.geektoys_notificaciones_service.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @Autowired
    ObjectMapper objectMapper;// se instancia por Spring para agregar jackson-datatype-jsr310

    @Autowired
    MailService mailService;

    @KafkaListener(topics = "pedido-cancelado", groupId = "pedido-group")
    public Envelope<PedidoCanceladoEvent> escucharPedido(String mensajeJson) {
        Envelope<PedidoCanceladoEvent> evento = new Envelope<PedidoCanceladoEvent>();

        try {
            // Crear el tipo Envelope<PedidoCanceladoEvent>
            JavaType tipo = objectMapper.getTypeFactory()
                    .constructParametricType(Envelope.class, PedidoCanceladoEvent.class);

            // Deserializar (se necesita un dependencia pom de jackson para las fechas)
            evento = objectMapper.readValue(mensajeJson, tipo);

            // Usar el evento deserializado
            PedidoCanceladoEvent payload = evento.getPayload();
            System.out.println("📩 Pedido cancelado ID: " + payload.getId());
            System.out.println("🧾 Motivo: " + payload.getMotivo());

            // Envio de mail
            mailService.enviarEmail(
                    "hellfish.g@gmail.com",
                    "Pedido cancelado",
                    payload.getMotivo()
            );

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Error envio mail.");
        }
        return evento;
    }
}
