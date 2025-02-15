/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prestamolibros;

/**
 *
 * @author simon
 */
public class Libro {
    String nombreLibro;
    boolean prestado;
    
    public Libro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
        this.prestado = false;
    }
    
    public String getNombreLibro() {
        return nombreLibro;
    }

    synchronized public boolean isPrestado() {
        return prestado;
    }
    
    public synchronized void setPrestado(boolean prestado) {
        this.prestado = prestado;
        if (prestado) {
            System.out.println("Libro " + nombreLibro + " ha sido prestado.");
        } else {
            System.out.println("Libro " + nombreLibro + " ha sido devuelto.");
        }
    }
}