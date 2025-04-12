package io.geekToys.geektoys_pedido_service.messaging.event;

import java.time.LocalDateTime;

public class Envelope<T> {

    private String tipo;
    private String version;
    private LocalDateTime timestamp;
    private T payload; // nombre del contenido real.

    public Envelope() {
    }

    public Envelope(String tipo, String version, LocalDateTime timestamp, T payload) {
        this.tipo = tipo;
        this.version = version;
        this.timestamp = timestamp;
        this.payload = payload;
    }

    // Getters y Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Envelope{" +
                "tipo='" + tipo + '\'' +
                ", version='" + version + '\'' +
                ", timestamp=" + timestamp +
                ", payload=" + payload +
                '}';
    }
}
