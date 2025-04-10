package io.geekToys.geektoys_pedido_service.service;

import io.geekToys.geektoys_pedido_service.DTO.PedidoDTO;
import io.geekToys.geektoys_pedido_service.enums.EstadoPedido;
import io.geekToys.geektoys_pedido_service.mapper.PedidoMapper;
import io.geekToys.geektoys_pedido_service.model.PedidoModel;
import io.geekToys.geektoys_pedido_service.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    public PedidoModel save(PedidoModel pedido) {
       return pedidoRepository.save(pedido);
    }

    public PedidoModel save(PedidoDTO pedidoDTO) {
        return pedidoRepository.save(pedidoMapper.pedidoDTOToPedidoModel(pedidoDTO));
    }

    public Optional<PedidoModel> encontrarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Optional<PedidoModel> encontrarPorEstadoYId(@NonNull EstadoPedido estado, Long id) {
        return pedidoRepository.searchForStatusAndId(estado.toString(), id);
    }

    public List<PedidoModel> todosLosPedidos() {
        return pedidoRepository.findAll();
    }
}
