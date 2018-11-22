/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import fr.utbm.ecole.entity.Client;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author mperrot
 */
public class ClientService {

    public ClientService() {
    }

    /*Créer un client dans la base*/
    public Integer addClient(String last_name, String first_name, String address, String phone, String email, Set sessions) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer clientID = null;
        try {
            session.beginTransaction();

            Client client = new Client(last_name, first_name, address, phone, email);
            client.setSessions(sessions);
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

    /*Lister les infos des employés*/
    public void listClients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            List clients = session.createQuery("FROM Client").list();
            for (Iterator iterator1 = clients.iterator(); iterator1.hasNext();) {
                Client client = (Client) iterator1.next();
                System.out.print("First Name: " + client.getFirst_name());
                System.out.print("; Last Name: " + client.getLast_name());
                System.out.println("; Address: " + client.getAddress());
                System.out.println("; Email: " + client.getEmail());
                System.out.println("; Phone: " + client.getPhone());
                Set sessions = client.getSessions();
                for (Iterator iterator2 = sessions.iterator(); iterator2.hasNext();) {
                    fr.utbm.ecole.entity.Session ses = (fr.utbm.ecole.entity.Session) iterator2.next();
                    System.out.println("Session: " + ses.getStart_date());
                }
            }
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
    }

}
