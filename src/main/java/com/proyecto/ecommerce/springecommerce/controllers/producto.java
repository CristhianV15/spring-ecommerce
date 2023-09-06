package com.proyecto.ecommerce.springecommerce.controllers;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.models.Usuario;
import com.proyecto.ecommerce.springecommerce.service.ProductoService;


@Controller
@RequestMapping("/productos")
public class producto {

    private final Logger logger = LoggerFactory.getLogger(producto.class);
    
    @Autowired
    private ProductoService productoService;
    
    
    @GetMapping("")
    public String show(){
        return "productos/show";
    }

    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto){
        logger.info("Objeto producto: {}", producto);
        Usuario u = new Usuario(1, "", "", "", "", "", "", "", "", "");
        Usuario u2 = new Usuario(1, "", "", "", "", "", "", "", "", "");
        productoService.save(producto);
        return "redirect:/productos";
    }
}
