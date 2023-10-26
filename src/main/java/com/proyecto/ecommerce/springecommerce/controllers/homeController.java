package com.proyecto.ecommerce.springecommerce.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.ecommerce.springecommerce.models.*;
import com.proyecto.ecommerce.springecommerce.service.ProductoService;

@Controller
@RequestMapping("/")
public class homeController {
    
    private final Logger log= LoggerFactory.getLogger(homeController.class);
    
    @Autowired
    private ProductoService productoService;

    //Para almacenar los detalles de la orden 
    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    //Datos de la orden
    Orden orden =new Orden();
    @GetMapping("") //apunta a la raiz
    public String home(Model model ){
        model.addAttribute("productos", productoService.findAll()); //guardar todos los datos de productos en variable productos
        return "usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Integer id, Model model){
        log.info("IdProducto enviado como parametro (vista cliente pag principal a detalle): {}", id );
        Producto producto = new Producto();
        Optional<Producto> productoOptional = productoService.get(id);
        producto = productoOptional.get();

        //Enviar lo del producto a la vista 
        model.addAttribute("producto", producto); //"variable en vista", variable del metodo 
        return "usuario/productohome";
    }

    @GetMapping("/cart")
    public String addcart(@RequestParam Integer id, @RequestParam Integer cantidad){
        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal= 0;
        
        Optional<Producto> optionalProducto= productoService.get(id);
        log.info("Producto añadido {}" + optionalProducto.get());
        log.info("Cantidad de producto {}" + cantidad);
        return "usuario/carrito";
    }
}
