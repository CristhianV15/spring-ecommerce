package com.proyecto.ecommerce.springecommerce.models;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name= "categorias") //Anotacion para no usar el nombre de la clase "Categoria"

public class Categoria {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idCategoria;
    private String nombre;
    private String estado;
}
