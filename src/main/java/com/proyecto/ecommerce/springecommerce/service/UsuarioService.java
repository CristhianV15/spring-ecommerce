package com.proyecto.ecommerce.springecommerce.service;

import java.util.Optional;

import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.models.Usuario;

public interface UsuarioService {
    Optional <Usuario> findById(Integer id);

    // Metodos CRUD (cambiar a usuario lo que diga producto)
    public Producto save(Producto producto);

    public Optional<Producto> get(Integer id);

    public void update(Producto producto);

    public void delete(Integer id);
}
