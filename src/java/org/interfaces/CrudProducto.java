/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelProducto;

/**
 *
 * @author Diego Gramajo
 */
public interface CrudProducto {
    public List listar();
    public ModelProducto list (int id);
    public boolean modificar(ModelProducto producto);
}
