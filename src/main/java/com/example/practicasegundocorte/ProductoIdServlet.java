package com.example.practicasegundocorte;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;
import model.Producto2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ProductoIdServlet",urlPatterns = "/buscar")
public class ProductoIdServlet extends HelloServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Producto2 producto=new Producto2("mango","2");
        String buscarId=req.getParameter("id");

            if (producto.getId().equals(buscarId)) {
                resp.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = resp.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println(" <head>");
                    out.println(" <meta charset=\"UTF-8\">");
                    out.println(" <title>producto encontrado</title>");
                    out.println(" </head>");
                    out.println(" <body>");
                    out.println(" <h1>producto encontrado!</h1>");
                    out.println(" <h3>el producto con ese codigo es "+producto.getProducto() +"</h3>");
                    out.println(" </body>");
                    out.println("</html>");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
//----------------------------------------------------------------------------------------------------------



    }
}
