/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.util.ArrayList;
import org.models.ModelCliente;
import org.models.ModelDetalle_Factura;

/**
 *
 * @author Diego Gramajo
 */
public class DaoNumFact {
    public static int num;
    public static ArrayList<ModelDetalle_Factura> Detalle;
    public static ArrayList<ModelCliente> Cliente;
    public static double total;
    public static double total_usd;
}
