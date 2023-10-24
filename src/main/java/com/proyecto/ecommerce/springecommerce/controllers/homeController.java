package com.proyecto.ecommerce.springecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.ecommerce.springecommerce.service.ProductoService;

@Controller
@RequestMapping("/")
public class homeController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("") //apunta a la raiz
    public String home(Model model ){
        model.addAttribute("productos", productoService.findAll()); //guardar todos los datos de productos en variable productos
        return "usuario/home";

    }
}
