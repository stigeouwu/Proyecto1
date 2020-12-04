/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipoAnimales;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author stige
 */
public class Perro extends Animal{
    private TamanioPerro tamaño;

    public Perro(TamanioPerro tamaño, LocalDate fechaIngreso, String nombre, String raza, String sexo, double peso, int edad, String[] observaciones, int codigo) {
        super(fechaIngreso, nombre, raza, sexo, peso, edad, observaciones, codigo);
        this.tamaño = tamaño;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public int getEdad() {
        return edad;
    }

    public String[] getObservaciones() {
        return observaciones;
    }

    public int getCodigo() {
        return codigo;
    }

    
    public TamanioPerro getTamaño() {
        return tamaño;
    }


    
    
}
