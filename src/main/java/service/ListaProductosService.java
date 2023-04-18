package service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface ListaProductosService {
    Optional<String> getUsername(HttpServletRequest req);
}
