package com.proyecto.ecommerce.springecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.springecommerce.models.Orden;
import com.proyecto.ecommerce.springecommerce.repository.IOrdenRepository;

@Service
public class OrdenServiceImp implements IOrdenService {
    @Autowired
    private IOrdenRepository orderRepository;
    
    @Override
    public Orden save(Orden orden) {
        return orderRepository.save(orden);
    }
    
}
