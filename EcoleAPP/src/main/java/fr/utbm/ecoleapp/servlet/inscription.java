/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecoleapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.utbm.ecole.service.ClientService;
import fr.utbm.ecole.service.SessionService;
import javax.servlet.RequestDispatcher;

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

        try {
            if (request.getParameter("Inscrire") != null) {
                switch (request.getParameter("Inscrire")) {
                    case "Enregistrer": {
                        String lastname = request.getParameter("lastname");
                        String firstname = request.getParameter("firstname");
                        String mail = request.getParameter("mail");
                        String number = request.getParameter("number");
                        String adress = request.getParameter("adress");
                        int idSession = Integer.parseInt(request.getParameter("session"));
                        ClientService cl = new ClientService();
                        SessionService Ses = new SessionService();
                        cl.addClient(lastname, firstname, adress, number, mail, Ses.getSession(idSession));
                        response.sendRedirect("/EcoleAPP/");
                        return;
                    }
                    case "Accueil":
                        response.sendRedirect("/EcoleAPP/");
                        break;
                    case "Course session": {
                        SessionService Ses = new SessionService();
                        int idSession = Integer.parseInt(request.getParameter("session"));
                        String course = Ses.getSession(idSession).getCourse().getCode();
                        response.sendRedirect("/EcoleAPP/course_session?td=" + course);
                        break;
                    }
                    default:
                        break;
                }
            } else {
                try (PrintWriter out = response.getWriter()) {
                    request.getRequestDispatcher("/inscription.jsp").forward(request, response);
                } catch (Exception ex) {

                }
            }

        } catch (Exception ex) {

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
        //response.sendRedirect(request.getContextPath() + "/EcoleAPP");
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
