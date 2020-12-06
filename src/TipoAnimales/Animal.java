/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipoAnimales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.raza, other.raza)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.fechaIngreso, other.fechaIngreso)) {
            return false;
        }
        if (!Arrays.deepEquals(this.observaciones, other.observaciones)) {
            return false;
        }
        return true;
    }

    
    
    

    

    
}
