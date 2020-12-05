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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author stige
 */
public class Fundacion {
    private  ArrayList<Veterinaria> veterinarias;
    private  ArrayList<Empleado> empleados;
    private  ArrayList<Animal> animalesTotal;
    private  ArrayList<Animal> animalesEnAdopccion;
    private  ArrayList<Animal> animalesAdoptados;
    private  ArrayList<Adoptante> userRegistrados;
    private  ArrayList<Adopccion> registroAdop;
    private  ArrayList<GastosVeterinaria> gastosv;

    public Fundacion() {
        this.veterinarias = new ArrayList();
        this.empleados = new ArrayList();
        this.animalesEnAdopccion = new ArrayList();
        this.animalesAdoptados = new ArrayList();
        this.animalesTotal = new ArrayList();
        this.userRegistrados = new ArrayList();
        this.registroAdop = new ArrayList();
        this.gastosv = new ArrayList();
    }
    
    public void inicializar(){
        LocalDate hoy = LocalDate.now();
        Veterinaria v0 = new Veterinaria("Veterinaria pablito","095578412","mega1xdxdxd@gmail.com");
        this.getVeterinarias().add(v0);
        TamanioPerro t1 = TamanioPerro.valueOf("GRANDE");
        TamanioPerro t2 = TamanioPerro.valueOf("MEDIANO");
        TamanioPerro t3 = TamanioPerro.valueOf("PEQUEÑO");
        String[] obser1 = new String[2];
        obser1[0] = "bonito";
        obser1[1] ="gordito";
        Animal a1 = new Perro(t1,hoy,"Boby", "MESTIZO", "MACHO", 15.5, 1,obser1, 1);
        Animal a2 = new Perro(t2,hoy,"Firu", "PUG", "HEMBRA", 13.5, 1,obser1, 2);
        Animal a3 = new Perro(t3,hoy,"Neil", "PUGGLE", "MACHO", 14.5, 1,obser1, 3);
        this.getAnimalesEnAdopccion().add(a1);
        this.getAnimalesEnAdopccion().add(a2);
        this.getAnimalesEnAdopccion().add(a3);
        String[] obser = new String[2];
        obser[0] = "grande";
        obser[1] ="gordito";
        Animal a4 = new Gato(hoy,"michu", "MESTIZO", "Macho", 8.5, 1, obser, 4);
        Animal a5 = new Gato(hoy,"coco", "PERSA", "HEMBRA", 8.5, 1, obser, 5);
        Animal a6 = new Gato(hoy,"ninu", "PERSA", "HEMBRA", 8.5, 1, obser, 6);
        this.getAnimalesAdoptados().add(a1);
        this.getAnimalesTotal().add(a1);
        this.getAnimalesTotal().add(a2);
        this.getAnimalesTotal().add(a3);
        this.getAnimalesTotal().add(a4);
        this.getAnimalesTotal().add(a5);
        this.getAnimalesTotal().add(a6);
        Adoptante adop0 = new Adoptante("Stiven", "09557","jardines","sgquinde@espol.edu.ec","04234","gato","PERSA","MACHO");
        Adoptante adopexp = new Adoptante("juan", "09558","jardines","mega3xdxdxd@gmail.com","04785","perro","MESTIZO","HEMBRA");
        this.getUserRegistrados().add(adop0);
        this.getUserRegistrados().add(adopexp);
        Adopccion adoexp = new Adopccion(a5,adop0,1,hoy);
        Adopccion adoexp2 = new Adopccion(a4,adopexp,2,hoy);
        Empleado e1 = new UserFun("Carlos", "0997852", "jardines", "asda@xd", "045826", hoy, 400, "carlosj", "xdxd");
        Empleado e2 = new UserAdmi("0898753","Francisco", "098632", "puerto azul", "mega4xdxdxd@gmailc.com", "047589", hoy, 600.50, "fracniscop", "123456");
        this.empleados.add(e2);
        this.empleados.add(e1);
        this.registroAdop.add(adoexp);
        this.registroAdop.add(adoexp2);
        
        GastosVeterinaria gastV = new GastosVeterinaria(a5,24.5,hoy);
        this.gastosv.add(gastV);
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
    public String consultarVete(){
        String varv = "";
        for(Veterinaria v: this.veterinarias){
            String cadeani = "Nombre de veterinaria: %s        Numero de contacto de la veterinaria: %s        correo de la veterinaria: %s\n";
            varv = varv + String.format(cadeani,v.getNombreV(),v.getNumeroContacto(),v.getCorreo());
        }
        return varv;
    }
    public Animal consultarAni(int codigo){
        Animal aexpv = null;
        for(Animal av: this.animalesTotal){
            if(av instanceof Gato){
            Gato g0 = (Gato)av; 
                if(codigo == g0.getCodigo()){
                    return av;
                }
            } 
            if(av instanceof Perro){;
            Perro p0 = (Perro)av;
                if(codigo == p0.getCodigo()){
                    return av;
                }
            }
        }
        return aexpv;
    }
    public String consultargastos(){
        String varv = "";
        String formattedString = "";
        String nombreaniv = "";
        String codigoaniv ="";
        for(GastosVeterinaria v: this.gastosv){
            String cadeani = "Fecha de la consulta: %s        Gastos del animal: %s        Nombre del animal: %s Codigo del animal: %s\n";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
            formattedString = v.getFechaingre().format(formatter);
            String cadenadou = String.valueOf(v.getGastosVeterinaria());
            if(v.getRegisEnVeterinaria() instanceof Gato){
                Animal aexveti = v.getRegisEnVeterinaria();
                Gato gexv = (Gato)aexveti;
                nombreaniv = gexv.getNombre();
                codigoaniv = Integer.toString(gexv.getCodigo());
            }
            if(v.getRegisEnVeterinaria() instanceof Perro){
                Animal aexveti = v.getRegisEnVeterinaria();
                Perro pexv = (Perro)aexveti;
                nombreaniv = pexv.getNombre();
                codigoaniv = Integer.toString(pexv.getCodigo());
            }
            varv = varv + String.format(cadeani,formattedString,cadenadou,nombreaniv,codigoaniv);
        }
        return varv;
        
    }
    
    public String consultarGastosmen(){
        String var = "";
        double presupuestoMenEm = 0;
        double presupuestoMengato = 0;
        double presupuestoMenperro = 0;
        double presupuestoMenveteri = 0;
        
        for(Empleado emgast: this.empleados){
            if(emgast instanceof UserAdmi){
                UserAdmi ua = (UserAdmi)emgast;
                presupuestoMenEm = presupuestoMenEm + ua.getSueldo() + 150;
            }
            if(emgast instanceof UserFun){
                UserFun ua = (UserFun)emgast;
                presupuestoMenEm = presupuestoMenEm + ua.getSueldo() + 150;
            }
        }
       
        for(Animal aniadop: this.animalesEnAdopccion){
            
            if(aniadop instanceof Gato){
                Gato gadop = (Gato)aniadop;
                presupuestoMengato = presupuestoMengato + gadop.mostrarGastos() ;
                                       
            }
            if(aniadop instanceof Perro){
                Perro perdop = (Perro)aniadop;
                presupuestoMenperro = presupuestoMenperro + perdop.mostrarGastos() ;
                
            }
        }
        for(GastosVeterinaria emgast: this.gastosv){
            LocalDate otrodia = emgast.getFechaingre();
            LocalDate hoy = LocalDate.now();
            long days = ChronoUnit.DAYS.between(otrodia, hoy);
            if(days <= 30){
                Animal aniem =emgast.getRegisEnVeterinaria(); 
                if(aniem instanceof Perro){
                    presupuestoMenperro = presupuestoMenperro + emgast.getGastosVeterinaria();
                }
                if(aniem instanceof Gato){ 
                    presupuestoMengato = presupuestoMengato + emgast.getGastosVeterinaria();
                }
                presupuestoMenveteri = presupuestoMenveteri + emgast.getGastosVeterinaria();
            }
            
            
        }
        double gastoTotal = presupuestoMenEm + presupuestoMengato + presupuestoMenperro;
        String strpresupuestoMenEm = String.valueOf(presupuestoMenEm);
        String strpresupuestoMengato = String.valueOf(presupuestoMengato);
        String strpresupuestoMenperro = String.valueOf(presupuestoMenperro);
        String strpresupuestoMenveteri = String.valueOf(presupuestoMenveteri);
        String strgastoTotal = String.valueOf(gastoTotal);
        String cadeani = "Gasto mensual en empleados: %s        Gasto mensual en gatos: %s        Gasto mensual en perros: %s        Gasto mensual en veterinarias: %s Gasto total: %s\n";
        var =  String.format(cadeani,strpresupuestoMenEm,strpresupuestoMengato,strpresupuestoMenperro,strpresupuestoMenveteri,strgastoTotal);
        return var;
    }
    public void enviarCorreo(){
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", "fundacion4pataspoo@gmail.com");
        props.put("mail.smtp.clave", "12345678POO");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        try {
            message.setFrom(new InternetAddress("fundacion4pataspoo@gmail.com"));
            for(Adoptante adcorre: this.userRegistrados){
                ArrayList<Animal> aniInte = this.consultarAnimales(adcorre.getTipoDeanimal(), adcorre.getSexoDelAnimal(),adcorre.getRazaDelAnimal());
                InternetAddress emailAdoptante = new InternetAddress(adcorre.getCorreo());
                message.addRecipient(Message.RecipientType.TO, emailAdoptante);
                message.setSubject("Animales encontrados segun sus gustos");
                if(aniInte.size()==0){
                    message.setText("No se ha encontrado ni un animal a su gusto D:");
                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", "fundacion4pataspoo@gmail.com", "12345678POO");
                    transport.sendMessage(message, message.getAllRecipients());
                    transport.close();
                }
                if(aniInte.size()!=0){
                    String infoani = this.imprimirListaAni(aniInte);
                    message.setSubject("Lista de animales encontrados");
                    message.setText(infoani + "hola" );
                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", "fundacion4pataspoo@gmail.com", "12345678POO");
                    transport.sendMessage(message, message.getAllRecipients());
                    transport.close();
                    
                    
                }
            } 
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    public boolean comprobarMail(String email){
        int arroba = 0;
        boolean valido = false;
        for(int i=0; i<email.length(); i++){
            if(email.charAt(i)=='@')
                arroba++;
        }
        if(arroba >1)
            return valido;
        else
            valido = true;
        return valido;
    }
    public boolean verificarEmail(String email){
        String[] dominios = {"google.com","outlook.com","yahoo.com","espol.edu.ec"};
        int resultado = email.indexOf("@");
        if(resultado != -1){
            String [] splits = email.split("@");
            if(splits.length >= 1){
                return splits[1].equals(dominios[0])||splits[1].equals(dominios[1])||splits[1].equals(dominios[2])||splits[1].equals(dominios[3]);
        }
        }    
        return false;
    }
    public ArrayList<Veterinaria> getVeterinarias() {
        return veterinarias;
    }
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
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

    public ArrayList<GastosVeterinaria> getGastosv() {
        return gastosv;
    }
    
}
