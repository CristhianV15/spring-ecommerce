package com.proyecto.ecommerce.springecommerce.service;

import java.util.Optional;

import com.proyecto.ecommerce.springecommerce.models.Producto;

public interface ProductoService {
    //Metodos CRUD
    public Producto save(Producto producto);
    public Optional<Producto> get(Integer id);
    public void update(Producto producto);
    public void delete(Integer id);
}
