package com.proyecto.ecommerce.springecommerce.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.service.IUsuarioService;
import com.proyecto.ecommerce.springecommerce.service.ProductoService;

@Controller
@RequestMapping("/administrador")
public class administrador {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("")
    public String home(Model model)
    {
        List<Producto> productos= productoService.findAll();
        model.addAttribute("productos", productos);

        return "administrador/home";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model){
        model.addAttribute("usuarios", usuarioService.findAll());
        return "administrador/usuarios";
    }
}
