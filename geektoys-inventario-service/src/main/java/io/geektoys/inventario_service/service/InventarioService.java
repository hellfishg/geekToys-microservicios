package io.geektoys.inventario_service.service;

import io.geektoys.inventario_service.exceptions.ProductNotFoundException;
import io.geektoys.inventario_service.model.ProductoModel;
import io.geektoys.inventario_service.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {

    private final ProductoRepository productoRepository;

    public InventarioService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public boolean reserveIfInStock(int productId, int clientReserve) {
        ProductoModel product = productoRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        int availableStock = product.getStock() - product.getReservado();
        if (availableStock >= clientReserve ) {
            int addReserve = product.getReservado() + clientReserve;
            product.setReservado(addReserve);
            productoRepository.save(product);
            return true;
        }
        return false;
    }
}
