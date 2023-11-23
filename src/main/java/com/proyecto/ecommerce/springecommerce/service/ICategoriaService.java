package com.proyecto.ecommerce.springecommerce.service;

import java.util.List;

import com.proyecto.ecommerce.springecommerce.models.Categoria;

public interface ICategoriaService {
    List<Categoria> findAll();
    Categoria save(Categoria categoria);
}
