package io.geekToys.geektoys_pedido_service.model;

import io.geekToys.geektoys_pedido_service.enums.CanalVentas;
import io.geekToys.geektoys_pedido_service.enums.EstadoPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoDTO {
    private int id;
    private int clienteId;
    private String itemsIdJson;
    private BigDecimal total;
    private String direccionEnvio;
    private String metodoPago;
    private CanalVentas canalVentas;
    private EstadoPedido estadoPedido;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    // Getters y Setters:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getItemsIdJson() {
        return itemsIdJson;
    }

    public void setItemsIdJson(String itemsIdJson) {
        this.itemsIdJson = itemsIdJson;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public CanalVentas getCanalVentas() {
        return canalVentas;
    }

    public void setCanalVentas(CanalVentas canalVentas) {
        this.canalVentas = canalVentas;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}

