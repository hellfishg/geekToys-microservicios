package io.geekToys.geektoys_pedido_service.model;

import io.geekToys.geektoys_pedido_service.enums.CanalVentas;
import io.geekToys.geektoys_pedido_service.enums.EstadoPedido;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class PedidoModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "cliente_id", nullable = false)
    private int clienteId; // Sera accesible desde otro microservicio la relacion. por eso la dejo.

    @Column(name = "items", nullable = false)
    private String items;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "direccion_envio", nullable = false)
    private String direccionEnvio;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "canal_ventas", nullable = false)
    private CanalVentas canalVentas;

    @Enumerated(EnumType.STRING) // convertir Enums en String para JPA.
    @Column(name = "estado_pedido", nullable = false)
    private EstadoPedido estadoPedido;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    // Constructor vacio protegido requerido por JPA.
    public PedidoModel() {
    }

    public PedidoModel(int id, int clienteId, String itemsIdJson, BigDecimal total, String direccionEnvio, String metodoPago, CanalVentas canalVentas, EstadoPedido estadoPedido, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.clienteId = clienteId;
        this.items = itemsIdJson;
        this.total = total;
        this.direccionEnvio = direccionEnvio;
        this.metodoPago = metodoPago;
        this.canalVentas = canalVentas;
        this.estadoPedido = estadoPedido;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = fechaActualizacion;
    }

    @Override
    public String toString() {
        return "PedidoModel{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", items='" + items + '\'' +
                ", total=" + total +
                ", direccionEnvio='" + direccionEnvio + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", canalVentas=" + canalVentas +
                ", estadoPedido=" + estadoPedido +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaActualizacion=" + fechaActualizacion +
                '}';
    }


    // Getters:
    public int getId() {
        return id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public CanalVentas getCanalVentas() {
        return canalVentas;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    // Setters:

    public void setId(int id) {
        this.id = id;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setCanalVentas(CanalVentas canalVentas) {
        this.canalVentas = canalVentas;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
