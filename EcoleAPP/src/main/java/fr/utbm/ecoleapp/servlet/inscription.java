/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecoleapp.servlet;

import fr.utbm.ecole.entity.Session;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.utbm.ecole.service.ClientService;
import fr.utbm.ecole.service.SessionService;
import java.util.Enumeration;

/**
 *
 * @author User
 */
public class inscription extends HttpServlet {

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
            if (request.getParameter("action_inscrire_sess")!=null) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                try {
                    String lastname = request.getParameter("lastname");
                    String firstname = request.getParameter("firstname");
                    String mail = request.getParameter("mail");
                    String number = request.getParameter("number");
                    String adress = request.getParameter("adress");
                    int session_id = Integer.parseInt(request.getParameter("id_session"));
                    ClientService cl = new ClientService();
                    SessionService ss = new SessionService();
                    Session session = ss.getSession(session_id);
                    cl.addClient(lastname, firstname, adress, number, mail, session);
                } catch (Exception ex) {

                }
            }
            else
            {
                request.getRequestDispatcher("/inscription.jsp").forward(request, response);
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
