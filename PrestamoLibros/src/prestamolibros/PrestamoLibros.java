/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prestamolibros;

/**
 *
 * @author simon
 */
public class PrestamoLibros {
    public static int NUMERO_LIBROS = 9;
    public static int NUMERO_ESTUDIANTES = 4; 
    public static int MAX_PRESTAMOS = 4; 

    public static void main(String[] args) {
        Libro libros[] = new Libro[NUMERO_LIBROS];
        libros[0] = new Libro("libro 1");
        libros[1] = new Libro("libro 2");
        libros[2] = new Libro("libro 3");
        libros[3] = new Libro("libro 4");
        libros[4] = new Libro("libro 5");
        libros[5] = new Libro("libro 6");
        libros[6] = new Libro("libro 7");
        libros[7] = new Libro("libro 8");
        libros[8] = new Libro("libro 9");

        GestorPrestamo gestor = new GestorPrestamo(libros);

        Thread estudiantes[] = new Thread[NUMERO_ESTUDIANTES];
        
        estudiantes[0] = new Thread(new HiloEstudiante("Simon", libros, gestor, MAX_PRESTAMOS));
        estudiantes[1] = new Thread(new HiloEstudiante("Benchey", libros, gestor, MAX_PRESTAMOS));
        estudiantes[2] = new Thread(new HiloEstudiante("bryan", libros, gestor, MAX_PRESTAMOS));
        estudiantes[3] = new Thread(new HiloEstudiante("adrian", libros, gestor, MAX_PRESTAMOS));
        
        estudiantes[0].start();
        estudiantes[1].start();
        estudiantes[2].start();
        estudiantes[3].start();
        
        for (Thread estudiante : estudiantes) {
            try {
                estudiante.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
