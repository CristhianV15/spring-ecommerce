package com.proyecto.ecommerce.springecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.ecommerce.springecommerce.models.Usuario;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer>{
    
}
