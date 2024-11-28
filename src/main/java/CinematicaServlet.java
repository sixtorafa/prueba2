import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/CinematicaServlet")
public class CinematicaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener datos del formulario
        double aceleracion = Double.parseDouble(request.getParameter("aceleracion"));
        double velocidad = Double.parseDouble(request.getParameter("velocidad"));
        double tiempoAdicional = Double.parseDouble(request.getParameter("tiempoAdicional"));

        // Cálculos
        double tiempo = velocidad / aceleracion;
        double distancia = 0.5 * aceleracion * Math.pow(tiempo, 2);
        double velocidadFinal = velocidad + aceleracion * tiempoAdicional;
        double distanciaTotal = distancia + velocidad * tiempoAdicional + 0.5 * aceleracion * Math.pow(tiempoAdicional, 2);

        // Enviar resultados a la página JSP
        request.setAttribute("tiempo", tiempo);
        request.setAttribute("distancia", distancia);
        request.setAttribute("velocidadFinal", velocidadFinal);
        request.setAttribute("distanciaTotal", distanciaTotal);

        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}