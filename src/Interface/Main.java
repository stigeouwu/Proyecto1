/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import TipoAnimales.*;
import TipoEmpleados.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author stige
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Fundacion f0 = new Fundacion();
        LocalDate hoy = LocalDate.now();
        f0.inicializar();
        
        Scanner sc = new Scanner(System.in);
        String user,pass= "";
        boolean salir= true;
        do{
        
        do{ 
            System.out.println("bienvenido al sistemauwu");
            System.out.println("Por favor ingrese sus datos para vereficar el usuario");
            sc.useDelimiter("\n");
            System.out.println("Ingrese su Usuario: ");
            user = sc.next();
            System.out.println("Ingrese su contraseña: ");
            pass = sc.next();
            if(!f0.IngresarUser(user,pass)){
                System.out.println("Ha logrado ingresar con exito la sesion uwu");
            }
            else{
                System.out.println("User o pass incorrecta, por favor ingreses de nuevo.");
            }
        }while(f0.IngresarUser(user,pass));
        Empleado eAF = f0.consultarEmple(user,pass);
        if(eAF instanceof UserFun){
            do{ 
                System.out.println("bienvenido uwu");
                System.out.println("\t\tMENÚ PRINCIPAL");
                System.out.println("1. Registrar un nuevo animal");
                System.out.println("2. Consultar animales en la fundacio");
                System.out.println("3. Registrar interado en adopccion");
                System.out.println("4. Registrar adopccion");
                System.out.println("5. Consultar adopcciones");
                System.out.println("6. Consultar Adoptantes");
                System.out.println("7. Cerrar sesion ");
                try{
                System.out.print("\nOpción>>> ");
                int opm = sc.nextInt();
                sc.nextLine();
                switch(opm){
                case 1:    
                        System.out.println("Ingreses que desea registrar");
                        System.out.println("1. Gato\n2. Perro");
                        int opc = sc.nextInt();
                        sc.nextLine();
                        switch(opc){
                            case 1:
                                try{
                                //fecha ingreso, nombre, raza, sexo (masculino o femenino), peso, edad, observaciones
                                    System.out.println("Por favor ingrese los datos del Gato");
                                    sc.useDelimiter("\n");
                                    System.out.println("Ingrese su nombre: ");
                                    String nombre = sc.nextLine();
                                    System.out.println("Ingrese su raza: ");
                                    String raza = sc.nextLine();
                                    System.out.println("Ingrese su sexo: ");
                                    String sexo = sc.nextLine();
                                    System.out.println("Ingrese su peso: ");
                                    double peso = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Ingrese su edad: ");
                                    int edad = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Ingrese sus observaiones separados por una (,): ");
                                    String obsevaciones = sc.nextLine();
                                    f0.agregarAnimalGato(nombre, raza, sexo, peso, edad, obsevaciones.split(","));
                                    sc.nextLine();
                                    }catch (InputMismatchException error){
                                    System.out.println("\t>>DEBE INGRESAR UN NÚMERO<<");
                                    System.out.println("\t>>Vuelva a intentarlo<<");
                                    sc.next();
                                    }
                                    break;
                            case 2:
                                try{
                                    System.out.println("Por favor ingrese los datos del Perro");
                                    sc.useDelimiter("\n");
                                    System.out.println("Ingrese su nombre: ");
                                    String nombreP = sc.nextLine();
                                    System.out.println("Ingrese su raza: ");
                                    String razaP = sc.nextLine();
                                    System.out.println("Ingrese su sexo: ");
                                    String sexoP = sc.nextLine();
                                    System.out.println("Ingrese su peso: ");
                                    double pesoP = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Ingrese su edad: ");
                                    int edadP = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Ingrese sus observaiones separados por una (,): ");
                                    String obsevacionesP = sc.nextLine();
                                    System.out.println("Ingrese tamaño del perro(GRANDE,MEDIANO,PEQUEÑO): ");
                                    String tamaniop = sc.nextLine();
                                    f0.agregarAnimalPerro(nombreP, razaP, sexoP, pesoP, edadP, obsevacionesP.split(","), TamanioPerro.valueOf(tamaniop));
                                    sc.nextLine();
                                    }catch (InputMismatchException error){
                                    System.out.println("\t>>DEBE INGRESAR UN NÚMERO<<");
                                    System.out.println("\t>>Vuelva a intentarlo<<");
                                    sc.next();
                                    }
                                    break;
                                    
                        }
                        
                        break;
                        
                case 2:    
                        System.out.println(f0.imprimirListaAni(f0.getAnimalesEnAdopccion()));
                        sc.nextLine();
                        break;
                case 3:
                        System.out.println("Ingrese los datos de la persona interesada en adoptar ");
                        System.out.println("\nIngrese su nombre: ");
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese su cedula: ");
                        String cedula= sc.nextLine();
                        System.out.println("Ingrese su direccion: ");
                        String direccion = sc.nextLine();
                        System.out.println("Ingrese su telefono: ");
                        String telefono = sc.nextLine();
                        System.out.println("Ingrese su correo electronico: ");
                        String correoElectronico = sc.nextLine();
                        System.out.println("Ingrese los intereses de la persona interesada en adoptar ");
                        System.out.println("Ingrese el animal que prefiere: ");
                        String animal = sc.nextLine();
                        System.out.println("Ingrese la raza del animal: ");
                        String raza = sc.nextLine();
                        System.out.println("Ingrese su sexo: ");
                        String sexo = sc.nextLine();
                        Adoptante p0 = new Adoptante(nombre,cedula,direccion,correoElectronico,telefono, animal, raza, sexo);
                        f0.getUserRegistrados().add(p0);
                        sc.nextLine();
                        break;
                case 4:
                        System.out.println("Ingrese la cedula del adoptante: ");
                        String ceduadop = sc.nextLine();
                        System.out.println("Ingrese el codigo del animal que quiere adoptar: ");
                        int codiAni = sc.nextInt();
                        sc.nextLine();
                        boolean veriCed = f0.ValidarCliente(ceduadop);
                        boolean veriAni = f0.ValidarAnimal(codiAni);
                        if(veriCed == true && veriAni == false ){
                            Adoptante Adopt = f0.buscarAdop(ceduadop);
                            Animal anim = f0.buscarAni(codiAni);
                            f0.registrarAdop(Adopt,anim);
                            System.out.println("Se ha registrado adopccion con exito");
                        }
                        else{
                            if(veriCed == false){
                                System.out.println("Persona no registrada en la base de datos.");
                            }
                            if(veriAni == true){
                                System.out.println("Este animal ya ha sido adoptado.");
                            }
                            
                        } 
                        break;
                case 5:
                        System.out.println(f0.devolverConsulta());
                        break;
                case 6: 
                        sc.nextLine();
                        System.out.println(f0.mostrarUser());
                        System.out.println("Ingrese la dedula que desea consultar: ");
                        String ceduConsul = sc.nextLine();
                        System.out.println(f0.Mostardatos(ceduConsul));
                        sc.nextLine();
                        System.out.println("Desea modificar datos de este usuario?(si/no)");
                        String modi = sc.nextLine();
                        sc.nextLine();
                        if(modi.equals("si")){
                            System.out.println("Ingrese su nombre: ");
                            String nombremod = sc.nextLine();
                            System.out.println("Ingrese su direccion: ");
                            String direccionmod = sc.nextLine();
                            System.out.println("Ingrese su telefono: ");
                            String telefonomod = sc.nextLine();
                            System.out.println("Ingrese su correo electronico: ");
                            String correoElectronicomod = sc.nextLine();
                            f0.modificarUsser(nombremod, direccionmod, telefonomod, correoElectronicomod, ceduConsul);
                        }
                        else{
                            System.out.println("Regresando al inicio");
                        }
                        break;
                
                case 7:
                        salir = false;
                        break;
                }
            }catch (InputMismatchException error){
                                System.out.println("\t>>DEBE INGRESAR UN NÚMERO<<");
                                sc.next();
            }
            }while(salir);
            
        }
        if(eAF instanceof UserAdmi){
            do{ 
                System.out.println("bienvenido uwu");
                System.out.println("\t\tMENÚ PRINCIPAL");
                System.out.println("bienvenido uwu");
                System.out.println("\t\tMENÚ PRINCIPAL");
                System.out.println("1. Registrar Empleados");
                System.out.println("2. Consultar y registrar Veterinarias.");
                System.out.println("3. Consultar y registrar Gasto Veterinaria.");
                System.out.println("4. Calcular presupuesto mensual.");
                System.out.println("5. Enviar correo a interesados.");
                System.out.println("6. Cerrar sesion ");
                
                try{
                    System.out.print("\nOpción>>> ");
                    int opm = sc.nextInt();
                switch(opm){
                case 1:   
                        System.out.println("Registar nuevo empleado");
                        System.out.println("Ingrese el nombre: ");
                        String nombreemple = sc.nextLine();
                        System.out.println("Ingrese la cedula: ");
                        String cedulaemple= sc.nextLine();
                        System.out.println("Ingrese la direccion: ");
                        String direccionemple = sc.nextLine();
                        System.out.println("Ingrese el telefono: ");
                        String telefonoemple = sc.nextLine();
                        System.out.println("Ingrese el correo electronico: ");
                        String correoElectronicoemple = sc.nextLine();
                        System.out.println("Ingrese el sueldo: ");
                        Double sueldoemple = sc.nextDouble();
                        sc.nextLine();
                        String usuaremple = "";
                        
                        do{
                            System.out.println("Ingrese el usuario que desea: ");
                            usuaremple = sc.nextLine();
                            if(f0.consultarUser(usuaremple)){
                                System.out.println("Usuario ya registrado");
                            }
                            if(!f0.consultarUser(usuaremple)){
                                System.out.println("Nombre de usuario disponible");
                            }
                        }while(f0.consultarUser(usuaremple));
                        System.out.println("Ingrese la contraseña que desea: ");
                        String contraemple= sc.nextLine();
                        System.out.println("Desea que este usuario sea administrador (si/no): ");
                        String regisemple= sc.nextLine();
                        if(regisemple.equals("si")){
                            System.out.println("Ingrese la cuentabancaria: ");
                            String cuenta= sc.nextLine();
                            Empleado eAdmi = new UserAdmi(cuenta,nombreemple,cedulaemple,direccionemple,correoElectronicoemple,telefonoemple,hoy,sueldoemple,usuaremple,contraemple);
                            f0.getEmpleados().add(eAdmi);
                        }
                        if(regisemple.equals("no")){
                            Empleado eFun = new UserFun(nombreemple,cedulaemple,direccionemple,correoElectronicoemple,telefonoemple,hoy,sueldoemple,usuaremple,contraemple);
                            f0.getEmpleados().add(eFun);
                        }
                        break;
                        
                case 2:    
                        System.out.println("1. Registar veterinarias");
                        System.out.println("2. Consultar veterinarias registradas");
                        System.out.print("\nOpción>>> ");
                        int opcvete = sc.nextInt();
                        sc.nextLine();
                        switch(opcvete){
                            case 1:
                                //fecha ingreso, nombre, raza, sexo (masculino o femenino), peso, edad, observaciones
                                System.out.println("Por favor ingrese el nombre de la veterinaria: ");
                                String nombrevete = sc.nextLine();
                                System.out.println("Ingrese numero de contacto de la veterinaria: ");
                                String numecontac = sc.nextLine();
                                System.out.println("Ingrese el correo de la veterinaria: ");
                                String correovete = sc.nextLine();
                                Veterinaria vexp = new Veterinaria(nombrevete,numecontac,correovete);
                                f0.getVeterinarias().add(vexp);
                                sc.nextLine();
                                    break;
                            case 2:
                                System.out.println(f0.consultarVete());
                                break;
                        }
                        break;
                case 3:
                        System.out.println("1. Registar gastos");
                        System.out.println("2. Consultar gastos");
                        System.out.print("\nOpción>>> ");
                        int opcgast = sc.nextInt();
                        sc.nextLine();
                        switch(opcgast){
                            case 1:
                                System.out.println("Ingrese el dinero gastado: ");
                                Double dinegast = sc.nextDouble();
                                System.out.println("Ingrese el correo de la veterinaria: ");
                                String correovete = sc.nextLine();
                                System.out.println("Ingrese el codigo del animal: ");
                                int codigoaniv = sc.nextInt();
                                sc.nextInt();
                                GastosVeterinaria vexp = new GastosVeterinaria(f0.consultarAni(codigoaniv),dinegast,hoy);
                                f0.getGastosv().add(vexp);
                                sc.nextLine();
                                    break;
                            case 2:
                                System.out.println(f0.consultargastos());
                                break;
                        }
                        break;
                        
                        
                        case 4:
                         System.out.println(f0.consultarGastosmen());
                         break;
                    case 5:
                        f0.enviarCorreo();
                        break;
                    case 6:
                        salir = false;
                        break;
                    
                }
            }catch (InputMismatchException error){
                                System.out.println("\t>>DEBE INGRESAR UN NÚMERO<<");
                                sc.next();
            }
            }while(salir);
        }
    }while(true);
        

    
    
    }  
}
