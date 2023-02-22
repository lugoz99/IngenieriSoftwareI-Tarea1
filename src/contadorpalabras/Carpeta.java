package contadorpalabras;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class Carpeta {

    // nombre representa la ruta del directorio
    private String nombre;

    public Carpeta(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public File getDirectorio() {
        return new File(getNombre());
    }


    /**
     * @return True o False
     * se valida si el directorio existe en caso de no existir se lanza una exception indicando que no existe
     */
    public boolean directorioExiste() {
        boolean existe = false;
        if (getDirectorio().exists()) {
            existe = true;
        } else {
            try {
                throw new FileNotFoundException("La carpeta o directorio no se encuentra.");
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
        return existe;
    }


    /**
     * @return list
     * se obtiene los archivos en la carpeta especificada
     */
    public List<String> obtenerArchivos() {
        List<String> listaArchivos = new ArrayList<>();
        if (directorioExiste()) {
            File[] archivos = getDirectorio().listFiles(); // Listar archivos del directorio
            for (File archivo : Objects.requireNonNull(archivos)) {
                if (archivo.isFile()) { // si es archivo entonces se agregan a la lista
                    listaArchivos.add(archivo.getName()); // Agregar nombre del archivo a la lista
                }
            }
        }
        return listaArchivos;
    }


    /**
     * @param archivo
     * @return se retorna las extensiones del archivo txt, cvs , .xml
     */
    public String obtenerExtension(String archivo) {
        String extension;
        if (archivo.contains(".")) {
            extension = archivo.substring(archivo.lastIndexOf(".") + 1);
            return extension;
        }
        return "";
    }


}
