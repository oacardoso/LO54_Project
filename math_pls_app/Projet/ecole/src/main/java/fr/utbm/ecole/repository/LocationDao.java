/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.repository;

import fr.utbm.ecole.entity.Location;
import fr.utbm.ecole.tools.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Mathilde
 */
public class LocationDao {

    public LocationDao() {
    }
    
    /*Liste les locations de la base*/
    public List listLocations() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List locations = null;
        try {
            session.beginTransaction();
            locations = session.createQuery("FROM Location").list();
            for (Iterator iterator1 = locations.iterator(); iterator1.hasNext();) {
                Location location = (Location) iterator1.next();
                System.out.print("Ville: " + location.getCity());
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
        return locations;
    }
}
