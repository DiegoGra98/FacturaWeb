/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import Servicios.Tipo_Cambio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoNumFact;
import org.dao.DaoProducto;
import org.models.ModelCliente;
import org.models.ModelDetalle_Factura;
import org.models.ModelProducto;

/**
 *
 * @author Diego Gramajo
 */
@WebServlet(name = "ControllerDetalle", urlPatterns = {"/ControllerDetalle"})
public class ControllerDetalle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String n ="";
        String nom ="";
        String Dire ="";
        String tel ="";
        String fact = String.valueOf(DaoNumFact.num);
        String cod = request.getParameter("codigo");
        String cant = request.getParameter("cantidad");
        int codigo = Integer.valueOf(cod);
        int cantidad = Integer.valueOf(cant);
        for(ModelCliente c:DaoNumFact.Cliente){
            n = c.getNit();
            nom = c.getNombre()+" "+c.getDireccion();
            Dire = c.getDireccion();
            tel = c.getTelefono();
        }
        DaoProducto daoProducto = new DaoProducto();
        Tipo_Cambio tipo = new Tipo_Cambio();
        ModelProducto producto = daoProducto.list(codigo);
        ModelDetalle_Factura detalle_factura = new ModelDetalle_Factura();
        detalle_factura.setCantidad(cantidad);
        detalle_factura.setID_Producto(codigo);
        detalle_factura.setObservacion(producto.getDescripcion());
        detalle_factura.setPrecio(producto.getPrecion());
        detalle_factura.setTotal_Linea(cantidad*producto.getPrecion());
        detalle_factura.setTotal_USD(detalle_factura.getTotal_Linea()/tipo.Cambio());
        detalle_factura.setID_Factura(DaoNumFact.num);
        DaoNumFact.Detalle.add(detalle_factura);
        DaoNumFact.total_usd = DaoNumFact.total_usd+detalle_factura.getTotal_USD();
        DaoNumFact.total = DaoNumFact.total+detalle_factura.getTotal_Linea();
        
        request.setAttribute("cNit", n);
        request.setAttribute("cFactura", fact);
        request.setAttribute("cDireccion", Dire);
        request.setAttribute("cNombre", nom);
        request.setAttribute("cNombre", nom);
        request.setAttribute("cTelefono", tel);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerDetalle</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerDetalle at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
