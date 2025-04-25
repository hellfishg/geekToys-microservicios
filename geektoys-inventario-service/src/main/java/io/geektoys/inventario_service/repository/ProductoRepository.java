package io.geektoys.inventario_service.repository;

import io.geektoys.inventario_service.model.ProductoModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Document
public interface ProductoRepository extends MongoRepository<ProductoModel, String> {
    Optional<ProductoModel> findById(int id); // usamos el ID de negocio, no el de Mongo
    // ⚠️ Si ves que findById te genera conflicto con el ID de Mongo (String), cambiá el nombre a findByIdProducto o algo similar.
}