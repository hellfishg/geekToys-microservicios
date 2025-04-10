package io.geekToys.geektoys_pedido_service.repository;

import io.geekToys.geektoys_pedido_service.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {

    // Consulta nativa para PostgreSQL.
    @Query(value = "SELECT * FROM pedidos WHERE estado = :estado AND id = :id", nativeQuery = true)
    Optional<PedidoModel> searchForStatusAndId(@Param("estado") String estado, @Param("id") Long id);

    @Query(value = "SELECT * FROM pedidos WHERE estado IN (:estados)", nativeQuery = true)
    List<PedidoModel> findByEstados(@Param("estados") List<String> estados);

}

