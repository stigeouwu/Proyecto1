/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import TipoAnimales.Animal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author stige
 */
class Adopccion {
    private Animal animaladop;
    private Adoptante userAdop;
    private int codigo;
    private LocalDate fechaa;
    public Adopccion(Animal animaladop, Adoptante userAdop, int codigo,LocalDate fechaa) {
        this.animaladop = animaladop;
        this.userAdop = userAdop;
        this.codigo = codigo;
        this.fechaa = fechaa;
    }

    

    public Animal getAnimaladop() {
        return animaladop;
    }

    public Adoptante getUserAdop() {
        return userAdop;
    }
    public LocalDate getFechaa() {
        return fechaa;
    }

    public int getcodigo() {
        return codigo;
    }
        
    
    
}
