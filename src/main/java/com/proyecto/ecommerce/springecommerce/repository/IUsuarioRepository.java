package com.proyecto.ecommerce.springecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.proyecto.ecommerce.springecommerce.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByUsername(String username);

    // Consulta para ver datos de los usuarios y su tipo (nombre en vez de id), para vista de administrador
    @Query("SELECT u, tu.nombre AS tipoUsuarioNombre FROM Usuario u JOIN u.tipoUsuario tu")
    List<Usuario> findAllModificado();
}
