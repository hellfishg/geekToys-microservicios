package io.geektoys.inventario_service.repository;

import io.geektoys.inventario_service.model.ProductoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductoRepository extends MongoRepository<ProductoModel, String> {

    Optional<ProductoModel> findById(int id); // usamos el ID de negocio, no el de Mongo
}