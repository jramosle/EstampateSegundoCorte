/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uniminuto.proyecto.estampate.servlets;

import com.unimininuto.estampate.entities.UsuarioRol;
import com.unimininuto.estampate.ejb.interfaces.UsuarioRolFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRISTOPHER
 */
@WebServlet(name = "LoginServlet2", urlPatterns = {"/LoginServlet2"})
public class LoginServlet2 extends HttpServlet {

//    @EJB
//    private UsuarioRolFacadeLocal usuarioRolFacade;
//    
    public static final String USER_PARAMETER = "usuario";
    public static final String PASSWORD_PARAMETER = "pass";
    public static final String REQUEST_DISPATCHER_TO_ADMIN = "menuAdmin.html";
    public static final String REQUEST_DISPATCHER_TO_ARTISTA = "menuArtista.html";
    public static final String REQUEST_DISPATCHER_TO_COMPRADOR = "menuComprador.html";
    public static final String REQUEST_DISPATCHER_TO_WELCOME = "bienvenidoServlet";
    public static final String RESPONSE_CONTENT_TYPE = "text/html";
    public static final String INVALID_AUTHENTICATION_MESSAGE = "El usuario o la contraseña son incorrectos";
    public static final String REQUEST_DISPATCHER_TO_LOGIN = "login.html";
    public static final String URL_PATTERN_LOGIN = "/loginServlet";
        
    
    /**
     * Realiza la autenticación de un usuario contra BD.
     *
     * @param request Servlet Contiene la petición POST recibida.
     * @param response Servlet Repesenta una referencia al response de la 
     *                 petición HTTP.
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType(RESPONSE_CONTENT_TYPE);
        
        try (PrintWriter out = response.getWriter()) {
            
            
            List<UsuarioRol> usuarioRols = new ArrayList<>();
            
            
            String usuarioAValidar = request.getParameter(USER_PARAMETER);
            String passwordAValidar = request.getParameter(PASSWORD_PARAMETER);
            RequestDispatcher requestDispatcher;
                    
            try {
//               usuarioRols usuarioRolFacade.findAll();
//                usuarioRols = usuarioRolFacade.validarUsuarios(usuarioAValidar, passwordAValidar);
            } catch (Exception ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (usuarioRols.size() > 0 ) {
                
                switch (usuarioRols.get(0).getIdusuariorol()) {
                    case 1:
                        requestDispatcher = request.getRequestDispatcher(REQUEST_DISPATCHER_TO_ADMIN);
                        requestDispatcher.forward(request, response);
                        break;
                    case 2:
                        requestDispatcher = request.getRequestDispatcher(REQUEST_DISPATCHER_TO_ARTISTA);
                        requestDispatcher.forward(request, response);
                        break;
                    case 3:
                        requestDispatcher = request.getRequestDispatcher(REQUEST_DISPATCHER_TO_COMPRADOR);
                        requestDispatcher.forward(request, response);
                        break;
                    default:
                        break;
                }
            
            } else {
                
                out.print(INVALID_AUTHENTICATION_MESSAGE);
                requestDispatcher = request.getRequestDispatcher(REQUEST_DISPATCHER_TO_LOGIN);
                
                requestDispatcher.include(request, response);
            }
        }
    }
}
