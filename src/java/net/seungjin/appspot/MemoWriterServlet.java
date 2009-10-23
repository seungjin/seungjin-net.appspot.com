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
import net.seungjin.appspot.Memo;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 *
 * @author seungjin
 */
public class MemoWriterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        UserService userService = UserServiceFactory.getUserService();
        String thisURL = request.getRequestURI();
        if (request.getUserPrincipal() != null) {

        } else {
            response.sendRedirect(userService.createLoginURL(thisURL));
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1,user-scalable=no\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>"+request.getUserPrincipal().getName()+"</p>");
            out.println("<form action=\""+thisURL+"\" method=\"post\">");
            out.println("<textarea style=\"width:800px; height:400px; padding:5px; border: 3px solid #cccccc;\" name=\"memo\" ></textarea>");
            out.println("<br/><input type=\"submit\" />");
            out.println("</form>");
            out.println("<a href=\"" + userService.createLogoutURL(thisURL) + "\">sign out</a>.</p>");
            out.println("</body>");
            out.println("</html>");

            String memo = new String();
            
            if (request.getParameter("memo") != null ) {
                memo = request.getParameter("memo");

                PersistenceManager pm = PMF.get().getPersistenceManager();
                Memo m = new Memo(memo,0);

                try {
                    pm.makePersistent(m);
                } finally {
                    pm.close();
                }

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
