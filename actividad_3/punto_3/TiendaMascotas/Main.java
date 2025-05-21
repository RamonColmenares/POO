package TiendaMascotas;

public class Main {
    public static void main(String[] args) {
        Chihuahua chihuahua = new Chihuahua("Taco", 2, "Marrón", 3.5, false);
        chihuahua.imprimir();
        Perro.sonido();

        Esfinge esfinge = new Esfinge("Cleopatra", 3, "Gris", 1.2, 1.8);
        esfinge.imprimir();
        Gato.sonido();
    }
}
