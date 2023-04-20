package com.example.practicasegundocorte;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Producto;
import model.Producto2;
import service.serviceImpl.BuscarIdServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ProductoIdServlet",urlPatterns = "/buscar")
public class ProductoIdServlet extends HelloServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buscarId=req.getParameter("id");
        BuscarIdServiceImpl productoD=new BuscarIdServiceImpl();
        productoD.add("mango","2");
        productoD.add("pera","3");
        List<Producto2> productos=productoD.getProductoDos().stream().filter(x->x.getId().equals(buscarId)).collect(Collectors.toList());
        if (productos.size()==1) {
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
                    out.println(" <h3>el producto con ese codigo es "+productos.get(0).getProducto() +"</h3>");
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

        }


//----------------------------------------------------------------------------------------------------------



    }

