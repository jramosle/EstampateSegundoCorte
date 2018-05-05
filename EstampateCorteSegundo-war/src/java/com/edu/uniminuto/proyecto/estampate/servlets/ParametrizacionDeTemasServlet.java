/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uniminuto.proyecto.estampate.servlets;

import static com.edu.uniminuto.proyecto.estampate.servlets.LoginServlet.REQUEST_DISPATCHER_TO_ADMIN;
import com.unimininuto.estampate.ejb.interfaces.TemasFacadeLocal;
import com.unimininuto.estampate.entities.Temas;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ParametrizacionDeTemas", urlPatterns = {"/ParametrizacionDeTemas"})
public class ParametrizacionDeTemasServlet extends HttpServlet {

    @EJB
    private TemasFacadeLocal temasFacadeLocal;
    
    String id = "";
    String accion = "";
    
    List<Temas> temasList = new ArrayList<>();
    Temas temasEdit = new Temas();
    

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
                out.println("<form action=\"ParametrizacionDeTemas\" method=\"post\">\n"
                        + "<table>\n"
                        + "  <tr>\n"
                        + "    <th></th>\n"
                        + "    <th>Nombre tema</th>\n"
                        + "    <th>Descripción</th>\n"
                        + "  </tr>\n");

                temasList.forEach((temasEdit) -> {

                    out.print("  <tr>\n"
                            + "    <td><input type=\"radio\" name=\"selected\" value=" + temasEdit.getIdtemas() + "></td>\n"
                            + "    <td>" + temasEdit.getNombretema() + "</td>\n"
                            + "    <td>" + temasEdit.getDescripciontema() + "</td>\n"
                            + "  </tr>\n");
                });
                out.print("</table>"
                        + "<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"eliminar\">"
                        + "<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"editar\">"
                        + "</form>");

            } else if ("insertar".equals(accion)) {

                out.println(" <form action=\"ParametrizacionDeTemas\" method=\"post\">\n");
               
                out.println("<br>\n"
                        + "            Nombre tema:<br>\n"
                        + "            <input type=\"text\" name=\"nombre\" value=\"\" placeholder=\"nombre tema\">\n"
                        + "            <br>\n"
                        + "            Descripción tema:<br>\n"
                        + "            <input type=\"text\" name=\"descripcion\" value=\"\" placeholder=\"descripción tema\">\n"
                        + "            <br>\n"
                        + "            <br>\n"
                        + "            <input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"guardar\">\n"
                        + "        </form> ");

            } else if ("editar".equals(accion)) {

                out.println(" <form action=\"ParametrizacionDeTemas\" method=\"post\">"
                        + "            Nombre tema:<br>\n"
                        + "            <input type=\"text\" name=\"nombre\" value=\"" + temasEdit.getNombretema() + "\" placeholder=\"nombre tema\" required>\n"
                        + "            <br>\n"
                        + "            Descripcion Tema:<br>\n"
                        + "            <input type=\"text\" name=\"descripcion\" value=\"" + temasEdit.getDescripciontema() + "\" placeholder=\"descripcion\" required>\n"
                        + "            <br>\n"
                        + "            <input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"actualizar\">\n"
                        + "        </form>");

            }

            out.print("<form action=\"ParametrizacionDeTemas\" method=\"post\" >");
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
        id = request.getParameter("id");
        accion = request.getParameter("ejecutar");

        Temas temas;

        if (accion != null) {
            request.getParameter("selected");
            switch (accion) {
                case "eliminar":
                    temas = new Temas();
                    temas.setIdtemas(Integer.parseInt(request.getParameter("selected")));
                    temasFacadeLocal.remove(temas);
                    break;
                case "consultar":
                    temasList = temasFacadeLocal.findAll();
                    break;
                case "guardar":

                    temas = new Temas();
                    temas.setNombretema(request.getParameter("nombre"));  
                    temas.setDescripciontema(request.getParameter("descripcion"));
                    
                    Integer max = temasList
                            .stream()
                            .mapToInt(v -> v.getIdtemas())
                            .max().orElseThrow(NoSuchElementException::new);
                    temas.setIdtemas(max + 1);

                    temasFacadeLocal.edit(temas);

                    break;

                case "editar":
                    temasEdit = temasFacadeLocal.find(Integer.parseInt(request.getParameter("selected")));
                    break;

                case "actualizar":

                    temasEdit.setNombretema(request.getParameter("nombre"));
                    temasEdit.setDescripciontema(request.getParameter("descripcion"));
                    temasFacadeLocal.edit(temasEdit);

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
