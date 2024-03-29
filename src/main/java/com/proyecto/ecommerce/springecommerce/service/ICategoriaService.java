package com.proyecto.ecommerce.springecommerce.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.ecommerce.springecommerce.models.Categoria;
import com.proyecto.ecommerce.springecommerce.models.Producto;


public interface ICategoriaService {
    List<Categoria> findAll();
    Categoria save(Categoria categoria);
    public Optional<Categoria> get(Integer id);
    void delete (Integer id);
    public void update(Categoria categoria);
    
}
