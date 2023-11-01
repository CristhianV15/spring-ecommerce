package com.proyecto.ecommerce.springecommerce.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.ecommerce.springecommerce.models.TipoUsuario;
import com.proyecto.ecommerce.springecommerce.models.Usuario;
import com.proyecto.ecommerce.springecommerce.service.IUsuarioService;

@Controller
@RequestMapping ("/usuario")
public class usuarioController {
    private final Logger logger = LoggerFactory.getLogger(producto.class);

    @Autowired
    private IUsuarioService usuarioService;
   
  
    
    // /usuario / registro
    @GetMapping("/registro")
    public String create(){
        return "usuario/registro";
    }

    //Guardar usuario
    @PostMapping("/save")
    public String save (Usuario usuario)
    {
        TipoUsuario tipoUsuario  = new TipoUsuario();
        tipoUsuario.setIdTipoUsuario(2);

        logger.info("Nombre del cliente : {} ,  contraseña : {}" , usuario.getNombre(), usuario.getPassword());
        usuario.setTelefono("999777111");
        usuario.setTipoUsuario(tipoUsuario);
        usuarioService.save(usuario);
        return "redirect:/";
    }
} 
