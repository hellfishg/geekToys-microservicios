package io.geekToys.geektoys_pedido_service.model;

import java.math.BigDecimal;

public class ProductoDTO {
    private int id;
    private String Nombre;
    private int unidades;
    private BigDecimal precio;
    private String descripcion;

    protected ProductoDTO() {}

    public ProductoDTO(int id, String nombre, int unidades, BigDecimal precio, String descripcion) {
        this.id = id;
        Nombre = nombre;
        this.unidades = unidades;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    // Getters:
    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
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
