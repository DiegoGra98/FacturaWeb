/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoDetalle_Factura;
import org.dao.DaoFactura;
import org.dao.DaoNumFact;
import org.models.ModelCliente;
import org.models.ModelFactura;

/**
 *
 * @author Diego Gramajo
 */
@WebServlet(name = "ControllerFactura", urlPatterns = {"/ControllerFactura"})
public class ControllerFactura extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String p = request.getParameter("pais");
        String c = request.getParameter("comentario");
        String tp = request.getParameter("tipopago");
        int id_c=0;
        DaoFactura daoFactura = new DaoFactura();
        ModelFactura factura = new ModelFactura();
        DaoDetalle_Factura daoDetalle = new DaoDetalle_Factura();
        for(ModelCliente ct:DaoNumFact.Cliente){
            id_c=ct.getID();
        }
        factura.setEstado(1);
        factura.setID_Cliente(id_c);
        factura.setObservacion(c);
        factura.setPais(p);
        factura.setTipo_Pago(1);
        factura.setTotal(DaoNumFact.total);
        factura.setTotal_USD(DaoNumFact.total_usd);
        daoFactura.insertar(factura);
        DaoNumFact.Detalle.forEach((dt) -> {
            daoDetalle.insertar(dt);
        });
        DaoNumFact.total=0;
        DaoNumFact.total_usd=0;
        DaoNumFact.num++;
        DaoNumFact.Detalle=new ArrayList();
        DaoNumFact.Cliente=new ArrayList();
        request.getRequestDispatcher("index.jsp").forward(request, response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerFactura</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerFactura at " + request.getContextPath() + "</h1>");
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
