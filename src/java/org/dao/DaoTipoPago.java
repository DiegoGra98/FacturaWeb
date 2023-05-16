/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudTipoPago;
import org.models.ModelTipoPago;

/**
 *
 * @author Diego Gramajo
 */
public class DaoTipoPago implements CrudTipoPago {
    //Se crea un objeto publico del Cliente
    ModelTipoPago pago = new ModelTipoPago();
    //Variable para crear las sentencias SQL
    String strSql = "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;

    @Override
    public List<ModelTipoPago> listar() {
        List<ModelTipoPago>lstPago = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM TIPO_PAGO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelTipoPago tip = new ModelTipoPago();
                tip.setID(rs.getInt("ID_TIPO_PAGO"));
                tip.setDescripcion(rs.getString("DESCRIPCION"));
                lstPago.add(tip);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstPago;
    }

}
