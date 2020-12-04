/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipoEmpleados;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author stige
 */
public class UserAdmi extends Empleado {
    private String cuentaBancaria;

    public UserAdmi(String cuentaBancaria, String nombre, String cedula, String direccion, String correo, String telefono, LocalDate fecha, double sueldo, String usuario, String contraseña) {
        super(nombre, cedula, direccion, correo, telefono, fecha, sueldo, usuario, contraseña);
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
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

    public LocalDate getFecha() {
        return fecha;
    }
    
    public double getSueldo() {
        return sueldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
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
        final UserAdmi other = (UserAdmi) obj;
        if (!Objects.equals(this.cuentaBancaria, other.cuentaBancaria)) {
            return false;
        }
        if (Double.doubleToLongBits(getSueldo()) != Double.doubleToLongBits(other.getSueldo())) {
            return false;
        }
        if (!Objects.equals(this.getNombre(), other.getNombre())) {
            return false;
        }
        if (!Objects.equals(this.getNombre(), getNombre())) {
            return false;
        }
        if (!Objects.equals(this.getDireccion(), other.getDireccion())) {
            return false;
        }
        if (!Objects.equals(this.getCorreo(), other.getCorreo())) {
            return false;
        }
        if (!Objects.equals(this.getTelefono(), other.getTelefono())) {
            return false;
        }
        if (!Objects.equals(this.getFecha(), other.getFecha())) {
            return false;
        }
        if (!Objects.equals(this.getUsuario(), other.getUsuario())) {
            return false;
        }
        if (!Objects.equals(this.getContraseña(), other.getContraseña())) {
            return false;
        }
        return true;
    }
    
}
