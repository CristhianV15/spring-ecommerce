package com.proyecto.ecommerce.springecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ecommerce.springecommerce.models.Orden;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer>{
        
}
