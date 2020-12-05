/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipoAnimales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author stige
 */
public class Animal {
    
    protected LocalDate fechaIngreso;
    protected String nombre;
    protected String raza;
    protected String sexo;
    protected double peso;
    protected int edad;
    protected String[]observaciones;
    protected int codigo;

    public Animal(LocalDate fechaIngreso, String nombre, String raza, String sexo, double peso, int edad, String[] observaciones, int codigo) {
        this.fechaIngreso = fechaIngreso;
        this.nombre = nombre;
        this.raza = raza;
        this.sexo = sexo;
        this.peso = peso;
        this.edad = edad;
        this.observaciones = observaciones;
        this.codigo = codigo;
    }
    public double mostrarGastos(){
        return 0.0;
    }

    

    

    

    
}
