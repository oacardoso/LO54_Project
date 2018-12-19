/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.repository;

import fr.utbm.ecole.entity.Client;
import fr.utbm.ecole.tools.HibernateUtil;
import static fr.utbm.ecole.tools.MetricsRegistry.METRIC_REGISTRY;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import static com.codahale.metrics.MetricRegistry.name;
import com.codahale.metrics.Timer;

/**
 *
 * @author Mathilde
 */
public class ClientDao {

    private final Timer save = METRIC_REGISTRY.timer(name(ClientDao.class, "save"));
    private final Timer update = METRIC_REGISTRY.timer(name(ClientDao.class, "update"));
    private final Timer select = METRIC_REGISTRY.timer(name(ClientDao.class, "select"));

    public ClientDao() {
    }

    /*Crée un client dans la base*/
    public Integer addClient(String last_name, String first_name, String address, String phone, String email, fr.utbm.ecole.entity.Session ses) {

        Client cl = getClient(first_name, last_name);
        if (cl != null) {
            System.out.println("Le client " + first_name + " " + last_name + " existe déjà dans la base.");
            addClientSession(cl, ses);
            return cl.getId();
        }

        Client client = new Client(last_name, first_name, address, phone, email);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer clientID = null;
        try {
            final Timer.Context context = save.time();
            try {
                session.beginTransaction();
                clientID = (Integer) session.save(client);
                session.getTransaction().commit();
            } finally {
                context.stop();
            }
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
        addClientSession(client, ses);
        return clientID;
    }

    /*Liste les clients de la base*/
    public List listClients() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List clients = null;
        try {
            final Timer.Context context = select.time();
            try {
                session.beginTransaction();
                clients = session.createQuery("FROM Client").list();
                session.getTransaction().commit();
            } finally {
                context.stop();
            }
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
            final Timer.Context context = select.time();
            try {
                session.beginTransaction();
                Query query = session.createQuery("FROM Client C where C.last_name = :lname and C.first_name = :fname ");
                query.setParameter("lname", last_name);
                query.setParameter("fname", first_name);
                client = (Client) query.uniqueResult();
                session.getTransaction().commit();
            } finally {
                context.stop();
            }
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
    public void addClientSession(Client client, fr.utbm.ecole.entity.Session ses) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            Boolean res = client.addSession(ses);
            if (res == false) {
                System.out.println("Le client est déjà inscrit à la session du " + ses.getStart_date() + " pour le cours " + ses.getCourse().getCode());
            }
            
            final Timer.Context context = update.time();
            try {
                session.update(client);
                session.getTransaction().commit();
            } finally {
                context.stop();
            }
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
