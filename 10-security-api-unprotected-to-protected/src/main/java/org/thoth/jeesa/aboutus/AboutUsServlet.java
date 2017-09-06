/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thoth.jeesa.aboutus;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Proxy;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.thoth.jeesa.servlet.http.HttpServletResponseProxy;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@WebServlet(name = "AboutUsServlet", urlPatterns = {"/aboutus/servlet"})
public class AboutUsServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(AboutUsServlet.class);

    /**
     *
     * @param request
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
        throws ServletException, IOException {

        ServletContext servletContext
            = servletRequest.getServletContext();

        log.info("Creating proxy class");
        HttpServletResponseProxy proxy
            = new HttpServletResponseProxy(servletResponse);

        log.info("Creating proxy response");
        HttpServletResponse proxyResponse = (HttpServletResponse) Proxy.newProxyInstance(
              servletResponse.getClass().getClassLoader()
            , new Class[]{HttpServletResponse.class}
            , proxy
        );

        try (PrintWriter out = proxyResponse.getWriter();)
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(String.format("<title>%s</title>", servletContext.getAttribute("maven.project.artifactId")));
            out.println("</head>");
            out.println("<body>");
            out.println("<div style=\"background-color:#C0C0C0\">");
            out.println("<h1>AboutUsServlet</h1>");
            out.println("<p>");
            out.println("The AboutUsServlet has no protection so is accessable to anyone.");
            out.println("</p>");
            out.println("<p>");
            out.println("Let's RequestDispatcher#include() to the ExecutiveServlet and see what happens...");
            out.println("</p>");
            out.println("</div>");

                servletRequest.setAttribute("ferris.include", "true");
                servletRequest
                    .getRequestDispatcher("/executive/servlet")
                    .include(servletRequest, proxyResponse);

            out.println("</body>");
            out.println("</html>");
            out.flush();
        }

        servletResponse.setContentType("text/html;charset=UTF-8");
        servletResponse.getWriter().print(proxy.getStringWriter().toString());
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
