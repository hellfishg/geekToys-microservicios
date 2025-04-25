package io.geektoys.inventario_service.service;

import io.geektoys.inventario_service.exceptions.ProductNotFoundException;
import io.geektoys.inventario_service.model.ProductoModel;
import io.geektoys.inventario_service.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InventarioServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private InventarioService inventarioService;

    ProductoModel product = new ProductoModel();

    @BeforeEach
    public void loadProduct() {
        product.setId(1);
        product.setIdMongo("1");
        product.setNombre("Tablets");
        product.setStock(200);
        product.setReservado(50);
        product.setPrecio(BigDecimal.valueOf(3000));
        product.setDescripcion("Tabletas IPADS");
    }

    @Test
    public void  whenHaveProductStockDoReservedTheyTrue() {
        int clientReserve = 100;

        when(productoRepository.findById(product.getId())).thenReturn(Optional.of(product));

        boolean reserveIsComplete = inventarioService.reserveIfInStock(product.getId(), clientReserve);
        assertTrue(reserveIsComplete);
    }

    @Test
    public void whenNotHaveProductStockTheyFalse() {
        int clientReserve = 200;

        when(productoRepository.findById(product.getId())).thenReturn(Optional.of(product));

        boolean stockIsOut = inventarioService.reserveIfInStock(product.getId(), clientReserve);
        assertFalse(stockIsOut);
    }

    @Test
    public void whenReserveIfInStockGeneralFail() {
        int failProductId = 34;
        int clientReserve = 200;

        when(productoRepository.findById(failProductId)).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> {
            inventarioService.reserveIfInStock(failProductId, clientReserve);
        });
    }
}
