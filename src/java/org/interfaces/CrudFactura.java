/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelFactura;

/**
 *
 * @author Diego Gramajo
 */
public interface CrudFactura {
    public List<ModelFactura> listar();
    public ModelFactura list (int id);
    public boolean insertar(ModelFactura factura);
}
