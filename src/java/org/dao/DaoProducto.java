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
import org.interfaces.CrudProducto;
import org.models.ModelProducto;

/**
 *
 * @author Diego Gramajo
 */
public class DaoProducto implements CrudProducto{

    //Se crea un objeto publico del Cliente
    ModelProducto producto = new ModelProducto();
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
    public ModelProducto list(int id) {
        try {            
            strSql = "SELECT * FROM PRODUCTO WHERE ID_PRODUCTO = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {                
                producto.setID(rs.getInt("ID_PRODUCTO"));
                producto.setDescripcion(rs.getString("DESCRIPCION"));
                producto.setPrecion(rs.getDouble("PRECIO"));
                producto.setExistencia(rs.getInt("EXISTENCIA"));
                producto.setEstado(rs.getInt("ESTADO"));          
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return producto;
    }

    @Override
    public boolean modificar(ModelProducto producto) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE PRODUCTO " +
                 "SET " +
                 "EXISTENCIA = " + producto.getExistencia() + " " +
                 "WHERE ID_PRODUCTO =  " + producto.getID();
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
