package com.proyecto.ecommerce.springecommerce.models;
import lombok.Data;
import jakarta.persistence.*;
@Data
@Entity
@Table(name= "productos") //Anotacion para no usar el nombre de la clase "Producto"

public class Producto {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
    private int cantidad; 
    private int estado;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}