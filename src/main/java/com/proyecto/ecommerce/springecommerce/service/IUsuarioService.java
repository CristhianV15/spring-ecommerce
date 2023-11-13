package com.proyecto.ecommerce.springecommerce.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.models.Usuario;

public interface IUsuarioService {
    Optional <Usuario> findById(Integer id);

    //Metodos CRUD de la tabla de usuarios 
    public Usuario save(Usuario usuario);

    public Optional<Usuario> get(Integer id);

    public void update(Usuario usuario);

    public void delete(Integer id);

    List<Usuario> findAll();
    
    Optional <Usuario> findByEmail(String email);
}
