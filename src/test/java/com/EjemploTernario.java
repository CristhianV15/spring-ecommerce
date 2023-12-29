package com;

public class EjemploTernario {
    public static void main(String[] args) {
        int edad = 17;
        String resultado = (edad > 18) ? "Es mayor de edad" : (edad== 18) ? "Recien es mayor de edad" : "Es menor de edad" ; 
        System.out.println("La edad ingresada = " + edad + ", significa que " + resultado );

        boolean esDiaLaboral = false;
        String actividad = esDiaLaboral ? "Trabajar" : "Descansar";
        System.out.println("La actividad es " + actividad);
        
        String nombre = "Usuario";
        String nombreValidado = (nombre != null) ? nombre : "Invitado";
        System.out.println("El nombre ingresado es " + nombreValidado);

        int puntuacion = 85;
        String mensajeFinal = "Tu puntuación es " + ((puntuacion > 80) ? "alta" : "baja");
        System.out.println("Mensaje Final : " +mensajeFinal);

    }
}