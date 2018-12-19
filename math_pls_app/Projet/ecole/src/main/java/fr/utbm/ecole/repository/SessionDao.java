/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.repository;

import fr.utbm.ecole.entity.Course;
import fr.utbm.ecole.tools.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mathilde
 */
public class SessionDao {

    public SessionDao() {
    }
    
    /*Liste les sessions de la base selon un cours donné*/
    public List listSessions(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List sess = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Session S where S.course = :course ");
            query.setParameter("course", course);
            sess = query.list();
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
        return sess;
    }
    
    /*Liste les sessions de la base selon le code d'un cours*/
    public List listSessions(String code) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List sess = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("Select S FROM Session S inner join S.course course where course.code = :code");
            query.setParameter("code", code);
            sess = query.list();
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
        return sess;
    }
    
    /*Renvoie une Session de la base selon id*/
    public fr.utbm.ecole.entity.Session getSession(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        fr.utbm.ecole.entity.Session ses = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Session S where S.id = :id ");
            query.setParameter("id", id);
            ses = (fr.utbm.ecole.entity.Session) query.uniqueResult();
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
        return ses;
    }
    
    /*Donne le nombre de participants à une session donnée*/
    public long numParticipants(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        long nb = 0;
        try {
            session.beginTransaction();
            Query query = session.createQuery("Select count(*) FROM Client C inner join C.sessions sessions where sessions.id = :id");
            query.setParameter("id", id);
            nb = (long)query.uniqueResult();
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
        return nb;
    }
    
}
