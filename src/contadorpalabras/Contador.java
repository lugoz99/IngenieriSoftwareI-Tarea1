package contadorpalabras;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Contador {


    /**
     * @param palabra palabra dada para buscar en el archivo
     * @param archivo permite acceder a la lista de archivos
     *                este metodo me permite obtener la información de cada carpeta con sus respectivos archivos
     *                referente a la palabra que se quiere saber cuantas veces y que cantidad total hay
     */
    public void contarPalabrasArchivo(String palabra, Carpeta archivo) {
        int contador = 0;
        int total = 0;
        if (archivo.obtenerArchivos().size() > 0 && archivo.directorioExiste()) {
            for (String myArchivo : archivo.obtenerArchivos()) {
                String extension = archivo.obtenerExtension(myArchivo);
                if (extension.equals("txt") || extension.equals("xml") || extension.equals("json") || extension.equals("csv")) {
                    try (BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo.getNombre() + myArchivo))) {
                        String linea;
                        String[] separar;
                        contador = 0;
                        while ((linea = leerArchivo.readLine()) != null) {
                            separar = linea.split(",|\\(| |:|;"); // separar permite manejar los caracteres especiales dentro de los archivos
                            contador += contarPalabraPorLinea(separar, palabra);
                            //System.out.println(Arrays.toString(separar));
                        }
                    } catch (IOException e) {
                        System.err.println("Error al leer el archivo " + ": " + e.getMessage());
                    }

                }


                System.out.println(myArchivo + " tiene " + contador + " veces la palabra " + palabra);
                total += contador;
                System.out.println("--------------------");
            }
            System.out.println("Total " + total);

        } else {
            System.out.println("No se encontraron archivos de texto en la carpeta");
        }
    }


    /**
     * @param linea   cada una de las palabras del archivo
     * @param palabra palabra a buscar en el arreglo linea
     * @return contador es el contento de la palabra buscada que va incrementando cuando conicida
     */
    public int contarPalabraPorLinea(String[] linea, String palabra) {
        int contador = 0;
        //int indice = 1;
        for (String s : linea) {
            //System.out.println("lines: "+linea[i]);
            if (s.equals(palabra)) {
                contador++;
            }
        }
        return contador;
    }

}

