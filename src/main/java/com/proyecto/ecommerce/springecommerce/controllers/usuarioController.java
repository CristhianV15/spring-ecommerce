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

    @GetMapping("/login")
    public String login(){
        return "usuario/login";
    }

    //Guardar usuario
    @PostMapping("/save")
    public String save (Usuario usuario)
    {
        //Por defecto los usuarios que se creen son de tipo cliente es decir tipo "user", el tipo de usuario es 2
        //Se crea una instancia del tipo usuario
        TipoUsuario tipoUsuario  = new TipoUsuario();
        //Se asigna por defecto el tipo de usuario del cliente : 2
        tipoUsuario.setIdTipoUsuario(2);

        //Probando el envio en consola
        logger.info("Nombre del cliente : {} , username : {} , contrasenia : {}" , usuario.getNombre(), usuario.getUsername(), usuario.getPassword());
      
        //Añadiendo el telefono (por mientras)
        usuario.setTelefono("999777111");

        //Añadiendo el tipo de usuario que se creo arriba
        usuario.setTipoUsuario(tipoUsuario);

        //se guardan todos los datos del usuario 
        usuarioService.save(usuario); 
        return "redirect:/";
    }
} 
