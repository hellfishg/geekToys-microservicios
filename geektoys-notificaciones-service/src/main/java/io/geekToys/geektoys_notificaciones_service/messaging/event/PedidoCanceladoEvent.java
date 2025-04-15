package io.geekToys.geektoys_notificaciones_service.messaging.event;

import io.geekToys.geektoys_notificaciones_service.DTO.ProductoDTO;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoCanceladoEvent {
    private int id;
    private String motivo;
    private int clienteId;
    private List<ProductoDTO> itemsSinStock;
    private String canalVentas;
    private LocalDateTime fechaCreacion;

    public PedidoCanceladoEvent(int id, String motivo, int clienteId, List<ProductoDTO> itemsSinStock, String canalVentas, LocalDateTime fechaCreacion) {
        this.id = id;
        this.motivo = motivo;
        this.clienteId = clienteId;
        this.itemsSinStock = itemsSinStock;
        this.canalVentas = canalVentas;
        this.fechaCreacion = fechaCreacion;
    }

    public PedidoCanceladoEvent() {}

    // Getters and Setters:
    public void setId(int id) {
        this.id = id;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setItemsSinStock(List<ProductoDTO> itemsSinStock) {
        this.itemsSinStock = itemsSinStock;
    }

    public void setCanalVentas(String canalVentas) {
        this.canalVentas = canalVentas;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public int getClienteId() {
        return clienteId;
    }

    public List<ProductoDTO> getItemsSinStock() {
        return itemsSinStock;
    }

    public String getCanalVentas() {
        return canalVentas;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

}
