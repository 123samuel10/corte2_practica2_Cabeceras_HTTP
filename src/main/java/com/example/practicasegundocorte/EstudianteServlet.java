package com.example.practicasegundocorte;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Estudiante;
import service.serviceImpl.EstudianteServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "EstudianteServlet",urlPatterns = "/registroE")
public class EstudianteServlet extends HelloServlet {
    EstudianteServiceImpl estudianteService = new EstudianteServiceImpl();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("usarname");
        String password = req.getParameter("password");
        estudianteService.guardarEstudiante(username, password);


        if (username.equals(username) && password.equals(password)) {
            resp.setContentType("text/html;charset=UTF-8");
            Cookie usernameCookie = new Cookie("username", username);
            resp.addCookie(usernameCookie);
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println(" <head>");
                out.println(" <meta charset=\"UTF-8\">");
                out.println(" <title>TE HAS REGISTRADO CORRECTAMENTE</title>");
                out.println(" <h3>Hola " + username + " te has registrado bien</h3>");
                out.println(" </head>");
                out.println(" <body>");
                out.println(" </body>");
                out.println("</html>");
            }
        } else {
            try {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        //------------------------------------------------------------------------------------

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombre2 = request.getParameter("usarname2");
        String contraseña2 = request.getParameter("password2");
        System.out.printf(nombre2);
        for (Estudiante estudiante : estudianteService.getEstudiantes()) {
            if (estudiante.getNombre() != null && estudiante.getNombre().equals(nombre2) && estudiante.getContraseña().equals(contraseña2)) {

                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println(" <head>");
                    out.println(" <meta charset=\"UTF-8\">");
                    out.println(" <title>HAS INICIADO SECCION CORRECTAMENTE</title>");
                    out.println(" <h3>Hola " + nombre2 + " acabastes de iniciar seccion</h3>");
                    out.println(" </head>");
                    out.println(" <body>");
                    out.println(" </body>");
                    out.println("</html>");
                }
            } else {
                try {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado para ingresar a esta página!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        }
    }
}




