package com.example.practicasegundocorte;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String metodoHttp = request.getMethod();// es un método que se utiliza en Java Servlets para obtener el método HTTP utilizado en la solicitud actual. Devuelve una cadena que representa el nombre del método HTTP utilizado, como GET, POST, PUT, DELETE, etc.

        String requestUri = request.getRequestURI();// es un método que se utiliza en Java Servlets para obtener la parte de la URL que representa la ruta de la solicitud actual. Devuelve una cadena que representa la ruta de la solicitud relativa al contexto de la aplicación.
        String requestUrl = request.getRequestURL().toString();// es un método que se utiliza en Java Servlets para obtener la URL de la solicitud actual. Devuelve una cadena que representa la URL completa de la solicitud, incluido el protocolo, el nombre del host, el número de puerto y la ruta relativa.
        String contexPath = request.getContextPath();//  es un método que se utiliza en Java Servlets para obtener el nombre del contexto de la aplicación web. Devuelve una cadena que representa el nombre del contexto de la aplicación.
        String servletPath = request.getServletPath();//es un método que se utiliza en Java Servlets para obtener la ruta del servlet que está procesando la solicitud actual. Devuelve una cadena que representa la parte de la URL de la solicitud que corresponde al patrón de asignación del servlet.
        String ipCliente = request.getRemoteAddr();// es un método que se utiliza en Java Servlets para obtener la dirección IP del cliente que realizó la solicitud. Devuelve una cadena que representa la dirección IP del cliente.
        String ip = request.getLocalAddr();//es un método que se utiliza en Java Servlets para obtener la dirección IP del servidor en el que se está ejecutando la aplicación web. Devuelve una cadena que representa la dirección IP del servidor.
        int port = request.getLocalPort();//es un método que se utiliza en Java Servlets para obtener el número de puerto en el servidor en el que se está ejecutando la aplicación web. Devuelve un entero que representa el número de puerto local del servidor.
        String scheme = request.getScheme();// obtener el esquema de la URL utilizada en la solicitud. Devuelve una cadena que representa el esquema de la URL utilizado en la solicitud.
        String host = request.getHeader("host");// para obtener el valor del encabezado "Host" de la solicitud HTTP. Devuelve una cadena que representa el valor del encabezado "Host" de la solicitud.
        String url = scheme + "://" + host + contexPath + servletPath;
        String url2 = scheme + "://" + ip + ":" + port + contexPath + servletPath;
    }

    public void destroy() {
    }
}