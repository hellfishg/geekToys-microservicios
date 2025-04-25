package io.geektoys.inventario_service.exceptions;


public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(int productId) {
        System.out.println("Producto no encontrado con Id: " + productId);
    }
}
