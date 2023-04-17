package com.example.practicasegundocorte;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import service.ProductoService;
import service.serviceImpl.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/productos.xls", "/productos.html", "/productos"})
public class ProductoXlsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ProductoService service = new ProductoServiceImpl();
        List<Producto> productos = service.listar();
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(productos);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
        resp.setContentType("text/html;charset=UTF-8");
        String servletPath = req.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if (esXls) {
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition",

                    "attachment;filename=productos.xls");
        }
        try (PrintWriter out = resp.getWriter()) {
            if(!esXls) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Listado de Productos</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>Listado de Productos!</h1>");
                out.println("<p><a href=\"" + req.getContextPath() +

                        "/productos.xls" + "\">exportar a xls</a></p>");

                out.println("<p><a href=\"" + req.getContextPath() +

                        "/productos.json" + "\">mostrar json</a></p>");

            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>nombre</th>");
            out.println("<th>tipo</th>");
            out.println("<th>precio</th>");
            out.println("</tr>");
            productos.forEach(p ->{
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                out.println("<td>" + p.getPrecio() + "</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            if(!esXls) {
                out.println(" </body>");
                out.println("</html>");
            }
        }
    }


    //metodo post
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletInputStream jsonStream = req.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Producto producto = mapper.readValue(jsonStream, Producto.class);
        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(" <head>");
            out.println(" <meta charset=\"UTF-8\">");
            out.println(" <title>Detalle de producto desde 0json</title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1>Detalle de producto desde json!</h1>");
            out.println("<ul>");
            out.println("<li>Id: "+ producto.getId() + "</li>");
            out.println("<li>Nombre: " + producto.getNombre() + "</li>");
            out.println("<li>Tipo: " + producto.getTipo() + "</li>");
            out.println("<li>Precio: " + producto.getPrecio() + "</li>");
            out.println("</ul>");
            out.println(" </body>");
            out.println("</html>");
        }
    }
}


