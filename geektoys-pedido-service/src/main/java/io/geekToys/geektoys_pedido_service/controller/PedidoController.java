package io.geekToys.geektoys_pedido_service.controller;

import io.geekToys.geektoys_pedido_service.DTO.PedidoDTO;
import io.geekToys.geektoys_pedido_service.mapper.PedidoMapper;
import io.geekToys.geektoys_pedido_service.messaging.producer.PedidoProducer;
import io.geekToys.geektoys_pedido_service.model.PedidoModel;
import io.geekToys.geektoys_pedido_service.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class PedidoController {
    public static final String TOPIC = "pedido-topic";

    PedidoProducer pedidoProducer;
    PedidoService pedidoService;
    PedidoMapper pedidoMapper;

    public PedidoController(PedidoProducer pedidoProducer, PedidoService pedidoService, PedidoMapper pedidoMapper){
        this.pedidoProducer = pedidoProducer;
        this.pedidoService = pedidoService;
        this.pedidoMapper = pedidoMapper;
    }

    @GetMapping("/")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    public void healtCheck(){}

    @PutMapping("/order-request")
    public ResponseEntity<PedidoDTO> crearPedido(@RequestBody PedidoDTO pedidoDTO) {
        PedidoModel pedidoModel = pedidoService.save(pedidoDTO);
        pedidoDTO.setId(pedidoModel.getId());
        pedidoProducer.sendPedidoMessage(TOPIC,pedidoDTO);
        System.out.println("Message sent --> " + pedidoDTO);
        return ResponseEntity.ok(pedidoDTO);
    }

    @GetMapping("/order-by-id")
    public ResponseEntity<PedidoModel> buscarPedidoPorId(@RequestBody Long id) {
        Optional<PedidoModel> pedidoOptional = pedidoService.encontrarPorId(id);
        if (pedidoOptional.isPresent()) {
            return ResponseEntity.ok(pedidoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/order-all")
    public ResponseEntity<List<PedidoModel>> buscarTodoLosPedidos() {
        return ResponseEntity.ok(pedidoService.todosLosPedidos());
    }
}
