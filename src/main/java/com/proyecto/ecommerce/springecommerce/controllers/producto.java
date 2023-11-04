package com.proyecto.ecommerce.springecommerce.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.ecommerce.springecommerce.models.Producto;
import com.proyecto.ecommerce.springecommerce.models.Usuario;
import com.proyecto.ecommerce.springecommerce.service.IUsuarioService;
import com.proyecto.ecommerce.springecommerce.service.ProductoService;
import com.proyecto.ecommerce.springecommerce.service.UploadFileService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/productos")
public class producto {

    private final Logger logger = LoggerFactory.getLogger(producto.class);

    //Método para guardar el idUsuario mediante la sesion del usuario
    @ModelAttribute ("idUsuarioOrden")
    public Integer getIdUsuarioOrden (HttpSession session){
        return Integer.parseInt(session.getAttribute("idusuario").toString()); //Se obtiene desde usuarioController
    }

    @Autowired
    private IUsuarioService usuarioService;

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
    public String save(Producto producto, @RequestParam("img") MultipartFile file, @ModelAttribute("idUsuarioOrden") Integer idUsuarioOrden) throws IOException { // busca el
                                                                                                        // atributo img
                                                                                                        // en la vista
                                                                                                        // de
                                                                                                        // create.html
                                                                                                        // -->"name"
        logger.info("Objeto producto: {}", producto);
        Usuario u = usuarioService.findById(idUsuarioOrden).orElse(new Usuario());
        logger.info( "Id del usuaroi loegaod para guardar el producto {}", idUsuarioOrden);
        producto.setUsuario(u);
        


        // Imagen
        if (producto.getIdProducto() == null) { // cuando se crea un producto
            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);

            logger.info("Nombre de la imagen del producto: {}", producto.getImagen());

        } else {

        }
        /*Para probar en la inserccion con un usuario no dinamico 
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1); 
        producto.setUsuario(usuario); */
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();

        // Mostrar en consola el producto seleccionado
        logger.info("Producto buscado: {}", producto);
        model.addAttribute("producto", producto); // enviar todo el objeto producto

        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {

        Producto p = new Producto();
        p = productoService.get(producto.getIdProducto()).get(); // obtener la imagen ya registrada
        if (file.isEmpty()) { // Cuando editamos producto pero no se cambia la imagen
            producto.setImagen(p.getImagen()); // volverla a guardar
        } else { // cambiar imagen cuando se edita el producto
            if (!p.getImagen().equals("default.jpg")) {// borrar cuando no sea la imagen por defecto
                upload.deleteImage(p.getImagen());
            }

            String nombreImagen = upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        producto.setUsuario(p.getUsuario());
        productoService.update(producto);
        
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        // borrar la imagen
        Producto p = new Producto();
        p = productoService.get(id).get();
        if (!p.getImagen().equals("default.jpg")) { // eliminar cuando la imagen no sea la cargada por defecto
            upload.deleteImage(p.getImagen());
        }

        productoService.delete(id);
        return "redirect:/productos";
    }
}
