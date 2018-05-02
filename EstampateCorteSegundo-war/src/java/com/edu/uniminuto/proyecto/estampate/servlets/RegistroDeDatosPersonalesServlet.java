/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uniminuto.proyecto.estampate.servlets;

import static com.edu.uniminuto.proyecto.estampate.servlets.LoginServlet.REQUEST_DISPATCHER_TO_ADMIN;
import com.unimininuto.estampate.ejb.UsuarioRolFacade;
import com.unimininuto.estampate.ejb.interfaces.RolesFacadeLocal;
import com.unimininuto.estampate.ejb.interfaces.UsuariosFacadeLocal;
import com.unimininuto.estampate.entities.Roles;
import com.unimininuto.estampate.entities.UsuarioRol;
import com.unimininuto.estampate.entities.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nectia
 */
@WebServlet(name = "RegistroDeDatosPersonales", urlPatterns = {"/RegistroDeDatosPersonales"})
public class RegistroDeDatosPersonalesServlet extends HttpServlet {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    @EJB
    private RolesFacadeLocal rolesFacade;

    @EJB
    private UsuarioRolFacade usuarioRolFacade;

    List<UsuarioRol> usuarioRolList = new ArrayList<>();
    UsuarioRol usuarioRolEdit = new UsuarioRol();
    String id = "";
    String accion = "";

    public static final String REQUEST_DISPATCHER_TO_ARTISTA = "menuArtista.html";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <script type=\"text/javascript\" src=\"lib/jquery-1.11.2.min.js\"></script>\n"
                    + "        <link rel=StyleSheet HREF=\"styles.css\" TYPE=\"text/css\" MEDIA=screen>"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "     <div id=\"caja\">");

            if ("consultar".equals(accion)) {
                out.println("<form action=\"RegistroDeDatosPersonales\" method=\"post\">\n"
                        + "<table>\n"
                        + "  <tr>\n"
                        + "    <th></th>\n"
                        + "    <th>usuario</th>\n"
                        + "    <th>rol</th>\n"
                        + "    <th>username</th>\n"
                        + "    <th>pass</th>\n"
                        + "  </tr>\n");

                usuarioRolList.forEach((usuarioRol) -> {

                    out.print("  <tr>\n"
                            + "    <td><input type=\"radio\" name=\"selected\" value=" + usuarioRol.getIdusuariorol() + "></td>\n"
                            + "    <td>" + usuarioRol.getIdusuario().getNombreusuario() + "</td>\n"
                            + "    <td>" + usuarioRol.getIdrol().getNombrerol() + "</td>\n"
                            + "    <td>" + usuarioRol.getUsername() + "</td>\n"
                            + "    <td>" + usuarioRol.getPass() + "</td>\n"
                            + "  </tr>\n");
                });
                out.print("</table>"
                        + "<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"eliminar\">"
                        + "<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"editar\">"
                        + "</form>");

            } else if ("insertar".equals(accion)) {

                out.println(" <form action=\"RegistroDeDatosPersonales\" method=\"post\">\n"
                        + "            Persona:<br>\n");
                out.print("<select name=\"selectUsuario\">");

                usuariosFacade.findAll().forEach((llave) -> {
                    out.print("<option value=\"" + llave.getIdusuario() + "\">" + llave.getNombreusuario() + "</option>");
                });
                out.print("</select><br>");
                out.print("Rol:<br>\n"
                        + "<select name=\"selectRol\">");

                rolesFacade.findAll().forEach((llave) -> {
                    out.print("<option value=\"" + llave.getIdrol() + "\">" + llave.getNombrerol() + "</option>");
                });
                out.print("</select>");
                out.println("<br>\n"
                        + "            User:<br>\n"
                        + "            <input type=\"text\" name=\"user\" value=\"\" placeholder=\"user\">\n"
                        + "            <br>\n"
                        + "            Password:<br>\n"
                        + "            <input type=\"text\" name=\"password\" value=\"\" placeholder=\"password\">\n"
                        + "            <br>\n"
                        + "            <br>\n"
                        + "            <input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"guardar\">\n"
                        + "        </form> ");

            } else if ("editar".equals(accion)) {

                out.println(" <form action=\"RegistroDeDatosPersonales\" method=\"post\">"
                        + "            Nombre usuario:<br>\n"
                        + "            <input type=\"text\" name=\"nombreUsuario\" value=" + usuarioRolEdit.getIdusuario().getNombreusuario() + " placeholder=\"nombre\" required readonly>\n"
                        + "            <br>\n"
                        + "            Rol:<br>\n"
                        + "            <input type=\"text\" name=\"rol\" value=" + usuarioRolEdit.getIdrol().getNombrerol() + " required readonly>\n"
                        + "            <br>\n"
                        + "            Username: \n"
                        + "            <br>\n"
                        + "            <input type=\"text\" name=\"username\" value=" + usuarioRolEdit.getUsername() + " placeholder=\"cedula\" required>\n"
                        + "            <br>\n"
                        + "            Pass: \n"
                        + "            <br>\n"
                        + "            <input type=\"text\" name=\"pass\" value=" + usuarioRolEdit.getPass() + " placeholder=\"email\" required>\n"
                        + "            <br>\n"
                        + "            <input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"actualizar\">\n"
                        + "        </form>");

            }

            out.print("<form action=\"RegistroDeDatosPersonales\" method=\"post\" >");
            out.print("<br>");
            out.print("<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"consultar\">");
            out.print("<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"insertar\">");
            out.print("<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"cancelar\">");
            out.print("</br>");

            out.print("</form>");

//                if (usuariosCon.size() > 0) {
//
//                    out.print("<h1> " + usuariosCon.get(0).getCedulausuario() + "<h1>");
//
//                }
            out.print("</div>");
            out.println(
                    "    </body>\n"
                    + "</html>\n"
                    + "");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher requestDispatcher;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        id = request.getParameter("id");
        accion = request.getParameter("ejecutar");

        UsuarioRol usuarioRol;

        if (accion != null) {
            request.getParameter("selected");
            switch (accion) {
                case "eliminar":
                    usuarioRol = new UsuarioRol();
                    usuarioRol.setIdusuariorol(Integer.parseInt(request.getParameter("selected")));
                    usuarioRolFacade.remove(usuarioRol);
                    break;
                case "consultar":
                    usuarioRolList = usuarioRolFacade.findAll();
                    break;
                case "guardar":

                    usuarioRol = new UsuarioRol();
                    Usuarios usuarios = new Usuarios();
                    usuarios.setIdusuario(Integer.parseInt(request.getParameter("selectUsuario")));
                    Roles roles = new Roles();
                    roles.setIdrol(Integer.parseInt(request.getParameter("selectRol")));
                    usuarioRol.setIdusuario(usuarios);
                    usuarioRol.setIdrol(roles);
                    usuarioRol.setUsername(request.getParameter("user"));
                    usuarioRol.setPass(request.getParameter("password"));
                    Integer max = usuarioRolList
                            .stream()
                            .mapToInt(v -> v.getIdusuariorol())
                            .max().orElseThrow(NoSuchElementException::new);
                    usuarioRol.setIdusuariorol(max + 1);

                    usuarioRolFacade.edit(usuarioRol);

                    break;

                case "editar":
                    usuarioRolEdit = usuarioRolFacade.find(Integer.parseInt(request.getParameter("selected")));
                    break;

                case "actualizar":

                    usuarioRolEdit.setPass(request.getParameter("pass"));
                    usuarioRolEdit.setUsername(request.getParameter("username"));
                    usuarioRolFacade.edit(usuarioRolEdit);

                    break;

                case "cancelar":
                    requestDispatcher = request.getRequestDispatcher(REQUEST_DISPATCHER_TO_ADMIN);
                    requestDispatcher.forward(request, response);
                    break;
                default:
                    break;
            }
        }
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
