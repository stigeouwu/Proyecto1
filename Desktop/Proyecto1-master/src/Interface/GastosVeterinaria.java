/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import TipoAnimales.Animal;
import java.time.LocalDate;

/**
 *
 * @author Jose
 */
public class GastosVeterinaria {
    private Animal regisEnVeterinaria;
    private double gastosVeterinaria;
    private LocalDate fechaingre;

    public GastosVeterinaria(Animal regisEnVeterinaria, double gastosVeterinaria, LocalDate fechaingre) {
        this.gastosVeterinaria = gastosVeterinaria;
        this.fechaingre = fechaingre;
        this.regisEnVeterinaria = regisEnVeterinaria;
    }

    public Animal getRegisEnVeterinaria() {
        return regisEnVeterinaria;
    }

    public double getGastosVeterinaria() {
        return gastosVeterinaria;
    }

    public LocalDate getFechaingre() {
        return fechaingre;
    }
    
}
