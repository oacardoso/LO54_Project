/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.repository;

import fr.utbm.ecole.entity.Client;
import fr.utbm.ecole.tools.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mathilde
 */
public class ClientDao {

    public ClientDao() {
    }
    
    /*Crée un client dans la base*/
    public Integer addClient(String last_name, String first_name, String address, String phone, String email, Set sessions) {
        
        Client cl = getClient(first_name, last_name);
        if (cl != null)
        {
            System.out.println("Le client " + first_name + " " + last_name + " existe déjà dans la base.");
            addClientSession(cl, sessions);
            return cl.getId();
        }
        
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

    /*Liste les clients de la base*/
    public List listClients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List clients = null;
        try {
            session.beginTransaction();
            clients = session.createQuery("FROM Client").list();
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
        return clients;
    }
    
    /*Renvoie un client de la base*/
    public Client getClient(String first_name, String last_name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Client client = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Client C where C.last_name = :lname and C.first_name = :fname ");
            query.setParameter("lname", last_name);
            query.setParameter("fname", first_name);
            client = (Client) query.uniqueResult();
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
        return client;
    }
    
    /*Ajoute des sessions de cours à un client*/
    public void addClientSession(Client client, Set sessions) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            
            Set f_sessions = client.addSessions(sessions);
            if(!f_sessions.isEmpty())
            {
                for(Object s : f_sessions)
                {
                    System.out.println("Le client est déjà inscrit à la session du " + ((fr.utbm.ecole.entity.Session)s).getStart_date());
                }
            }
            
            session.update(client);
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
