package io.geekToys.geektoys_pedido_service.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.geekToys.geektoys_pedido_service.DTO.PedidoDTO;
import io.geekToys.geektoys_pedido_service.DTO.ProductoDTO;
import io.geekToys.geektoys_pedido_service.model.PedidoModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PedidoMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public PedidoModel pedidoDTOToPedidoModel(PedidoDTO dto) {
        PedidoModel model = new PedidoModel();
        model.setId(dto.getId());
        model.setClienteId(dto.getClienteId());

        try {
            model.setItems(objectMapper.writeValueAsString(dto.getItems()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.setTotal(dto.getTotal());
        model.setDireccionEnvio(dto.getDireccionEnvio());
        model.setMetodoPago(dto.getMetodoPago());
        model.setCanalVentas(dto.getCanalVentas());
        model.setEstadoPedido(dto.getEstadoPedido());
        model.setFechaCreacion(dto.getFechaCreacion());
        model.setFechaActualizacion(dto.getFechaActualizacion());

        return model;
    }

    public PedidoDTO pedidoModelToPedidoDTO(PedidoModel model) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(model.getId());
        dto.setClienteId(model.getClienteId());

        try {
            dto.setItems(objectMapper.readValue(model.getItems(), new TypeReference<List<ProductoDTO>>() {}));
        } catch (Exception e) {
            e.printStackTrace();
        }

        dto.setTotal(model.getTotal());
        dto.setDireccionEnvio(model.getDireccionEnvio());
        dto.setMetodoPago(model.getMetodoPago());
        dto.setCanalVentas(model.getCanalVentas());
        dto.setEstadoPedido(model.getEstadoPedido());
        dto.setFechaCreacion(model.getFechaCreacion());
        dto.setFechaActualizacion(model.getFechaActualizacion());

        return dto;
    }
}
