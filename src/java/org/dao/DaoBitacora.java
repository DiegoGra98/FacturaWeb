/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudBitacora;
import org.models.ModelBitacora;

/**
 *
 * @author Diego Gramajo
 */
public class DaoBitacora implements CrudBitacora{

    //Se crea un objeto publico del Cliente
    ModelBitacora Bitacora = new ModelBitacora();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();
    //Obtiene el resultado de las consultas SQL
    ResultSet rs = null;
    //flag para retornar si la sentencia SQL fue satisfactorio o no
    boolean respuesta = false;
    
    @Override
    public boolean insertar(ModelBitacora bitacora) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO BITACORA  "
                + "VALUES ( (SELECT ISNULL(MAX(ID_BITACORA),0) + 1 FROM BITACORA), " +                   
                 bitacora.getID_Factura() + ", " +                 
                "'" + bitacora.getFecha()+ "', " +                       
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
