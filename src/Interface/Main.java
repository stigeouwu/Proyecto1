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
        String[] obser = new String[2];
        obser[0] = "hola";
        obser[1] ="XD";
        TamanioPerro t1 = TamanioPerro.valueOf("GRANDE");
        Animal a1 = new Perro(t1,hoy,"boby", "Mestizo", "Macho", 3600.5, 1, obser, 1);
        Animal a2 = new Gato(hoy,"uwu", "Mestizo", "Macho", 8.5, 1, obser, 2);
        f0.agragarAni(a1);
        f0.agragarAni(a2);
        Adoptante adopexp = new Adoptante("juan", "09558","jardines","aasdasd@espol.edu.ec","04234","perro","mtz","macho");
        
        Animal a3 = new Perro(t1,hoy,"boart", "Mestizo", "Macho", 3600.5, 1, obser, 1);
        LocalDate diaAdop = LocalDate.now();
        f0.getUserRegistrados().add(adopexp);
        Adopccion regisadop = new Adopccion(a3,adopexp,1,diaAdop);
        f0.getRegistroAdop().add(regisadop);
        Animal a4 = new Gato(hoy,"gato", "Mestizo", "Macho", 8.5, 1, obser, 2);
        f0.agragarAni(a3);
        f0.agragarAni(a4);
        f0.getAnimalesAdoptados().add(a3);
        f0.getAnimalesEnAdopccion().add(a4);
        Perro g1 = (Perro)a1;
        Adoptante adop0 = new Adoptante("pedro", "09557","jardines","aasdasd@espol.edu.ec","04234","perro","mtz","macho");
        f0.getUserRegistrados().add(adop0);
        System.out.println(g1.getFechaIngreso());
        Empleado e1 = new UserFun("hola", "0997852", "jardines", "asda@xd", "045826", hoy, 400, "holauwu", "xdxd");
        f0.AgragarEmpleado(e1);
        Scanner sc = new Scanner(System.in);
        String user,pass= "";
        boolean salir= true;
        System.out.println(f0.getAnimalesAdoptados().size());
        System.out.println(f0.getAnimalesEnAdopccion().size());
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
            System.out.println("1. Registrar un nuevo animal\n2. Consultar animales en la fundacion\n3. Registrar interado en adopccion\n4. Registrar adopccion\n5. Consultar adopcciones\n6. Consultar Adoptantes\n7. Cerrar sesion ");
            sc.nextLine();
            System.out.print("\nOpción>>> ");
            int opm = sc.nextInt();
            try{
                sc.nextLine();
                switch(opm){
                case 1:    
                        System.out.println("Ingreses que desea registrar");
                        System.out.println("1. Gato\n2. Perro");
                        int opc = sc.nextInt();
                        sc.nextLine();
                        switch(opc){
                            case 1:
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
                                    break;
                            case 2:
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
                                    break;
                                    
                        }
                        
                        break;
                        
                case 2:    
                        System.out.println(f0.imprimirListaAni(f0.getAnimalesEnAdopccion()));
                        sc.nextLine();
                        break;
                case 3:
                        System.out.println("Ingrese los datos de la persona interesada en adoptar ");
                        System.out.println("Ingrese su nombre: ");
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
            System.out.println("1. Registrar Empleados.\n2. Consultar y registrar Veterinarias.\n3. Consultar y registrar Gasto Veterinaria.\n4. Calcular presupuesto mensual.\n5. Enviar correo a interesados.\n6. Cerrar sesion ");
            sc.nextLine();
            System.out.print("\nOpción>>> ");
            int opm = sc.nextInt();
            try{
                sc.nextLine();
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
                        System.out.println("1. Registar veterinarias\n2. Consultar veterinarias registradas");
                        sc.nextLine();
                        System.out.println("Ingreses lo que desea hacer: ");
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
                        System.out.println("1. Registar gastos\n2. Consultar gastos");
                        sc.nextLine();
                        System.out.println("Ingreses lo que desea hacer: ");
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
                }
            }catch (InputMismatchException error){
                                System.out.println("\t>>DEBE INGRESAR UN NÚMERO<<");
                                sc.next();
            }
            }while(salir);
        
//        Animal xd = f0.getAnimalesEnAdopccion().get(0);
//        Gato gxd = (Gato)xd;
//        System.out.println(gxd.getObservaciones()[0]);
//        System.out.println(gxd.getCodigo());
//        Animal xd1 = f0.getAnimalesTotal().get(1);
//        Gato gxd1 = (Gato)xd1;
//        System.out.println(gxd1.getObservaciones()[0]);
//        System.out.println(gxd1.getCodigo());
//        Animal xd2 = f0.getAnimalesTotal().get(2);
//        Gato gxd2 = (Gato)xd2;
//        System.out.println(gxd2.getCodigo());
        System.out.println(f0.imprimirListaAni(f0.getAnimalesTotal()));
        System.out.println(f0.voltearLista().size());
        System.out.println(f0.getRegistroAdop());
        System.out.println(f0.devolverConsulta());
        System.out.println(f0.Mostardatos("09557"));
    }
    
    }  
}
