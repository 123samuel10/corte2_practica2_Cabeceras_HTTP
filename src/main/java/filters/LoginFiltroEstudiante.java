package filters;

import com.example.practicasegundocorte.EstudianteServlet;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EstudianteService;
import service.LoginService;
import service.serviceImpl.EstudianteServiceImpl;
import service.serviceImpl.LoginServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/registroE"})//url que deseamos aplique el filtro
public class LoginFiltroEstudiante implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        EstudianteService service = new EstudianteServiceImpl();
        Optional<String> username = service.getUsername((HttpServletRequest)
                request);
        if (username.isPresent()) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "No estás autorizado para ingresar a esta página!");
        }
    }
}
