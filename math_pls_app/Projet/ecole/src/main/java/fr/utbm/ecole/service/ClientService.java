/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import fr.utbm.ecole.entity.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author mperrot
 */
public class ClientService {

    public ClientService() {
    }

    /*Créé un client dans la base*/
    public Integer addClient(String last_name, String first_name, String address, char[] phone, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer clientID = null;
        try {
            session.beginTransaction();
            
            Client client = new Client(last_name, first_name, address, phone, email);
            clientID = (Integer) session.save(client); 
            
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he3) {
                    he3.printStackTrace();
                }
            }
        }
        return clientID;
    }
    
}
