package com.proyecto.ecommerce.springecommerce.models;
import lombok.Data;

@Data
public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precio;
    private int cantidad; 
}