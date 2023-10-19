package com.proyecto.ecommerce.springecommerce.controllers;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.models.Usuario;

import com.proyecto.ecommerce.springecommerce.service.ProductoService;
import com.proyecto.ecommerce.springecommerce.service.UploadFileService;

@Controller
@RequestMapping("/productos")
public class producto {

    private final Logger logger = LoggerFactory.getLogger(producto.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UploadFileService upload;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
		return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException { //busca el atributo img en la vista de create.html -->"name"
        logger.info("Objeto producto: {}", producto);
        // Aquí puedes realizar alguna validación o procesamiento adicional si es
        // necesario
        Usuario usuario = new Usuario();

        //Imagen 
        if(producto.getIdProducto()==null){ //cuando se crea un producto
            String nombreImagen= upload.saveImage(file);
            producto.setImagen(nombreImagen);
        } else {
            if(file.isEmpty()){ //Cuando editamos producto pero no se cambia la imagen 
                Producto p = new Producto();
                p= productoService.get(producto.getIdProducto()).get(); //obtener la imagen ya registrada
                producto.setImagen(p.getImagen()); //volverla a guardar
            }else{ //cambiar imagen cuando se edita el producto
                String nombreImagen= upload.saveImage(file);
                producto.setImagen(nombreImagen);
            }
        }

        usuario.setIdUsuario(1); // Id Usuario existente    
        producto.setUsuario(usuario);
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto producto= new Producto();
		Optional<Producto> optionalProducto=productoService.get(id);
		producto= optionalProducto.get();
		
        //Mostrar en consola el producto seleccionado 
		logger.info("Producto buscado: {}",producto);
        model.addAttribute("producto", producto); //enviar todo el objeto producto
		
		return "productos/edit";
	}

    @PostMapping("/update")
    public String update(Producto producto){
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productoService.delete(id);
        return "redirect:/productos";
    }
}
