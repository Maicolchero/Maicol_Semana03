/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

public class Credito extends Venta {
    private int letras; // Número de letras para el pago
    private int x; // Cantidad de productos comprados

    // Constructor
    public Credito(String nombreCliente, String ruc, String fecha, String hora, String nombreProducto, int cantidad, int letras) {
        super(nombreCliente, ruc, fecha, hora, nombreProducto, cantidad); // Llama al constructor de la clase base
        this.letras = letras; // Asigna el número de letras
        this.x = cantidad; // Asigna la cantidad de productos
    }

    // Método para obtener la cantidad de productos
    public int getX() {
        return x;
    }

    // Métodos getter y setter para letras
    public int getLetras() {
        return letras;
    }

    public void setLetras(int letras) {
        this.letras = letras;
    }

    // Método para calcular el descuento basado en el subtotal
    public double calculaDescuento() {
        double subtotal = calculaSubtotal(); // Utiliza el método de la clase base
        if (subtotal < 1000.00) {
            return subtotal * 0.03; // 3% de descuento
        } else if (subtotal >= 1000.00 && subtotal <= 3000.00) {
            return subtotal * 0.05; // 5% de descuento
        } else {
            return subtotal * 0.08; // 8% de descuento
        }
    }

    // Método para calcular el monto mensual a pagar
    public double calculaMontoMensual() {
        double totalPagar = calculaSubtotal() - calculaDescuento(); // Total a pagar después del descuento
        return letras > 0 ? totalPagar / letras : 0.0; // Si hay letras, calcula el monto mensual
    }

    @Override
    public String toString() {
        return super.toString() + ", Letras: " + letras + ", Cantidad: " + x;
    }
}