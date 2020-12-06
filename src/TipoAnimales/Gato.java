/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipoAnimales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author stige
 */
public class Gato extends Animal {

    public Gato(LocalDate fechaIngreso, String nombre, String raza, String sexo, double peso, int edad, String[] observaciones, int codigo) {
        super(fechaIngreso, nombre, raza, sexo, peso, edad, observaciones, codigo);
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

    @Override
    public double mostrarGastos(){
        double presupuestoMengato = 0;
        if(this.edad>=8){
            presupuestoMengato = presupuestoMengato + 12.5;
        }
        if(this.edad<8){
            presupuestoMengato = presupuestoMengato + 7.5;
                }
        return presupuestoMengato;
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
        final Gato other = (Gato) obj;
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
