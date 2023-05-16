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
import org.interfaces.CrudFactura;
import org.models.ModelFactura;

/**
 *
 * @author Diego Gramajo
 */
public class DaoFactura implements CrudFactura{

    //Se crea un objeto publico de la factura
    ModelFactura factura = new ModelFactura();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    
    @Override
    public List<ModelFactura> listar() {
        List<ModelFactura>lstFactura = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM FACTURA";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelFactura fact = new ModelFactura();
                fact.setID(rs.getInt("ID_FACTURA"));
                lstFactura.add(fact);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstFactura;
    }

    @Override
    public ModelFactura list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(ModelFactura factura) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO FACTURA "
                + "VALUES ( (SELECT ISNULL(MAX(ID_FACTURA),0) + 1 FROM FACTURA), " +                   
                 factura.getID_Cliente() + ", " +                 
                "'" + factura.getObservacion()+ "', " +       
                 "'" + factura.getPais() + "', " +
                factura.getEstado()+ ", " +
                factura.getTotal()+ ", " +
                factura.getTotal_USD()+", "+
                factura.getTipo_Pago()+
                  ")";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }
    
}
