package main.java.classes;
import java.util.Scanner;

public class Persona {
    
    String nombre, apellido, DI;
    int ANacimiento;

    Persona(String nombre, String apellido, String DI, int ANacimiento){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DI = DI;
        this.ANacimiento = ANacimiento;
    }

    void imprimir(){
        System.out.println("\nNombre: "+nombre );
        System.out.println("Apellidos: "+apellido );
        System.out.println("Documento de identidad: "+DI );
        System.out.println("Año de nacimiento: "+ANacimiento );
    }


    public static void main(String[] args){
        Persona p1 = new Persona("Pedro","Pérez","1053121010",1998); 
        Persona p2 = new Persona("Luis","León","1053223344",2001);
        System.out.print("Personas registradas: ");
        p1.imprimir();
        p2.imprimir();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n¡Agrega una persona!");
        System.out.print("\nIngrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese los apellidos: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el documento de identidad: ");
        String DI = scanner.nextLine();

        System.out.print("Ingrese el año de nacimiento: ");
        int ANacimiento = scanner.nextInt();

        Persona p = new Persona(nombre, apellido, DI, ANacimiento);

        System.out.println("\nDatos ingresados:");
        p.imprimir();
        scanner.close();
    }


    
}
