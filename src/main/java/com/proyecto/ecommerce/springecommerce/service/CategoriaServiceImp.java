package com.proyecto.ecommerce.springecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.springecommerce.models.Categoria;
import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImp implements ICategoriaService{

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
       return categoriaRepository.findAll();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> get(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public void update(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
    
}
