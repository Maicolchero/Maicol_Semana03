/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Contado extends Venta {
    private int n; // Cantidad de productos

    // Constructor que inicializa la cantidad de productos
    public Contado(String nombreCliente, String ruc, String fecha, String hora, String nombreProducto, int cantidad) {
        super(nombreCliente, ruc, fecha, hora, nombreProducto, cantidad);
        this.n = cantidad; // Asigna la cantidad de productos comprados
    }

    // Método para obtener la cantidad de productos
    public int getN() {
        return this.n;
    }

    // Método para calcular el descuento basado en el subtotal
    public double calculaDescuento(double subtotal) {
        if (subtotal < 1000.00) {
            return subtotal * 0.05; // 5% de descuento
        } else if (subtotal >= 1000.00 && subtotal <= 3000.00) {
            return subtotal * 0.08; // 8% de descuento
        } else {
            return subtotal * 0.12; // 12% de descuento
        }
    }

    public double calculaDescuento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
