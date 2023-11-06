package com.proyecto.ecommerce.springecommerce.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ecommerce.springecommerce.models.Orden;
import com.proyecto.ecommerce.springecommerce.models.Usuario;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer>{
   List<Orden> findByUsuario (Usuario usuario);     
}
