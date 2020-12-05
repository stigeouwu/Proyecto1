/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author stige
 */
public class Adoptante {
    private String nombre;
    private String cedula;
    private String direccion;
    private String correo;
    private String telefono;
    private int animelesAdoptados;
    private String tipoDeanimal;
    private String razaDelAnimal;
    private String sexoDelAnimal;


    public Adoptante(String nombre, String cedula, String direccion, String correo, String telefono, String tipoDeanimal, String razaDelAnimal, String sexoDelAnimal) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoDeanimal = tipoDeanimal;
        this.razaDelAnimal = razaDelAnimal;
        this.sexoDelAnimal = sexoDelAnimal;
    }

    public String getRazaDelAnimal() {
        return razaDelAnimal;
    }
      
    

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getAnimelesAdoptados() {
        return animelesAdoptados;
    }

    public String getTipoDeanimal() {
        return tipoDeanimal;
    }

    public String getSexoDelAnimal() {
        return sexoDelAnimal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipoDeanimal(String tipoDeanimal) {
        this.tipoDeanimal = tipoDeanimal;
    }

    public void setRazaDelAnimal(String razaDelAnimal) {
        this.razaDelAnimal = razaDelAnimal;
    }

    public void setSexoDelAnimal(String sexoDelAnimal) {
        this.sexoDelAnimal = sexoDelAnimal;
    }

    
}
