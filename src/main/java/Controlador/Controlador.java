/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import modelo.Arraylist;
import modelo.Contado;
import modelo.Credito;
import Vista.ContadoVentas;
import Vista.CreditoVentas;
import javax.swing.JOptionPane;

public class Controlador {
    private Arraylist gestorVentas; // Modelo para almacenar ventas
    private ContadoVentas vistaContado; // Vista para ventas al contado
    private CreditoVentas vistaCredito; // Vista para ventas al crédito

    // Constructor del controlador
    public Controlador(ContadoVentas vistaContado, CreditoVentas vistaCredito) {
        this.gestorVentas = new Arraylist();
        this.vistaContado = vistaContado;
        this.vistaCredito = vistaCredito;

        // Agregar listeners a los botones de las vistas
        this.vistaContado.getBtnAdquirir().addActionListener(e -> manejarVentaContado());
        this.vistaCredito.getBtnAdquirir().addActionListener(e -> manejarVentaCredito());
        this.vistaContado.getBtnRegresar().addActionListener(e -> regresarAFinal());
        this.vistaCredito.getBtnRegresar().addActionListener(e -> regresarAFinal());
    }

private void manejarVentaContado() {
    // Obtener los datos de la vista
    String nombreCliente = vistaContado.getTextCliente();
    String ruc = vistaContado.getTextRuc();
    String fecha = vistaContado.getFecha();
    String hora = vistaContado.getHora();
    String nombreProducto = vistaContado.getProductoSeleccionado();
    int cantidad = vistaContado.getCantidad();

    // Validar datos
    if (nombreCliente.isEmpty() || ruc.isEmpty() || cantidad <= 0) {
        JOptionPane.showMessageDialog(vistaContado, "Por favor, completa todos los campos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear la venta al contado
    Contado ventaContado = new Contado(nombreCliente, ruc, fecha, hora, nombreProducto, cantidad);
    gestorVentas.agregarVenta(ventaContado);

    // Calcular subtotal y descuento
    double subtotal = ventaContado.calculaSubtotal();
    double descuento = ventaContado.calculaDescuento(subtotal);

    // Actualizar la vista (tabla, resumen, etc.)
    vistaContado.actualizarTabla(gestorVentas.getVentas());
    vistaContado.actualizarResumen(nombreCliente, ruc, fecha, hora, subtotal, descuento, subtotal - descuento);
}
    
private void manejarVentaCredito() {
    // Obtener los datos de la vista
    String nombreCliente = vistaCredito.getTextCliente();
    String ruc = vistaCredito.getTextRuc();
    String fecha = vistaCredito.getFecha();
    String hora = vistaCredito.getHora();
    String nombreProducto = vistaCredito.getProductoSeleccionado();
    int cantidad = vistaCredito.getCantidad();
    int letras = vistaCredito.getLetras(); // Obtener el número de letras

    // Validar datos
    if (nombreCliente.isEmpty() || ruc.isEmpty() || cantidad <= 0 || letras <= 0) {
        JOptionPane.showMessageDialog(vistaCredito, "Por favor, completa todos los campos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear la venta al crédito
    Credito ventaCredito = new Credito(nombreCliente, ruc, fecha, hora, nombreProducto, cantidad, letras);
    gestorVentas.agregarVenta(ventaCredito);

    // Calcular subtotal, descuento y monto mensual
    double subtotal = ventaCredito.calculaSubtotal();
    double descuento = ventaCredito.calculaDescuento();
    double montoMensual = ventaCredito.calculaMontoMensual();

    // Actualizar la vista (tabla, resumen, etc.)
    vistaCredito.actualizarTabla(gestorVentas.getVentas());
}



    // Método para regresar a la ventana principal
    private void regresarAFinal() {
        vistaContado.setVisible(true); // Mostrar la vista de ventas al contado
        vistaCredito.setVisible(false); // Ocultar la vista de ventas al crédito
    }
}
