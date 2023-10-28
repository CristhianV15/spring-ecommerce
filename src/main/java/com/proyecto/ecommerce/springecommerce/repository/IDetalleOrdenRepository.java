package com.proyecto.ecommerce.springecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ecommerce.springecommerce.models.DetalleOrden;

public interface IDetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer> {
    
}
