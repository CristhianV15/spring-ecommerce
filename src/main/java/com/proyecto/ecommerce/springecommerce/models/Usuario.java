package com.proyecto.ecommerce.springecommerce.models;
import lombok.Data;

@Data
public class Usuario {
    private Integer id;
    private String nombre;
    private String username;
    private String email;
    private String direccion;
    private String telefono;
    private String tipo;
    private String password;
}