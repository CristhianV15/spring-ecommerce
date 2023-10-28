package com.proyecto.ecommerce.springecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ecommerce.springecommerce.models.DetalleOrden;
import com.proyecto.ecommerce.springecommerce.repository.IDetalleOrdenRepository;

@Service
public class DetalleOrdenServiceImp implements IDetalleOrdenService {

    @Autowired
    private IDetalleOrdenRepository detalleOrdenRepository;

    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }
    
}
