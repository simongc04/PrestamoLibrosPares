/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prestamolibros;

/**
 *
 * @author simon
 */
import java.util.Random;

public class HiloEstudiante implements Runnable {
    private final String nombre;
    private final Libro[] libros;
    private final GestorPrestamo gestor;
    private final Random random = new Random();
    private int maxPrestamos; 


    public HiloEstudiante(String nombre, Libro[] libros, GestorPrestamo gestor, int maxPrestamos) {
        this.nombre = nombre;
        this.libros = libros;
        this.gestor = gestor;
        this.maxPrestamos = maxPrestamos;
    }

    
    
    @Override
    public void run() {
         for (int i = 0; i < maxPrestamos; i++) { 
            try {
                Libro[] librosPrestados = gestor.obtenerDosLibros();
                System.out.println(nombre + " ha tomado los libros: " + librosPrestados[0].getNombreLibro() + " y " + librosPrestados[1].getNombreLibro());

                int tiempoUso = 60 + random.nextInt(121); 
                Thread.sleep(tiempoUso * 10); 
                System.out.println(nombre + " ha terminado de usar los libros.");

                gestor.devolverLibros(librosPrestados);
                System.out.println(nombre + " ha devuelto los libros.");

                int tiempoDescanso = 60 + random.nextInt(61); 
                Thread.sleep(tiempoDescanso * 10);  
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " ha sido interrumpido.");
            }
        }
    }
}