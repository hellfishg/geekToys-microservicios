package io.geektoys.inventario_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "productos")
public class ProductoModel {
    @Id
    private String idMongo; // ID único de MongoDB (opcional si usás tu propio ID)

    private int id; // ID de negocio (productoId)
    private String nombre;
    private int stock;         // stock total
    private int reservado;     // unidades reservadas
    private BigDecimal precio;
    private String descripcion;


}
