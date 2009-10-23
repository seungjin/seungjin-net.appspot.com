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

import javax.jdo.PersistenceManager;
import java.util.List;
import javax.jdo.Query;

/**
 *
 * @author seungjin
 */
public class JournalReaderServlet extends HttpServlet {
   
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

            DataImport di = new DataImport();
            di.importAction();


            PersistenceManager pm = PMF.get().getPersistenceManager();
            Query query = pm.newQuery(Journal.class);

            try {
                List<Journal> results = (List<Journal>) query.execute();
                out.println("<seungjin>");
                if (results.iterator().hasNext()) {
                    for (Journal c : results) {
                        out.println("<content>");
                        out.println("\t<id>"+c.getId()+"</id>");
                        out.println("\t<date>"+c.getDate()+"</date>");
                        out.println("\t<tag>"+c.getTag()+"</tag>");
                        out.println("\t<comment>"+c.getComment()+"</comment>");
                        out.println("\t<ref>"+c.getRef()+"</ref>");
                        out.println("</content>");
                    }
                }
                out.println("</seungjin>");
            } finally {
                query.closeAll();
            }

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
