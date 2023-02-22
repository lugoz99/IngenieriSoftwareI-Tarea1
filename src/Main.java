import contadorpalabras.Carpeta;
import contadorpalabras.Contador;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Primera Prueba");
        Carpeta carpeta = new Carpeta("D:\\pruebas1\\");
        Contador contador = new Contador();
        contador.contarPalabrasArchivo("arar", carpeta);

        System.out.println("Segunda Prueba");
        Carpeta carpeta2 = new Carpeta("D:\\pruebas2\\");
        Contador contador2 = new Contador();
        contador2.contarPalabrasArchivo("foto", carpeta2);

        System.out.println("Tercera Prueba");
        Carpeta carpeta3 = new Carpeta("D:\\incorrecta\\");
        Contador contador3 = new Contador();
        contador2.contarPalabrasArchivo("ejemplo", carpeta3);


    }


    public static void pedirDatos() {
        try (Scanner sc = new Scanner(System.in)) {
            File ruta;

            do {
                System.out.println("\nIngrese la ruta de la carpeta: ");
                ruta = new File(sc.nextLine());
                if (!(ruta.isDirectory())) {
                    System.out.println("\nEsta no es una ruta de carpeta");
                }

            } while (!(ruta.isDirectory()));

            System.out.println("\nIngrese la palabra a buscar: ");
            String palabra = sc.nextLine();// "arar"; Reemplazar por la palabra que se desea buscar

            Carpeta carpeta = new Carpeta(ruta.toString());

            Contador contador = new Contador();
            contador.contarPalabrasArchivo(palabra, carpeta);


        }
    }
}
