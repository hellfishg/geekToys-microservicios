package io.geekToys.geektoys_pedido_service.client;

import io.geekToys.geektoys_pedido_service.DTO.ItemsReservaDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventarioRestClientService {

    private final RestTemplate restTemplate;

    @Value("${inventario-service.url}") // Extrae de application.yml
    private String inventarioServiceUrl;

    public InventarioRestClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Métodos para interactuar con inventario-service
    public ItemsReservaDTO reservarProducto(ItemsReservaDTO solicitud) {
        String url = inventarioServiceUrl + "/reservar";
        return restTemplate.postForObject(url, solicitud, ItemsReservaDTO.class);
    }

}
