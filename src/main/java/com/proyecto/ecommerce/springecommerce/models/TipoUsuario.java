package com.proyecto.ecommerce.springecommerce.models;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name= "tiposUsuarios") //Anotacion para no usar el nombre de la clase "tipousuario"

public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idTipoUsuario;
    private String nombre;
    private String estado;
}
