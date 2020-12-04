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
    
    
    public Veterinaria(String nombreV, String numeroContacto, String correo) {
        this.nombreV = nombreV;
        this.numeroContacto = numeroContacto;
        this.correo = correo;
        
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


    public void setNombreV(String nombreV) {
        this.nombreV = nombreV;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
