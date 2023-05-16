/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.models;

/**
 *
 * @author Diego Gramajo
 */
public class ModelDetalle_Factura {
    private int ID_Detalle;
    private int ID_Factura;
    private int ID_Producto;
    private int Cantidad;
    private double Precio;
    private double Total_Linea;
    private String Observacion;
    private double Total_USD;

    public int getID_Detalle() {
        return ID_Detalle;
    }

    public void setID_Detalle(int ID_Detalle) {
        this.ID_Detalle = ID_Detalle;
    }

    public int getID_Factura() {
        return ID_Factura;
    }

    public void setID_Factura(int ID_Factura) {
        this.ID_Factura = ID_Factura;
    }

    public int getID_Producto() {
        return ID_Producto;
    }

    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getTotal_Linea() {
        return Total_Linea;
    }

    public void setTotal_Linea(double Total_Linea) {
        this.Total_Linea = Total_Linea;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public double getTotal_USD() {
        return Total_USD;
    }

    public void setTotal_USD(double Total_USD) {
        this.Total_USD = Total_USD;
    }
    

    public ModelDetalle_Factura() {
    }
    
}
