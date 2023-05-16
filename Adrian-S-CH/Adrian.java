package ListasEnlazadas;

import javax.swing.*;

public class Lista1Modificada {
    static class Producto {
        String codigoProducto;
        String nombreProducto;
        String marcaProducto;
        String fechaVenta;
        String descripcionProducto;
        double precioProducto;
        Producto liga;
    }

    public static void main(String[] args) {
        Producto app = null, aux = null, aux1 = null, aux2 = null;
        byte op = 0;
        String refc;
        while(op!=7) {
            op = Byte.parseByte(JOptionPane.showInputDialog(
                    """
                            Digite su opción:
                            1. Crear lista
                            2. Insertar al principio
                            3. Insertar antes de una referencia
                            4. Insertar después de una referencia
                            5. Eliminar con referencia
                            6. Imprimir
                            7. Salir"""
            ));
            switch (op) {
                case 1:
                    if (app == null) {
                        app = new Producto();
                        app.codigoProducto = JOptionPane.showInputDialog("Ingrese el código del producto");
                        app.nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                        app.marcaProducto = JOptionPane.showInputDialog("Ingrese la marca del producto");
                        app.fechaVenta = JOptionPane.showInputDialog("Ingrese la fecha de venta del producto");
                        app.descripcionProducto = JOptionPane.showInputDialog("Ingrese la descripción del producto");
                        app.precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                        app.liga = null;
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista ya ha sido creada");
                    }
                    break;
                case 2:
                    if (app != null) {
                        aux = new Producto();
                        aux.codigoProducto = JOptionPane.showInputDialog("Ingrese el código del producto");
                        aux.nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                        aux.marcaProducto = JOptionPane.showInputDialog("Ingrese la marca del producto");
                        aux.fechaVenta = JOptionPane.showInputDialog("Ingrese la fecha de venta del producto");
                        aux.descripcionProducto = JOptionPane.showInputDialog("Ingrese la descripción del producto");
                        aux.precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                        aux.liga = app;
                        app = aux;
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista no ha sido creada");
                    }
                    break;
                case 3:
                    if (app != null){
                        refc = JOptionPane.showInputDialog("Ingrese el código del producto");
                        aux = app;
                        while (aux != null && !aux.codigoProducto.equals(refc)){
                            aux2 = aux;
                            aux = aux.liga;
                        }
                        aux1 = new Producto();
                        aux1.codigoProducto = JOptionPane.showInputDialog("Ingrese el código del producto");
                        aux1.nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto");
                        aux1.marcaProducto = JOptionPane.showInputDialog("Ingrese la marca del producto");
                        aux1.fechaVenta = JOptionPane.showInputDialog("Ingrese la fecha de venta (dd/mm/aaaa)");
                        aux1.descripcionProducto = JOptionPane.showInputDialog("Ingrese la descripción del producto");
                        aux1.precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto"));
                        aux1.liga = aux;
                        if (aux == app){
                            app = aux1;
                        } else {
                            aux2.liga = aux1;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista no ha sido creada");
                    }
                    break;
                case 4:
                    if (app != null) {
                        refc = JOptionPane.showInputDialog("Ingrese el nombre del producto después del cual desea insertar:");
                        aux = app;
                        while (aux != null && !aux.nombreProducto.equals(refc)) {
                            aux = aux.liga;
                        }
                        if (aux == null) {
                            JOptionPane.showMessageDialog(null, "No se encontró el producto con el nombre " + refc);
                        } else {
                            aux1 = new Producto();
                            aux1.codigoProducto = JOptionPane.showInputDialog("Ingrese el código del producto:");
                            aux1.nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
                            aux1.marcaProducto = JOptionPane.showInputDialog("Ingrese la marca del producto:");
                            aux1.fechaVenta = JOptionPane.showInputDialog("Ingrese la fecha de venta del producto:");
                            aux1.descripcionProducto = JOptionPane.showInputDialog("Ingrese la descripción del producto:");
                            aux1.precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));

                            aux1.liga = aux.liga;
                            aux.liga = aux1;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista no ha sido creada");
                    }
                    break;
                case 5:
                    if (app != null){
                        refc = JOptionPane.showInputDialog("Ingrese el código del producto a eliminar:");
                        aux = app;
                        while (aux != null && !aux.codigoProducto.equals(refc)){
                            aux2 = aux;
                            aux = aux.liga;
                        }
                        if (aux == null) {
                            JOptionPane.showMessageDialog(null, "El producto no se encuentra en la lista.");
                        } else if (aux == app) {
                            app = aux.liga;
                        } else {
                            aux2.liga = aux.liga;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista no ha sido creada");
                    }
                    break;
                case 6:
                    aux = app;
                    while (aux != null) {
                        JOptionPane.showMessageDialog(null,
                                "Código de producto: " + aux.codigoProducto +
                                        "\nNombre de producto: " + aux.nombreProducto +
                                        "\nMarca de producto: " + aux.marcaProducto +
                                        "\nFecha de venta: " + aux.fechaVenta +
                                        "\nDescripción de producto: " + aux.descripcionProducto +
                                        "\nPrecio de producto: " + aux.precioProducto);
                        aux = aux.liga;
                    }
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null,"Gracias por utilizar el programa");
            }
        }
    }
}
