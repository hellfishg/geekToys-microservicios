package io.geekToys.geektoys_pedido_service.DTO;

import java.math.BigDecimal;

public class ProductoDTO {
    private int id;
    private String nombre;
    private int unidades;
    private BigDecimal precio;
    private String descripcion;

    protected ProductoDTO() {}

    public ProductoDTO(int id, String nombre, int unidades, BigDecimal precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", unidades=" + unidades +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    // Getters:
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
