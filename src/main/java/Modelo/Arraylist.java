/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

public class Arraylist {
    private ArrayList<Venta> ventas;

    public Arraylist() {
        ventas = new ArrayList<>();
    }

    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public void eliminarVenta(int index) {
        if (index >= 0 && index < ventas.size()) {
            ventas.remove(index);
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    public Venta obtenerVenta(int index) {
        if (index >= 0 && index < ventas.size()) {
            return ventas.get(index);
        } else {
            System.out.println("Índice fuera de rango.");
            return null;
        }
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void listarVentas() {
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (int i = 0; i < ventas.size(); i++) {
                System.out.println((i + 1) + ". " + ventas.get(i).toString());
            }
        }
    }

    public void buscarVentasPorCliente(String nombreCliente) {
        boolean found = false;
        for (Venta venta : ventas) {
            if (venta.getNombreCliente().toLowerCase().contains(nombreCliente.toLowerCase())) {
                System.out.println(venta.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No se encontraron ventas para el cliente: " + nombreCliente);
        }
    }

    // Método para listar solo ventas al contado
    public void listarVentasContado() {
        for (Venta venta : ventas) {
            if (venta instanceof Contado) {
                System.out.println(venta);
            }
        }
    }

    // Método para listar solo ventas al crédito
    public void listarVentasCredito() {
        for (Venta venta : ventas) {
            if (venta instanceof Credito) {
                System.out.println(venta);
            }
        }
    }
}
