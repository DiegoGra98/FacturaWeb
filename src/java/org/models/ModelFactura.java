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
public class ModelFactura {
    private int ID;
    private int ID_Cliente;
    private String Observacion;
    private String Pais;
    private int Estado;
    private double Total;
    private double Total_USD;
    private int Tipo_Pago;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getTotal_USD() {
        return Total_USD;
    }

    public void setTotal_USD(double Total_USD) {
        this.Total_USD = Total_USD;
    }

    public int getTipo_Pago() {
        return Tipo_Pago;
    }

    public void setTipo_Pago(int Tipo_Pago) {
        this.Tipo_Pago = Tipo_Pago;
    }

    public ModelFactura() {
    }
    
}
