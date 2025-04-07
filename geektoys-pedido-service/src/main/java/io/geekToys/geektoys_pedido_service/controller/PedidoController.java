package io.geekToys.geektoys_pedido_service.controller;

import io.geekToys.geektoys_pedido_service.model.PedidoDTO;
import io.geekToys.geektoys_pedido_service.model.PedidoModel;
import io.geekToys.geektoys_pedido_service.producer.PedidoProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class PedidoController {
    PedidoProducer pedidoProducer;

    public PedidoController(PedidoProducer pedidoProducer){
        this.pedidoProducer = pedidoProducer;
    }

    @GetMapping("/")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    public void healtCheck(){}

    @GetMapping("/order-request")
    public ResponseEntity<PedidoDTO> orderRequest(@RequestBody PedidoDTO pedidoDTO){
        String canalDeventas = pedidoDTO.getCanalVentas().toString();
        pedidoProducer.sendMessage(canalDeventas);
        System.out.println("Message sent --> " + canalDeventas);
        return ResponseEntity.ok(pedidoDTO);
    }
}
