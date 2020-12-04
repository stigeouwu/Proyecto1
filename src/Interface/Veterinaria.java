/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import TipoAnimales.Animal;

/**
 *
 * @author stige
 */
class Veterinaria {
    private String nombreV;
    private String numeroContacto;
    private String correo;
    private String fechaAtencion;
    private double gastos;
    private Animal animalAtendido;

    public Veterinaria(String nombreV, String numeroContacto, String correo, String fechaAtencion, double gastos, Animal animalAtendido) {
        this.nombreV = nombreV;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
        this.fechaAtencion = fechaAtencion;
        this.gastos = gastos;
        this.animalAtendido = animalAtendido;
    }
    
    public String getNombreV() {
        return nombreV;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public double getGastos() {
        return gastos;
    }

    public Animal getAnimalAtendido() {
        return animalAtendido;
    }

    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public void setGastos(double gastos) {
        this.gastos = gastos;
    }

    public void setAnimalAtendido(Animal animalAtendido) {
        this.animalAtendido = animalAtendido;
    }
}
