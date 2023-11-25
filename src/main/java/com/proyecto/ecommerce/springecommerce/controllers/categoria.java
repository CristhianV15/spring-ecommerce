package com.proyecto.ecommerce.springecommerce.controllers;

import java.io.IOException;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.ecommerce.springecommerce.models.Categoria;
import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.models.Usuario;
import com.proyecto.ecommerce.springecommerce.service.ICategoriaService;
import com.proyecto.ecommerce.springecommerce.service.IUsuarioService;

@Controller
@RequestMapping("/categoria")
public class categoria {
    private final Logger logger = LoggerFactory.getLogger(producto.class);

    @Autowired
    private ICategoriaService categoriaService;
   
    @GetMapping("")
    public String home(Model model){
        model.addAttribute("categorias", categoriaService.findAll());
        return "categorias/show";
    }

    @GetMapping("/create")
    public String create() {
        return "categorias/create";
    }
    @PostMapping("/save")
    public String save(Categoria categoria) { 
        logger.info("Objeto categoria: {}", categoria);
        categoria.setEstado("1"); //Estado por defecto 
        categoriaService.save(categoria);
        return "redirect:/categorias";
    }

}
