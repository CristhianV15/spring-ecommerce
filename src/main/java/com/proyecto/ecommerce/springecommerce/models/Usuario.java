package com.proyecto.ecommerce.springecommerce.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List; 


@Getter
@Setter
@ToString
@AllArgsConstructor // Genera un constructor con todos los campos
@Entity
@Table(name= "usuarios") //Anotacion para no usar el nombre de la clase "Usuario"

public class Usuario {
    public Usuario(int idUsuario, String nombre, String username, String email, String direccion, String telefono,
            String tipo, String password, String string, String string2) {
    }

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idUsuario;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;

    @OneToMany(mappedBy = "usuario")
    private List<Orden> ordenes;
    
    @ManyToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario;
    
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String password;

   
}