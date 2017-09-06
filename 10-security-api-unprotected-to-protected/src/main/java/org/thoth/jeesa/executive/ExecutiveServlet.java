/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thoth.jeesa.executive;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

@WebServlet(name = "ExecutiveServlet", urlPatterns = {"/executive/servlet"})
@ServletSecurity(
    @HttpConstraint(rolesAllowed = {"ExecutiveRole"})
)
public class ExecutiveServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(ExecutiveServlet.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        ServletContext servletContext
            = request.getServletContext();

        boolean include
            = "true".equals(StringUtils.trimToNull((String)request.getAttribute("ferris.include")));

        try (PrintWriter out = response.getWriter();)
        {
            if (!include) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println(String.format("<title>%s</title>", servletContext.getAttribute("maven.project.artifactId")));
                out.println("</head>");
                out.println("<body>");
            }

            out.println("<div style=\"background-color:red\">");
                out.println("<h1>ExecutiveServlet</h1>");
                out.println("<p>");
                out.println("<b>Yikes!</b>.  If you are reading this, that's no good.  This servlet is protected by the <b>ExecutiveRole</b> role.");
                out.println("</p>");
            out.println("</div>");

            if (!include) {
                out.println("</body>");
                out.println("</html>");
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
