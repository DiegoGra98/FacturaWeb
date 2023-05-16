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
import org.dao.DaoCliente;
import org.dao.DaoFactura;
import org.dao.DaoNumFact;
import org.models.ModelCliente;

/**
 *
 * @author Diego Gramajo
 */
@WebServlet(name = "ControllerCliente", urlPatterns = {"/ControllerCliente"})
public class ControllerCliente extends HttpServlet {

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
        String n = request.getParameter("nit");
        String nom = "";
        String Dire = "";
        String tel = "";
        DaoFactura factura = new DaoFactura();
        if(factura.listar()!=null){
            DaoNumFact.num = factura.listar().size()+1;
        }else{
             DaoNumFact.num = 1;
        }
        String fact = String.valueOf(DaoNumFact.num);
        DaoNumFact.Cliente = new ArrayList();
        DaoNumFact.Detalle = new ArrayList();
        DaoNumFact.total_usd = 0;
        DaoNumFact.total = 0;
        DaoCliente daoCliente = new DaoCliente();
        ModelCliente cliente = daoCliente.list(n);
        nom= cliente.getNombre()+" "+cliente.getApellido();
        Dire = cliente.getDireccion();
        tel = cliente.getTelefono();
        DaoNumFact.Cliente.add(cliente);
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
            out.println("<title>Servlet ControllerCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCliente at " + request.getContextPath() + "</h1>");
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
