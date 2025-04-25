package io.geektoys.inventario_service.controller;

import io.geektoys.inventario_service.DTO.ItemsReservaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @PostMapping("/reservar")
    public void reservarProducto(@RequestBody ItemsReservaDTO itemsReservaDTO) {
        //Corroborar la reserva.
        System.out.println("llego la reserva:");
        System.out.println(itemsReservaDTO.getProductoId() + itemsReservaDTO.getReserva());
        //reservar.
        //responder.
    }

}
