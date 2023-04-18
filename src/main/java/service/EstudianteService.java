package service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface EstudianteService {
    void guardarEstudiante(String nombre,String contraseña);
    Optional<String> getUsername(HttpServletRequest req);
}
