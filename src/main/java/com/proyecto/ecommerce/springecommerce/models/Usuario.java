package com.proyecto.ecommerce.springecommerce.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List; 


@Data
@Entity
@Table(name= "usuarios") //Anotacion para no usar el nombre de la clase "Usuario"

public class Usuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idUsuario;
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;
    
}