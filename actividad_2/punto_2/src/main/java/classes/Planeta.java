package main.java.classes;
import java.util.Scanner;

public class Planeta {
    String nombre=null;
    int satelites=0, diametro=0, distanciaSol=0;
    double masa=0, volumen=0;
    boolean observable=false;
    enum tipoPlaneta{Gaseoso, Terrestre, Enano}
    tipoPlaneta tipo;

    Planeta (String nombre, int satelites, int diametro, int distanciaSol, double masa, double volumen, boolean observable, tipoPlaneta tipo){
        this.nombre=nombre;
        this.satelites=satelites;
        this.diametro=diametro;
        this.distanciaSol=distanciaSol;
        this.masa=masa;
        this.volumen=volumen;
        this.observable=observable;
        this.tipo=tipo;
        
    }

    void imprimir(){
        System.out.println("Nombre del planeta: " + nombre); 
        System.out.println("Cantidad de satélites: " + satelites); 
        System.out.println("Diámetro del planeta: " + diametro); 
        System.out.println("Distancia al sol: " + distanciaSol); 
        System.out.println("Masa del planeta: " + masa); 
        System.out.println("Volumen del planeta: " + volumen); 
        System.out.println("Es observable: " + observable);
        System.out.println("Tipo de planeta: " + tipo); 
        
    }

    double Densidad(){

        return masa/volumen;
    }

    boolean PlanetaExterior(){
        float limite = (float)(149597870*Math.PI);
        if (distanciaSol>limite){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        Planeta p1 = new Planeta("Tierra", 1, 12742, 150000000, 5.9736E24, 1.08321E12, true, tipoPlaneta.Terrestre); 
        p1.imprimir();
        System.out.println("Densidad del planeta = " + p1.Densidad()); 
        System.out.println("Es planeta exterior = " + p1.PlanetaExterior()); 
        System.out.println(); 
        Planeta p2 = new Planeta("Júpiter", 79, 139820, 750000000, 1.899E27, 1.4313E15, true, tipoPlaneta.Gaseoso);
        p2.imprimir(); 
        System.out.println("Densidad del planeta = " + p2.Densidad()); 
        System.out.println("Es planeta exterior = " + p2.PlanetaExterior());

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n¡Agrega un planeta!");
        System.out.print("\nIngrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su cantidad de satelites: ");
        int satelites = scanner.nextInt();

        System.out.print("Ingrese su diametro: ");
        int diametro = scanner.nextInt();

        System.out.print("Ingrese su distancia al sol: ");
        int distanciaSol = scanner.nextInt();

        System.out.print("Ingrese su masa: ");
        double masa = scanner.nextDouble();

        System.out.print("Ingrese su volumen: ");
        double volumen = scanner.nextDouble();

        System.out.print("¿Es observable? (true/false): ");
        boolean observable = scanner.nextBoolean();
        
        tipoPlaneta tipo=null;
        System.out.println("1. Gaseoso");
        System.out.println("2. Terrestre");
        System.out.println("3. Enano");
        System.out.print("Elija el tipo de planeta (1/2/3): ");
        int opcion = scanner.nextInt();

        switch(opcion) {
            case 1:
                tipo = tipoPlaneta.Gaseoso;
                break;
            case 2:
                tipo = tipoPlaneta.Terrestre;
                break;
            case 3:
                tipo = tipoPlaneta.Enano;
                break;
            default:
                System.out.println("Opción no válida.");
        }
    
    Planeta p = new Planeta(nombre, satelites, diametro, distanciaSol, masa, volumen, observable, tipo);

    System.out.println("\nDatos del planeta:");
    p.imprimir();
    System.out.println("Densidad del planeta= " + p.Densidad());
    System.out.println("Es planeta exterior= " + p.PlanetaExterior());

    scanner.close();
    }


    
}
