/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.uniminuto.proyecto.estampate.servlets;

import com.unimininuto.estampate.ejb.UsuarioRolFacade;
import com.unimininuto.estampate.ejb.interfaces.EstampasFacadeLocal;
import com.unimininuto.estampate.ejb.interfaces.TemasFacadeLocal;
import com.unimininuto.estampate.entities.Estampas;
import com.unimininuto.estampate.entities.Temas;
import com.unimininuto.estampate.entities.UsuarioRol;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Nectia
 */
@WebServlet(name = "GestionarEstampasServlet", urlPatterns = {"/GestionarEstampasServlet"})
@MultipartConfig
public class GestionarEstampasServlet extends HttpServlet {

    @EJB
    private EstampasFacadeLocal estampasFacadeLocal;

    @EJB
    private TemasFacadeLocal temasFacadeLocal;

    @EJB
    private UsuarioRolFacade usuarioRolFacade;

    List<Estampas> estampasList = new ArrayList<>();
    Estampas estampasEdit = new Estampas();

    String id = "";
    String accion = "";

    public static final String REQUEST_DISPATCHER_TO_ARTISTA = "menuArtista.html";
    private final String UPLOAD_DIRECTORY = "C:\\Users\\PRISTOPHER\\Documents\\Netbeans\\ArquitecturaDesoftware\\wildfly-12.0.0.Final\\welcome-content\\uploads";

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
                out.println("<form action=\"GestionarEstampasServlet\" method=\"post\">\n"
                        + "<table>\n"
                        + "  <tr>\n"
                        + "    <th></th>\n"
                        + "    <th>Nombre Estampa</th>\n"
                        + "    <th>Artista</th>\n"
                        + "    <th>Tema</th>\n"
                        + "    <th>Imagen</th>\n"
                        + "  </tr>\n");

                estampasList.forEach((estampas) -> {

                    String urlEstampa = estampas.getUrl().replace('\\', '/');
                    out.print("  <tr>\n"
                            + "    <td><input type=\"radio\" name=\"selected\" value=" + estampas.getIdestampas() + "></td>\n"
                            + "    <td>" + estampas.getNombreestampa() + "</td>\n"
                            + "    <td>" + estampas.getIdartista().getIdusuario().getNombreusuario() + "</td>\n"
                            + "    <td>" + estampas.getIdtema().getNombretema() + "</td>\n"
                            + "    <td><img width=\"200\" src=\"" + urlEstampa + "\"/></td>\n"
                            + "  </tr>\n");
                });
                out.print("</table>"
                        + "<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"eliminar\">"
                        + "<input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"editar\">"
                        + "</form>");

            } else if ("insertar".equals(accion)) {

                out.println(" <form action=\"GestionarEstampasServlet\" method=\"post\" enctype=\"multipart/form-data\">"
                        + "            Nombre estampa:<br>\n"
                        + "            <input type=\"text\" name=\"nombreEstampa\" value=\"\" placeholder=\"Nombre estampa\" required>\n"
                        + "            <br>\n"
                        + "Temas<br>\n");
                out.print("<select name=\"selectTemas\">");
                temasFacadeLocal.findAll().forEach((llave) -> {
                    out.print("<option value=\"" + llave.getIdtemas() + "\">" + llave.getNombretema() + " " + llave.getDescripciontema() + "</option>");
                });
                out.print("</select><br>");
                out.print("<select name=\"selectUsuarios\">");
                usuarioRolFacade.findAll().forEach((llave) -> {
                    out.print("<option value=\"" + llave.getIdusuariorol() + "\">" + llave.getIdusuario().getNombreusuario() + "</option>");
                });
                out.print("</select><br>");
                out.println("<br>\n"
                        + "            <legend>Imagen estampa</legend>\n"
                        + "                <input type=\"file\" name=\"file\" class=\"form-control\" id=\"\" placeholder=\"Input field\" required>\n"
                        + "            <div class=\"form-group\">\n"
                        + "            </div>\n"
                        + "            <input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"guardar\">\n"
                        + "        </form> ");

            } else if ("editar".equals(accion)) {

                out.println(" <form action=\"GestionarEstampasServlet\" method=\"post\" enctype=\"multipart/form-data\">"
                        + "            Nombre estampa:<br>\n"
                        + "            <input type=\"text\" name=\"nombreEstampa\" value=" + estampasEdit.getNombreestampa() + " placeholder=\"nombre\" required>\n"
                        + "            <br>\n"
                        + "            Tema:<br>\n"
                        + "<select name=\"selectTemas\">");
                temasFacadeLocal.findAll().forEach((llave) -> {
                    out.print("<option value=\"" + llave.getIdtemas() + "\">" + llave.getNombretema() + " " + llave.getDescripciontema() + "</option>");
                });
                out.println("<br>\n"
                        + "            <legend>Imagen estampa</legend>\n"
                        + "                <input type=\"file\" name=\"file\" class=\"form-control\" id=\"\" placeholder=\"Input field\" required>\n"
                        + "            <div class=\"form-group\">\n"
                        + "            </div>\n"
                        + "            <input style='left:0;' type=\"submit\" name=\"ejecutar\" value=\"actualizar\">\n"
                        + "        </form>");
            }

            out.print("<form action=\"GestionarEstampasServlet\" method=\"post\" >");
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

        } catch (Exception ex) {
            ex.printStackTrace();
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

        Estampas estampas;

        if (accion != null) {
            request.getParameter("selected");
            switch (accion) {
                case "eliminar":
                    estampas = new Estampas();
                    estampas.setIdestampas(Integer.parseInt(request.getParameter("selected")));
                    estampasFacadeLocal.remove(estampas);
                    break;
                case "consultar":

                    estampasList = estampasFacadeLocal.findAll();
                    break;

                case "guardar":

                    estampas = new Estampas();
                    Temas temas = new Temas();
                    UsuarioRol usuarioRol = new UsuarioRol();
                    String nombreArchivo = "";

                    estampas.setNombreestampa(request.getParameter("nombreEstampa"));
                    temas.setIdtemas(Integer.parseInt(request.getParameter("selectTemas")));
                    estampas.setIdtema(temas);
                    usuarioRol.setIdusuariorol(Integer.parseInt(request.getParameter("selectUsuarios")));
                    estampas.setIdartista(usuarioRol);

//                    estampas.setCorreousuario(request.getParameter("correoUsuario"));
                    Integer max = estampasList
                            .stream()
                            .mapToInt(v -> v.getIdestampas())
                            .max().orElseThrow(NoSuchElementException::new);
                    estampas.setIdestampas(max + 1);

                    if (ServletFileUpload.isMultipartContent(request)) {

                        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
                        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                        InputStream fileContent = filePart.getInputStream();

                        nombreArchivo = estampas.getIdestampas() + fileName;
                        File targetFile = new File(UPLOAD_DIRECTORY + "/" + nombreArchivo);
                        OutputStream outStream = new FileOutputStream(targetFile);

                        byte[] buffer = new byte[8 * 1024];
                        int bytesRead;
                        while ((bytesRead = fileContent.read(buffer)) != -1) {
                            outStream.write(buffer, 0, bytesRead);
                        }
                        IOUtils.closeQuietly(fileContent);
                        IOUtils.closeQuietly(outStream);
                    }
                    estampas.setUrl("http://localhost:8040/uploads/" + nombreArchivo);

                    estampasFacadeLocal.create(estampas);

                    break;

                case "editar":

                    estampasEdit = estampasFacadeLocal.find(Integer.parseInt(request.getParameter("selected")));

                    break;

                case "actualizar":

                    String nombreArchivoEdit = "";
                    try {

                        if (ServletFileUpload.isMultipartContent(request)) {

                            Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
                            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                            InputStream fileContent = filePart.getInputStream();

                            nombreArchivoEdit = estampasEdit.getIdestampas() + fileName;
                            File targetFile = new File(UPLOAD_DIRECTORY + "/" + nombreArchivoEdit);
                            OutputStream outStream = new FileOutputStream(targetFile);

                            byte[] buffer = new byte[8 * 1024];
                            int bytesRead;
                            while ((bytesRead = fileContent.read(buffer)) != -1) {
                                outStream.write(buffer, 0, bytesRead);
                            }
                            IOUtils.closeQuietly(fileContent);
                            IOUtils.closeQuietly(outStream);
                        }

                        Temas temaEdit = new Temas();
                        temaEdit.setIdtemas(Integer.parseInt(request.getParameter("selectTemas")));
                        estampasEdit.setIdtema(temaEdit);
                        estampasEdit.setNombreestampa(request.getParameter("nombreEstampa"));
                        estampasEdit.setUrl("http://localhost:8040/uploads/" + nombreArchivoEdit);

                        estampasFacadeLocal.edit(estampasEdit);

                    } catch (Exception ex) {
                        Logger.getLogger(GestionarPersonasServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case "cancelar":
                    requestDispatcher = request.getRequestDispatcher(REQUEST_DISPATCHER_TO_ARTISTA);
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
