/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudDetalle_Factura;
import org.models.ModelDetalle_Factura;

/**
 *
 * @author Diego Gramajo
 */
public class DaoDetalle_Factura implements CrudDetalle_Factura{

    //Se crea un objeto publico del Cliente
    ModelDetalle_Factura detalle_factura = new ModelDetalle_Factura();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    
    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModelDetalle_Factura list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(ModelDetalle_Factura detalle_factura) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO DETALLE_FACTURA  "
                + "VALUES ( (SELECT ISNULL(MAX(ID_DETALLE_FACTURA),0) + 1 FROM DETALLE_FACTURA), " +                   
                 detalle_factura.getID_Factura() + ", " +                 
                 detalle_factura.getID_Producto()+ ", " +       
                 detalle_factura.getCantidad() + ", " +
                 detalle_factura.getPrecio()+ ", " +
                 detalle_factura.getTotal_Linea()+ ", " +     
                "'"+detalle_factura.getObservacion()+"'"+
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
