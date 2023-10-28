package com.proyecto.ecommerce.springecommerce.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import com.proyecto.ecommerce.springecommerce.service.UsuarioService;

@Controller
@RequestMapping("/")
public class homeController {
    
    private final Logger log= LoggerFactory.getLogger(homeController.class);
    
    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService;

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
    public String addcart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model){
        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal= 0;
        
        Optional<Producto> optionalProducto= productoService.get(id);
        log.info("Producto añadido {}" + optionalProducto.get());
        log.info("Cantidad de producto {}" + cantidad);
        producto=  optionalProducto.get(); //del producto seleccionado asignarlo a la variable del producto

        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setNombre(producto.getNombre());
        detalleOrden.setTotal(producto.getPrecio()*cantidad);
        detalleOrden.setProducto(producto);        


        //Validacion para no registrar un mismo producto mas de 1 vez 
        Integer idProducto = producto.getIdProducto();
        boolean ingresado= detalles.stream().anyMatch(p -> p.getProducto().getIdProducto()== idProducto);

        if(!ingresado){
            detalles.add(detalleOrden); //añadir cada detalle del orden a la lista 
        }
        
        
        sumaTotal = detalles.stream()
    .mapToDouble(dt -> dt.getTotal()) // Mapea los valores de "total" a un stream de valores dobles
    .sum(); // Calcula la suma de los valores dobles
        
        orden.setTotal(sumaTotal);

        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        return "usuario/carrito";
    }

    //Quitar un producto del carro de compras
    @GetMapping("/delete/cart/{id}")
    public String deleteProducto(@PathVariable Integer id, Model model){
       
        //Lista nueva de productos 
        List <DetalleOrden> ordenesNuevas= new ArrayList<DetalleOrden>();

        for(DetalleOrden detalleOrden: detalles){
            if(detalleOrden.getProducto().getIdProducto()!=id){
                ordenesNuevas.add(detalleOrden);
                
            }
        }
        //lista con los productos restantes:
        detalles= ordenesNuevas;
        
        double sumaTotal= 0;
        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();
        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        return "usuario/carrito";
    }

    @GetMapping("/getCart")
    public String getCart(Model model){
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        return "/usuario/carrito";
    }

    @GetMapping("/order")
    public String order (Model model){
        Usuario usuario= usuarioService.findById(1).get();


        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        model.addAttribute("usuario", usuario);
        return "usuario/resumenorden";
    }

}
