<%-- 
    Document   : index
    Created on : 05-may-2022, 13:15:04
    Author     : Diego Gramajo
--%>

<%@page import="org.models.ModelDetalle_Factura"%>
<%@page import="org.dao.DaoNumFact"%>
<%@page import="org.models.ModelCliente"%>
<%@page import="org.dao.DaoCliente"%>
<%@page import="org.dao.DaoFactura"%>
<%@page import="org.models.ModelTipoPago"%>
<%@page import="org.dao.DaoTipoPago"%>
<%@page import="java.util.List"%>
<%@page import="Servicios.Tipo_Cambio"%>
<%@page import="Services.TCountryCodeAndName"%>
<%@page import="Servicios.ListarPaises"%>
<%@page import="org.dao.DaoFecha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <style>
            .centrar-boton{
                display: flex;
                align-items:flex-end;
                justify-content: center;
            }
        </style>
        <title>Factura</title>
    </head>
    <body class="bg-light container w-75">

        <h1 class="display-4 text-danger text-center">Factura</h1>
        <hr />
        <main>
            <section class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-body">
                            <form class="row"action="ControllerCliente" method="get">
                                <div class="form-grup col-md-1">
                                </div>
                                <div class="form-grup col-md-7">
                                    <label for="">Factura No.00${cFactura}</label>
                                </div>
                                <div class="form-grup col-md-4">
                                    <%
                                        DaoFecha daoFecha = new DaoFecha();
                                        ListarPaises pa = new ListarPaises();
                                        Tipo_Cambio tip = new Tipo_Cambio();
                                        DaoTipoPago daoTipo = new DaoTipoPago();

                                    %>
                                    <label for="">Fecha: <%= daoFecha.Fecha()%></label>
                                </div>
                                <div class="card-header">
                                    <h4 class="card-title">Datos Factura</h4>
                                </div>
                                <div class="form-grup col-md-1">
                                </div>
                                <div class="form-grup col-md-4">
                                    <label for="">Nit:</label>
                                    <input name="nit" type="text" class="form-control" placeholder="Ejm: 123456k" value="${cNit}"/>
                                </div>
                                <div class="form-grup col-md-2 text-center centrar-boton">
                                    <button type="submit" name="accion" value="search" class="btn btn-outline-success">Buscar</button>
                                </div>
                                <div class="form-grup col-md-4">
                                    <label for="">Pais Envio</label>
                                    <select name="pais"id="Pais" class="form-control"value="${cPais}">
                                        <option>---Seleccione---</option>
                                        <%for (TCountryCodeAndName p : pa.ListaP()) {%>
                                        <option value="<%= p.getSName()%>"><%= p.getSName()%></option>
                                        <%}%>
                                    </select>
                                </div>
                                <div class="form-grup col-md-1">
                                </div>    
                                <div class="form-grup col-md-4">
                                    <label for="">Nombre: </label>
                                    <input name="nombre"type="text" class="form-control" readonly="readoly" value="${cNombre}"/>
                                </div>
                                <div class="form-grup col-md-4">
                                    <label for="">Telefono: </label>
                                    <input name="telefono"type="text" class="form-control" readonly="readoly" value="${cTelefono}"/>
                                </div> 
                                <div class="form-grup col-md-4">
                                    <label for="">Direccion: </label>
                                    <input name="direccion"type="text" class="form-control" readonly="readoly" value="${cDireccion}"/>
                                </div> 
                                <div class="form-grup col-md-1">
                                </div>
                                <div class="form-grup col-md-5">
                                    <label for="">Tipo de Pago:</label>
                                    <select name="tipopago" class="form-control">
                                        <option>---Seleccione---</option>
                                        <%for (ModelTipoPago tp : daoTipo.listar()) {%>
                                        <option><%= tp.getDescripcion()%></option>
                                        <%}%>
                                    </select>
                                </div>  
                                <div class="form-grup col-md-5">
                                    <label for="">Comentario:</label>
                                    <input name="comentario"type="text" class="form-control"value="${cComentario}"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section> 
            <section class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-body">
                            <form class="row"action="ControllerDetalle" method="get">
                                <div class="form-grup col-md-3">
                                    <label for="">Tipo Cambio:</label>
                                    <input type="text" class="form-control" value="<%= tip.Cambio()%>"readonly="readoly"/>
                                </div>  
                                <div class="form-grup col-md-3">
                                    <label for="">ID Producto:</label>
                                    <input name="codigo"type="text" class="form-control" placeholder="Ejm: B001"/>
                                </div>
                                <div class="form-grup col-md-3">
                                    <label for="">Cantidad:</label>
                                    <input name="cantidad"type="text" class="form-control" value="1"/>
                                </div>
                                <div class="form-grup col-md-3 text-center centrar-boton">
                                    <button type="submit" name="accion" value="agregar" class="btn btn-outline-success">Agregar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
            <section class="row">
                <div class="col">
                    <table class="table table-dark table-sm">
                        <thead>
                            <tr>
                                <th class="text-center">Producto</th>
                                <th class="text-center">Precio</th>
                                <th class="text-center">Cantidad</th>
                                <th class="text-center">SubTotal Q</th>
                                <th class="text-center">SubTotal $</th>
                            </tr>
                        </thead>
                        <%
                            if (DaoNumFact.Detalle != null) {
                                for (ModelDetalle_Factura dt : DaoNumFact.Detalle) {
                        %>
                        <tbody>
                            <tr>
                                <td class="text-center"><%= dt.getObservacion()%></td>
                                <td class="text-center"><%= dt.getPrecio()%></td>
                                <td class="text-center"><%= dt.getCantidad()%></td>
                                <td class="text-center"><%= dt.getTotal_Linea()%></td>
                                <td class="text-center"><%= dt.getTotal_USD()%></td>
                            </tr>
                            <%}%>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </section>
            <section class="row">
                <div class="col">
                    <div class="card">
                        <div class="card-body">
                            <form class="row" action="ControllerFactura" method="get">
                                <div class="form-grup col-md-6 text-center">
                                    <button type="submit" name="accion" value="save" class="btn btn-outline-primary">Aceptar</button>
                                </div>
                                <div class="form-grup col-md-6 text-center">
                                    <a class="btn btn-outline-danger" href="#"  > Nuevo</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>                    
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
