package io.geekToys.geektoys_pedido_service.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.geekToys.geektoys_pedido_service.enums.CanalVentas;
import io.geekToys.geektoys_pedido_service.enums.EstadoPedido;
import jakarta.persistence.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "cliente_id", nullable = false)
    private int clienteId; // Sera accesible desde otro microservicio la relacion. por eso la dejo.

    @Column(name = "itemsId_json", nullable = false)
    private String itemsIdJson;

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
    @Column(name = "estado", nullable = false)
    private EstadoPedido estadoPedido;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    // Constructor vacio protegido requerido por JPA.
    protected PedidoModel() {
    }

    public PedidoModel(int id, int clienteId, String itemsIdJson, BigDecimal total, String direccionEnvio, String metodoPago, CanalVentas canalVentas, EstadoPedido estado, LocalDateTime fechaActualizacion) {
        this.id = id;
        this.clienteId = clienteId;
        this.itemsIdJson = itemsIdJson;
        this.total = total;
        this.direccionEnvio = direccionEnvio;
        this.metodoPago = metodoPago;
        this.canalVentas = canalVentas;
        this.estadoPedido = estado;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaActualizacion = fechaActualizacion;
    }

    // Getters:
    public int getId() {
        return id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getItemsIdJson() {
        return itemsIdJson;
    }

    public List<ProductoDTO> getItemsList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(itemsIdJson, new TypeReference<List<ProductoDTO>>(){});
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
}
