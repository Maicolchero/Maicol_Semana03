/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 * Clase base que representa una venta. Contiene métodos para calcular el
 * subtotal y manejar información del cliente y del producto.
 */
public class Venta {
    private String nombreCliente;
    private String ruc;
    private String fecha;
    private String hora;
    private String nombreProducto;
    private int cantidad;
    private double precio;

    public Venta(String nombreCliente, String ruc, String fecha, String hora, String nombreProducto, int cantidad) {
        this.nombreCliente = nombreCliente;
        this.ruc = ruc;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = asignaPrecio(nombreProducto);
    }

    public static double asignaPrecio(String producto) {
        switch (producto) {
            case "Lavadora":
                return 1500.00;
            case "Refrigeradora":
                return 3500.00;
            case "Licuadora":
                return 500.00;
            case "Extractora":
                return 150.00;
            case "Radiograbadora":
                return 750.00;
            case "DVD":
                return 100.00;
            case "Blue Ray":
                return 250.00;
            default:
                return 0.0;
        }
    }

    public double calculaSubtotal() {
        return this.precio * this.cantidad;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getRuc() {
        return ruc;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", ruc='" + ruc + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
