package com.proyecto.ecommerce.springecommerce.controllers;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public String home(Model model) {
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
        categoria.setEstado("1"); // Estado por defecto
        categoriaService.save(categoria);
        return "redirect:/categoria";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Categoria categoria = new Categoria();
        Optional<Categoria> optionalCategoria = categoriaService.get(id);
        categoria = optionalCategoria.get();

        // Mostrar en consola la categoria seleccionada
        logger.info("Categoria buscada mediante edit: {}", categoria);
        model.addAttribute("categoria", categoria); // enviar todo el objeto producto

        return "categorias/edit";
    }

    @PostMapping("/update")
    public String update(Categoria categoria) {
        Categoria c = new Categoria();
        c = categoriaService.get(categoria.getIdCategoria()).get();
        categoria.setIdCategoria(c.getIdCategoria());
        logger.info("ID de la categoria para cambiar {}", categoria.getIdCategoria());
        categoriaService.update(categoria);
        return "redirect:/categoria";
    }

    @PutMapping("/updateEstado/{id}/{nuevoEstado}")
    public ResponseEntity<String> updateEstado(@PathVariable Integer id, @PathVariable Integer nuevoEstado) {
        Optional<Categoria> optionalCategoria = categoriaService.get(id);
        if (optionalCategoria.isPresent()) {
            Categoria categoria = optionalCategoria.get();
            categoria.setEstado(nuevoEstado.toString());
            categoriaService.save(categoria); // Guarda la categoría con el nuevo estado en la base de datos
            return ResponseEntity.ok("Estado actualizado correctamente");
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 si la categoría no se encuentra
        }
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        logger.info("Objeto borrado (idcategoria) {}", id);
        categoriaService.delete(id);
        return "redirect:/categoria";
    }

}
