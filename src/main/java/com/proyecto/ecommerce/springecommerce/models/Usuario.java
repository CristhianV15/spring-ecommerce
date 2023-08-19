package com.proyecto.ecommerce.springecommerce.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List; 


@Data
@AllArgsConstructor // Genera un constructor con todos los campos
@Entity
@Table(name= "usuarios") //Anotacion para no usar el nombre de la clase "Usuario"

public class Usuario {
    public Usuario(int idUsuario2, String nombre2, String username2, String email2, String direccion2, String telefono2,
            String tipo2, String password2, String string, String string2) {
    }

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