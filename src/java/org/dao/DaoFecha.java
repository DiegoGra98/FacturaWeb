/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Diego Gramajo
 */
public class DaoFecha {

    public String Fecha(){
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        String f = formatofecha.format(fecha);
        System.out.println(f);
       
        return f;
    }
    public DaoFecha() {
    }
    
}
