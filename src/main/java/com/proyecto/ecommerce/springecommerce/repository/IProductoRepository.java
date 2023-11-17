package com.proyecto.ecommerce.springecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ecommerce.springecommerce.models.Producto;


@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

  
    
}
