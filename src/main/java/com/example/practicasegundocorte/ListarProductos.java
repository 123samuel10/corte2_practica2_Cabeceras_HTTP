package com.example.practicasegundocorte;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ListaProductosService;
import service.LoginService;
import service.serviceImpl.ListaProductosServiceImpl;
import service.serviceImpl.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "ListarProductos",urlPatterns = "/listar")
public class ListarProductos extends HelloServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name="samuel";
        String username = req.getParameter("usarname");
        Cookie usernameCookie = new Cookie("username", username);
        resp.addCookie(usernameCookie);
        System.out.printf(String.valueOf(usernameCookie.getValue()));
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        if (String.valueOf(usernameCookie.getValue()).equals(name)) {

            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>listado de productos</title>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>listado de productos!</h1>");
                out.println(" <h3>- MANGO "+"</h3>");
                out.println(" <h3>- PERA "+"</h3>");
                out.println(" <h3>- SANDIA "+"</h3>");
                out.println(" <h3>- BANANO"+"</h3>");
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

}
