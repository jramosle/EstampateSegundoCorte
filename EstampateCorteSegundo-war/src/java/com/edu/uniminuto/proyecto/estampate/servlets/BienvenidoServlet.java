package com.edu.uniminuto.proyecto.estampate.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Genera el el mensaje de exito cuando se realizó el login exitosamente.
 * @author Jefersson Ramos
 */
@WebServlet(urlPatterns = {BienvenidoServlet.URL_PATTERN_WELCOME})
public class BienvenidoServlet extends HttpServlet {

    public static final String USER_PARAMETER = "usuario";
    public static final String RESPONSE_CONTENT_TYPE = "text/html";
    public static final String AUTHENTICATION_MESSAGE = "Bienvenido ";
    public static final String REQUEST_DISPATCHER_TO_LOGIN = "menuAdmin.html";
    public static final String URL_PATTERN_WELCOME = "/bienvenidoServlet";

    /**
     * Genera mensaje de Exito al generar una autenticación exitosa.
     *
     * @author Jefersson Ramos
     * @param request Servlet Contiene la petición POST recibida.
     * @param response Servlet Repesenta una referencia al response de la
     * petición HTTP.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     *
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(RESPONSE_CONTENT_TYPE);

        try (PrintWriter printWriter = response.getWriter()) {

            String usuario = request.getParameter(USER_PARAMETER);
            printWriter.print(AUTHENTICATION_MESSAGE + usuario);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(REQUEST_DISPATCHER_TO_LOGIN);

            requestDispatcher.include(request, response);
        }
    }
}