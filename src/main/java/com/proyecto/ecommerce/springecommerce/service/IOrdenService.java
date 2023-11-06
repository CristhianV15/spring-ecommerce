package com.proyecto.ecommerce.springecommerce.service;

import java.util.List;

import com.proyecto.ecommerce.springecommerce.models.Orden;
import com.proyecto.ecommerce.springecommerce.models.Usuario;

public interface IOrdenService {
    List<Orden> findAll();
    Orden save(Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario (Usuario usuario);
}
