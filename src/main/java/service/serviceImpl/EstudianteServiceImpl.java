package service.serviceImpl;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import model.Estudiante;
import service.EstudianteService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class EstudianteServiceImpl implements EstudianteService {
    ArrayList<Estudiante> estudiantes = new ArrayList<>();

    @Override
    public void guardarEstudiante(String nombre, String contraseña) {
        estudiantes.add(new Estudiante(nombre, contraseña));

    }

    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new
                Cookie[0];
        return Arrays.stream(cookies)

                .filter(c-> "username".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
