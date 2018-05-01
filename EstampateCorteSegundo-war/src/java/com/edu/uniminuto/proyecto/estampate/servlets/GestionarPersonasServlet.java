package com.edu.uniminuto.proyecto.estampate.servlets;

import com.unimininuto.estampate.ejb.interfaces.UsuariosFacadeLocal;
import com.unimininuto.estampate.entities.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @author Nectia
 */
@WebServlet(name = "GestionarPersonasServlet", urlPatterns = {"/GestionarPersonasServlet"})
public class GestionarPersonasServlet extends HttpServlet {

    @EJB
    private UsuariosFacadeLocal usuariosFacade;

    List<Usuarios> usuarios = new ArrayList<>();
    List<Usuarios> usuariosCon = new ArrayList<>();

    String id = "";
    String accion = "";

    /**
     *
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
                out.println("<form action=\"GestionarPersonasServlet\" method=\"post\">\n"
                        + "<table>\n"
                        + "  <tr>\n"
                        + "    <th></th>\n"
                        + "    <th>nombre</th>\n"
                        + "    <th>fecha de nacimiento</th>\n"
                        + "    <th>correo usuario</th>\n"
                        + "    <th>Cedula usuario</th>\n"
                        + "  </tr>\n");
                usuarios.forEach((usuarios) -> {
                    out.print("  <tr>\n"
                            + "    <td><input type=\"radio\" name=\"selected\" value=" + usuarios.getIdusuario() + "></td>\n"
                            + "    <td>" + usuarios.getNombreusuario() + "</td>\n"
                            + "    <td>" + usuarios.getFechanacimiento() + "</td>\n"
                            + "    <td>" + usuarios.getCorreousuario() + "</td>\n"
                            + "    <td>" + usuarios.getCedulausuario() + "</td>\n"
                            + "  </tr>\n");
                });
                out.print("</table>"
                        + "<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"eliminar\">"
                        + "<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"editar\">"
                        + "</form> \n");
            } else if ("insertar".equals(accion)) {

                out.println(" <form action=\"GestionarPersonasServlet\" method=\"post\">"
                        + "            Primer nombre:<br>\n"
                        + "            <input type=\"text\" name=\"nombreUsuario\" value=\"\" placeholder=\"nombre\" required>\n"
                        + "            <br>\n"
                        + "            Fecha de nacimiento:<br>\n"
                        + "            <input type=\"date\" name=\"fechaNacimiento\" value=\"\" required>\n"
                        + "            <br>\n"
                        + "            Cedula: \n"
                        + "            <br>\n"
                        + "            <input type=\"text\" name=\"cedulaUsuario\" value=\"\" placeholder=\"cedula\" required>\n"
                        + "            <br>\n"
                        + "            Correo: \n"
                        + "            <br>\n"
                        + "            <input type=\"email\" name=\"correoUsuario\" value=\"\" placeholder=\"email\" required>\n"
                        + "\n"
                        + "            <br>\n"
                        + "            <input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"guardar\">\n"
                        + "        </form> \n");

            } else if ("editar".equals(accion)) {

                out.println(" <form action=\"GestionarPersonasServlet\" method=\"post\">"
                        + "            Primer nombre:<br>\n"
                        + "            <input type=\"text\" name=\"nombreUsuario\" value=\"\" placeholder=\"nombre\" required>\n"
                        + "            <br>\n"
                        + "            Fecha de nacimiento:<br>\n"
                        + "            <input type=\"date\" name=\"fechaNacimiento\" value=\"\" required>\n"
                        + "            <br>\n"
                        + "            Cedula: \n"
                        + "            <br>\n"
                        + "            <input type=\"text\" name=\"cedulaUsuario\" value=\"\" placeholder=\"cedula\" required>\n"
                        + "            <br>\n"
                        + "            Correo: \n"
                        + "            <br>\n"
                        + "            <input type=\"email\" name=\"correoUsuario\" value=\"\" placeholder=\"email\" required>\n"
                        + "\n"
                        + "            <br>\n"
                        + "            <input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"actualizar\">\n"
                        + "        </form> \n");
                out.print("<form action=\"GestionarPersonasServlet\" method=\"post\" >");
//            out.print("<select name=\"id\">");
//
//            usuarios.forEach((llave) -> {
//                out.print("<option value=\"" + llave.getIdusuario() + "\">" + llave.getNombreusuario() + "</option>");
//            });
//            out.print("</select>");
                out.print("<br>");
                out.print("<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"consultar\">");
                out.print("<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"insertar\">");
                out.print("</br>");

                out.print("</form>");

                if (usuariosCon.size() > 0) {

                    out.print("<h1> " + usuariosCon.get(0).getCedulausuario() + "<h1>");

                }
                out.print("</div>");
                out.println(
                        "    </body>\n"
                        + "</html>\n"
                        + "");

            }
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

        RequestDispatcher requestDispatcher;

        List<Usuarios> usuarios = usuariosFacade.findAll();

        request.setAttribute("date", usuarios);
        getServletContext().setAttribute("data", usuarios);

//        requestDispatcher = request.getRequestDispatcher("gestionarPersonas.html");
//        requestDispatcher.forward(request, response);
        id = request.getParameter("id");
        accion = request.getParameter("ejecutar");
//        usuarioses = usuariosDAO.getUsuarios();
//        usuariosCon = usuariosDAO.getUsuario(id);

//        processRequest(request, response);
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

        id = request.getParameter("id");
        accion = request.getParameter("ejecutar");

        if (accion != null) {
            request.getParameter("selected");
            switch (accion) {
                case "eliminar":
                    Usuarios usuarioEliminar = new Usuarios();
                    usuarioEliminar.setIdusuario(Integer.parseInt(request.getParameter("selected")));
                    usuariosFacade.remove(usuarioEliminar);
                    accion = "consultar";
                    break;
                case "consultar":
                    usuarios = usuariosFacade.findAll();
                    break;
                case "guardar":
                    Usuarios usuario = new Usuarios();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        usuario.setNombreusuario(request.getParameter("nombreUsuario"));
                        usuario.setFechanacimiento(formatter.parse(request.getParameter("fechaNacimiento")));
                        usuario.setCedulausuario(request.getParameter("cedulaUsuario"));
                        usuario.setCorreousuario(request.getParameter("correoUsuario"));
                        usuario.setIdusuario(usuariosFacade.count() + 1);
                    } catch (ParseException ex) {
                        Logger.getLogger(GestionarPersonasServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    usuariosFacade.create(usuario);
                    accion = "consultar";
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
