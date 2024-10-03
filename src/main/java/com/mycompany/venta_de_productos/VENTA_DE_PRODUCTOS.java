/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.venta_de_productos;

import Vista.VentasInicial;



/**
 *
 * @author USER 17
 */
public class VENTA_DE_PRODUCTOS {

   public static void main(String args[]) {

try {
    // Set Texture Look and Feel from JTattoo
    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
} catch (ClassNotFoundException ex) {
    java.util.logging.Logger.getLogger(VENTA_DE_PRODUCTOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
    java.util.logging.Logger.getLogger(VENTA_DE_PRODUCTOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
    java.util.logging.Logger.getLogger(VENTA_DE_PRODUCTOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(VENTA_DE_PRODUCTOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasInicial().setVisible(true);
            }
        });
    }
}
