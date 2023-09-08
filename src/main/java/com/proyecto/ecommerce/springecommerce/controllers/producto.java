package com.proyecto.ecommerce.springecommerce.controllers;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.models.Usuario;
import com.proyecto.ecommerce.springecommerce.repository.UsuarioRepository;
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
    // Aquí puedes realizar alguna validación o procesamiento adicional si es necesario
    Usuario usuario = new Usuario();

    usuario.setIdUsuario(1); // Asigna el ID del usuario que deseas
    producto.setUsuario(usuario);
    productoService.save(producto);
    return "redirect:/productos";
    }
}
