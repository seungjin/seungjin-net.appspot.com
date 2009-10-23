/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.seungjin.appspot;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import net.seungjin.appspot.PMF;

import java.util.List;
import java.util.Iterator;

import java.util.Enumeration;

/**
 *
 * @author seungjin
 */
public class RootServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // TODO output your page here
            out.println("<pre>");
            out.println("not ready yet");
            out.println("");
            Enumeration headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()) {
                String headerName = (String)headerNames.nextElement();
                out.println("#"+headerName + "\t" + request.getHeader(headerName));
            }
            out.println("");
            out.println("%request.getRemoteAddr()\t" + request.getRemoteAddr());
            out.println("%request.getRemoteHost()\t" + request.getRemoteHost());
            out.println("%request.getRemotePort()\t" + request.getRemotePort());
            out.println("%request.getRemoteUser()\t" + request.getRemoteUser());
            out.println("%request.getRequestURL().toString()\t" + request.getRequestURL().toString());
            out.println("%request.getRequestURI()\t" + request.getRequestURI());
            out.println("%request.getRequestedSessionId()\t" + request.getRequestedSessionId());
            out.println("%request.getRequestURI()\t" + request.getRequestURI());
            out.println("%request.getRequestURL().toString()\t" + request.getRequestURL().toString());
            out.println("%request.getMethod()\t" + request.getMethod());
            out.println("%request.getScheme()\t" + request.getScheme());
            out.println("%request.getLocalPort()\t" + request.getLocalPort());
            out.println("%request.getServerName()\t" + request.getServerName());
            out.println("%request.getServerPort()" + request.getServerPort());
            out.println("%request.getServletPath()" + request.getServletPath());
            out.println("%request.getSession()" + request.getSession());
            out.println("");
            Enumeration parameterNames = request.getParameterNames();
            while(parameterNames.hasMoreElements()) {
                String parameterName = (String)parameterNames.nextElement();
                out.println("?"+parameterName + "\t" + request.getParameter(parameterName));
            }
            out.println("");
            
            out.println("</pre>");
            

            //out.println(request.getRequestURI());
            //out.println(request.getParameter("jk"));

            /*
            
            Employee e = new Employee("Alfred", "Smith", new Date());
            PersistenceManager pm = PMF.get().getPersistenceManager();

            try {
                 pm.makePersistent(e);
            } finally {
                pm.close();
            }

            out.println("end?");
            */

        } finally { 
            out.close();
        }

    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
