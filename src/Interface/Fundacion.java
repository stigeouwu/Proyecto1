/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import TipoAnimales.Animal;
import TipoAnimales.*;
import TipoEmpleados.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

/**
 *
 * @author stige
 */
public class Fundacion {
    private  ArrayList<Veterinaria> veterinarias;
    private  ArrayList<Empleado> empleados;
    private  ArrayList<Adoptante> adoptantes;
    private  ArrayList<Animal> animalesTotal;
    private  ArrayList<Animal> animalesEnAdopccion;
    private  ArrayList<Animal> animalesAdoptados;
    private  ArrayList<Adoptante> userRegistrados;
    private  ArrayList<Adopccion> registroAdop;

    public Fundacion() {
        this.veterinarias = new ArrayList();
        this.empleados = new ArrayList();
        this.adoptantes = new ArrayList();
        this.animalesEnAdopccion = new ArrayList();
        this.animalesAdoptados = new ArrayList();
        this.animalesTotal = new ArrayList();
        this.userRegistrados = new ArrayList();
        this.registroAdop = new ArrayList();
    }
    
    
    public Empleado consultarEmple(String user, String pass){
        Empleado e0 = null;
        for(Empleado e: empleados){
            if(e instanceof UserFun){
                UserFun uf = (UserFun)e;
                if(user.equals(uf.getUsuario()) && pass.equals(uf.getContraseña())){
                     return e;
                }
            }
            if(e instanceof UserAdmi){
                UserAdmi ud = (UserAdmi)e;
                if(user.equals(ud.getUsuario()) && pass.equals(ud.getContraseña())){
                     return e;
                }       
            }
        }
        return e0;
    }
    public void AgragarEmpleado(Empleado e){
        this.empleados.add(e);
    }
    public boolean consultarUser(String user){
        for(Empleado e: this.empleados){
            if(e instanceof UserFun){
                UserFun uf = (UserFun)e;
                if(user.equals(uf.getUsuario())){
                     return true;
                }
            }
            if(e instanceof UserAdmi){
                UserAdmi ud = (UserAdmi)e;
                if(user.equals(ud.getUsuario())){
                     return true;
                }      
            }
        }
        return false;
    }
    public boolean IngresarUser(String user, String pass){
        for(Empleado e: this.empleados){
            if(e instanceof UserFun){
                UserFun uf = (UserFun)e;
                if(user.equals(uf.getUsuario()) && pass.equals(uf.getContraseña())){
                     return false;
                }
            }
            if(e instanceof UserAdmi){
                UserAdmi ud = (UserAdmi)e;
                if(user.equals(ud.getUsuario()) && pass.equals(ud.getContraseña())){
                     return false;
                }      
            }
        }
        return true;
    }
    public void agragarAni(Animal a){
        this.animalesTotal.add(a);
    }
    public void  agregarAnimalGato(String nombre, String raza, String sexo, double peso, int edad, String[] observaciones){
        int ulNum = this.animalesTotal.size() -1;
        int num = 0;
        LocalDate hoy = LocalDate.now();
        if(this.animalesTotal.get(ulNum) instanceof Gato){
            Animal a = this.animalesTotal.get(ulNum);
            Gato g0 = (Gato)a; 
            num = num + g0.getCodigo();
        } 
        if(this.animalesTotal.get(ulNum) instanceof Perro){
            Animal a = this.animalesTotal.get(ulNum);
            Perro p0 = (Perro)a; 
            num = num +p0.getCodigo();
        }
        Animal a = new Gato(hoy,nombre,raza,sexo,peso,edad,observaciones, num +1);
        this.animalesTotal.add(a);
        this.animalesEnAdopccion.add(a);
    }
    public void agregarAnimalPerro(String nombre, String raza, String sexo, double peso, int edad, String[] observaciones,TamanioPerro t){
        int ulNum = this.animalesTotal.size() -1;
        int num = 0;
        LocalDate hoy = LocalDate.now();
        if(this.animalesTotal.get(ulNum) instanceof Gato){
            Animal a = this.animalesTotal.get(ulNum);
            Gato g0 = (Gato)a; 
            num = num + g0.getCodigo();
        } 
        if(this.animalesTotal.get(ulNum) instanceof Perro){
            Animal a = this.animalesTotal.get(ulNum);
            Perro p0 = (Perro)a; 
            num = num +p0.getCodigo();
        }
        Perro p = new Perro(t,hoy,nombre,raza,sexo,peso,edad,observaciones, num +1);
        this.animalesTotal.add(p);
        this.animalesEnAdopccion.add(p);
    }
    public ArrayList<Animal> consultarAnimales(String animal, String sexo, String raza ){
        ArrayList<Animal> consulta = new ArrayList<>();
        for (Animal a: this.animalesEnAdopccion){
            if(animal.equals("gato")){
                if(a instanceof Gato){
                    Gato g = (Gato)a;
                    if(sexo.equals(g.getSexo())){
                        if(raza.equals(g.getRaza())){
                            consulta.add(a);
                        }
                        else if(raza.equals("nada")){
                            consulta.add(a);
                        }
                        
                    }
                    else if(sexo.equals("nada")){
                        if(raza.equals(g.getRaza())){
                            consulta.add(a);
                        }
                        else if(raza.equals("nada")){
                            consulta.add(a);
                        }
                    }
                }
            }
            else if(animal.equals("perro")){
                if(a instanceof Perro){
                    Perro g = (Perro)a;
                    if(sexo.equals(g.getSexo())){
                        if(raza.equals(g.getRaza())){
                            consulta.add(a);
                        }
                        else if(raza.equals("nada")){
                            consulta.add(a);
                        }
                        
                    }
                    else if(sexo.equals("nada")){
                        if(raza.equals(g.getRaza())){
                            consulta.add(a);
                        }
                        else if(raza.equals("nada")){
                            consulta.add(a);
                        }
                    }
                }
            }
            else if(animal.equals("nada")){
                if(a instanceof Gato){
                    Gato g = (Gato)a;
                    if(sexo.equals(g.getSexo())){
                        if(raza.equals(g.getRaza())){
                            consulta.add(a);
                        }
                        else if(raza.equals("nada")){
                            consulta.add(a);
                        }
                        
                    }
                    else if(sexo.equals("nada")){
                        if(raza.equals(g.getRaza())){
                            consulta.add(a);
                        }
                        else if(raza.equals("nada")){
                            consulta.add(a);
                        }
                    }
                }
                else if(a instanceof Perro){
                    Perro g = (Perro)a;
                    if(sexo.equals(g.getSexo())){
                        if(raza.equals(g.getRaza())){
                            consulta.add(a);
                        }
                        else if(raza.equals("nada")){
                            consulta.add(a);
                        }
                        
                    }
                    else if(sexo.equals("nada")){
                        if(raza.equals(g.getRaza())){
                            consulta.add(a);
                        }
                        else if(raza.equals("nada")){
                            consulta.add(a);
                        }
                    }
                }
            }
        }
        return consulta;
    }
    public String arregloObs(String[] s){
        String str = "[";
        if(s.length == 0){
            str = str + "]";
        }
        else if(s.length == 1){
            str = str + s[0] + "]";
        }
        else if(s.length > 1){
            for (int i = 0; i < s.length; ++i) {
                if(i == s.length-1){
                    str = str + s[s.length-1] +  "]";
                }
                else if(i<s.length-1){
                    str = str + s[i] + ",";
                }
            }
        }
        return str;
    }
    
    public String imprimirListaAni(ArrayList<Animal> a0){
        String strList = ""; 
        ArrayList<String> imprimir = new ArrayList<>();
        imprimir.add("Fecha de ingreso");
        imprimir.add("Nombre de raza");
        imprimir.add("Peso");
        imprimir.add("edad");
        imprimir.add("tamaño");
        imprimir.add("observaciones");
        for(Animal at: a0){
            if(at instanceof Gato){
                Gato g = (Gato)at;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                String formattedString = g.getFechaIngreso().format(formatter);
                imprimir.add(formattedString);
                imprimir.add(g.getNombre());
                String cadena = String.valueOf(g.getPeso());
                imprimir.add(cadena);
                String numero = Integer.toString(g.getEdad());
                imprimir.add(numero);
                imprimir.add("No Tamaño");
                imprimir.add(this.arregloObs(g.getObservaciones()));             
            }    
            if(at instanceof Perro){
                Perro p = (Perro)at;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                String formattedString = p.getFechaIngreso().format(formatter);
                imprimir.add(formattedString);
                imprimir.add(p.getNombre());
                String cadena = String.valueOf(p.getPeso());
                imprimir.add(cadena);
                String numero = Integer.toString(p.getEdad());
                imprimir.add(numero);
                imprimir.add(p.getTamaño().name());
                imprimir.add(this.arregloObs(p.getObservaciones()));       
            }
        }
        String v1 = "" ,v2= "",v3= "",v4= "",v5= "",v6 = "";
        String retornar = "";
        int count = 1;
        for (int i = 0; i < imprimir.size(); ++i) {
             if(count == 1){
                 v1 = imprimir.get(i);
                 count = count + 1;
             }
             else if(count == 2){
                 v2 = imprimir.get(i);
                 count = count + 1;
             }
             else if(count == 3){
                 v3 = imprimir.get(i);
                 count = count + 1;
             }
             else if(count == 4){
                 v4 = imprimir.get(i);
                 count = count + 1;
             }
             else if(count == 5){
                 v5 = imprimir.get(i);
                 count = count + 1;
             }
             else if(count == 6){
                 v6 = imprimir.get(i);
                 if(i == 5){
                    String cadena = "%s         %s          %s            %s             %s         %s\n";
                    strList = String.format(cadena,v1,v2,v3,v4,v5,v6);
                    retornar = retornar + strList;
                    count = 1;
                 }
                 else{
                    String cadena = "%s         %s                    %s              %s            %s          %s\n";
                    strList = String.format(cadena,v1,v2,v3,v4,v5,v6);
                    retornar = retornar + strList;
                    count = 1;
                 }
                 
             }
             
//            if(i<=6){
//                strList = strList + imprimir.get(i) + "       ";
//                count = count +1;
//            }
//            else if(i >6){
//                strList = strList + imprimir.get(i) + "           ";
//                count = count +1;
//            }
//            if(count == 6){
//               count = 0;
//               strList= strList + "\n";
//            }
            
        }
        
        return retornar;
    }
    public boolean ValidarCliente(String cedula){
        for( Adoptante ap: this.userRegistrados ){
            if(cedula.equals(ap.getCedula())){
                return true;
            }
        }
        return false;
    }
    public boolean ValidarAnimal(int codigo){
        for( Animal an: this.animalesAdoptados ){
            if(an instanceof Gato){
                Gato g = (Gato)an;
                if(codigo == g.getCodigo()){
                return true;
                }
            }
            if(an instanceof Perro){
                Perro p = (Perro)an;
                if(codigo == p.getCodigo()){
                return true;
                }
            }
            
        }
        return false;
    }
    public Adoptante buscarAdop(String cedula){
        Adoptante a0 = null;
        for(Adoptante a: this.userRegistrados){
            if(cedula.equals(a.getCedula())){
                a0= a;
            }
        }
        return a0;
    }
    public Animal buscarAni(int codigo){
        Animal a0 = null;
        for(Animal a: this.animalesEnAdopccion){
            if(a instanceof Gato){
                Gato g = (Gato)a;
                if(codigo == g.getCodigo()){
                    a0= a;
                    
                }
            }
            if(a instanceof Perro){
                Perro p = (Perro)a;
                if(codigo == p.getCodigo()){
                    a0= a;
                    
                }
            }
        }
        return a0;
    }
    public void registrarAdop(Adoptante ad, Animal ani){
        int ulNum = this.registroAdop.size() -1;
        int num = 0;
        LocalDate adhoy = LocalDate.now();
        Adopccion adopex = this.registroAdop.get(ulNum);
        num = num + adopex.getcodigo();
        Adopccion a = new Adopccion(ani,ad, num +1,adhoy);
        this.registroAdop.add(a);
    }
    public ArrayList<Adopccion> voltearLista(){
        ArrayList<Adopccion> nwlist= new ArrayList();
        int numli = this.registroAdop.size()-1;
        for(Adopccion adon: this.registroAdop){
            nwlist.add(this.registroAdop.get(numli));
            numli = numli -1;
        }
        return nwlist;
    }
    public String devolverConsulta(){
        
        String var = "";
        for(Adopccion ada: this.voltearLista()){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            String formattedString = ada.getFechaa().format(formatter);
            String numeroadop = Integer.toString(ada.getcodigo());
            String numeroani = "";
            Animal aAdop = ada.getAnimaladop();
            if(aAdop instanceof Gato){
                Gato g1 = (Gato)aAdop;
                numeroani = Integer.toString(g1.getCodigo());
            }
            if(aAdop instanceof Perro){
                Perro p = (Perro)aAdop;
                numeroani = Integer.toString(p.getCodigo());
            }
            String cade = "CodigoAdop: %s   Fecha de ingreso: %s    codigoAni: %s   CedulaPer: %s    NombrePer: %s\n";
            var = var + String.format(cade,numeroadop,formattedString,numeroani,ada.getUserAdop().getCedula(),ada.getUserAdop().getNombre());
        }
        return var;
    }
    public String mostrarUser(){
        String var = "";
        for(Adoptante adex: this.userRegistrados){
            int count = 0;
            for(Adopccion adopani: this.registroAdop){
                if(adex.getCedula().equals(adopani.getUserAdop().getCedula())){
                    count = count +1;
                }
            }
            String numeroadop = Integer.toString(count);
            String cade = "Cedula del usuario: %s   Nombre del usuario: %s    Numero de animales adoptados: %s\n";
            var = var + String.format(cade,adex.getCedula(),adex.getNombre(),numeroadop);
        }
        return var;
    }
    public String  Mostardatos(String cedul){
        String var = "";
        String tipoani = "";
        String numeroadop = "";
        int count = 0;
        String sexo = "";
        String fecha = "";
        String formattedString = "";
        for(Adoptante adexp : this.userRegistrados){
            if(cedul.equals(adexp.getCedula())){
                String cade = "Nombre: %s        Cedula: %s        Direccion: %s        correo: %s        Telefono %s\n";
                var = var + String.format(cade,adexp.getNombre(),adexp.getCedula(),adexp.getDireccion(),adexp.getCorreo(),adexp.getTelefono());
                for(Adopccion adopani: this.registroAdop){
                    if(cedul.equals(adopani.getUserAdop().getCedula())){
                        if(adopani.getAnimaladop() instanceof Gato){
                            tipoani = "Gato";
                            Animal a0 = adopani.getAnimaladop();
                            Gato g1 = (Gato)a0;
                            numeroadop = Integer.toString(g1.getCodigo());
                            sexo = g1.getSexo();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                            formattedString = g1.getFechaIngreso().format(formatter);
                        }
                        if(adopani.getAnimaladop() instanceof Perro){
                            tipoani = "perro";
                            Animal a0 = adopani.getAnimaladop();
                            Perro p1 = (Perro)a0;
                            numeroadop = Integer.toString(p1.getCodigo());
                            sexo = p1.getSexo();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                            formattedString = p1.getFechaIngreso().format(formatter);
                            
                        }
                        String cadeani = "Codigo del animal: %s        tipo: %s        Sexo: %s        Fecha de adopccion: %s \n";
                        
                        var = var + String.format(cadeani,numeroadop,tipoani,sexo,formattedString);
                }
            }
            }
        }
        return var;
    }
    public void modificarUsser(String nombre, String direccion, String telefono, String correo, String cedula){
        for(Adoptante adomod: this.userRegistrados){
            if(cedula.equals(adomod.getCedula())){
                adomod.setNombre(nombre);
                adomod.setDireccion(direccion);
                adomod.setTelefono(telefono);
                adomod.setCorreo(correo);  
            }
        }
        
    }
    public ArrayList<Veterinaria> getVeterinarias() {
        return veterinarias;
    }
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Adoptante> getAdoptantes() {
        return adoptantes;
    }

    public ArrayList<Animal> getAnimalesTotal() {
        return animalesTotal;
    }

    public ArrayList<Animal> getAnimalesEnAdopccion() {
        return animalesEnAdopccion;
    }

    public ArrayList<Animal> getAnimalesAdoptados() {
        return animalesAdoptados;
    }

    public ArrayList<Adoptante> getUserRegistrados() {
        return userRegistrados;
    }

    public ArrayList<Adopccion> getRegistroAdop() {
        return registroAdop;
    }
    
    
}
