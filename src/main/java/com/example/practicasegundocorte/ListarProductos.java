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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ListaProductosService auth = new ListaProductosServiceImpl();
        Optional<String> cookieOptional = auth.getUsername(request);
        if (cookieOptional.isPresent()) {
            Cookie usernameCookie = new Cookie("username", "");
            usernameCookie.setMaxAge(0);
            response.addCookie(usernameCookie);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");

                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>Hola " + cookieOptional.get() +

                        "</title>");

                out.println(" </head>");
                out.println(" <body>");
                out.println(" <h1>Hola " + cookieOptional.get() + " has iniciado sesión con éxito!</h1>");

                out.println("<p><a href='" + request.getContextPath() +

                        "/index.html'>volver</a></p>");

                out.println("<p><a href='" + request.getContextPath() +

                        "/logout'>cerrar sesión</a></p>");
                out.println(" </body>");
                out.println("</html>");
            }
        } else {
            try {
                getServletContext().getRequestDispatcher("/login.jsp").forward(request,
                        response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name="samuel";
        String username = req.getParameter("usarname");

        System.out.printf(username);
        if (username.equals(name)) {
            Cookie usernameCookie = new Cookie("username", username);
            resp.addCookie(usernameCookie);
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
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
