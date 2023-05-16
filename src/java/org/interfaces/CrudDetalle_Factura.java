/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelDetalle_Factura;

/**
 *
 * @author Diego Gramajo
 */
public interface CrudDetalle_Factura {
    public List listar();
    public ModelDetalle_Factura list (int id);
    public boolean insertar(ModelDetalle_Factura detalle_factura);
}
