/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.repository;

import fr.utbm.ecole.entity.Course;
import fr.utbm.ecole.tools.HibernateUtil;
import java.util.Iterator;
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
            System.out.println("Cours : " + course.getCode());
            for (Iterator iterator1 = sess.iterator(); iterator1.hasNext();) {
                fr.utbm.ecole.entity.Session s = (fr.utbm.ecole.entity.Session) iterator1.next();
                System.out.println("Location: " + s.getLocation());
                System.out.println("Debut: " + s.getStart_date());
                System.out.println("Fin: " + s.getEnd_date());
                System.out.println("Max: " + s.getMax());
                System.out.println();
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
        return sess;
    }
    
}
