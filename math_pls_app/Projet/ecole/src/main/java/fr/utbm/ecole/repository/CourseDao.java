/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.repository;

import fr.utbm.ecole.entity.Course;
import fr.utbm.ecole.tools.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mathilde
 */
public class CourseDao {

    public CourseDao() {
    }
    
    /*Crée un cours dans la base*/
    public String addCourse(String code, String titre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String courseID = null;
        try {
            session.beginTransaction();

            Course course = new Course(code, titre);
            courseID = (String) session.save(course);

            session.getTransaction().commit();
        } catch (HibernateException he) {
            if (he.getCause().getMessage().contains("Duplicate entry"))
            {
                System.out.println("Le cours " + code + " existe déjà dans la base.");
            }
            else {
                he.printStackTrace();
            }
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
        return courseID;
    }

    /*Liste des cours de la base*/
    public List listCourses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List courses = null;
        try {
            session.beginTransaction();
            courses = session.createQuery("FROM Course").list();
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
        return courses;
    }
    
    /*Liste les cours de la base selon un mot du titre*/
    public List listCourses(String mot_cle) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List courses = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Course C where C.title LIKE CONCAT('%',:mot,'%')");
            query.setParameter("mot", mot_cle);
            courses = query.list();
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
        return courses;
    }
    
    /*Liste les cours de la base selon une date donnée*/
    public List listCourses(Date date) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List courses = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("select distinct S.course from Session S where :date between S.start_date and S.end_date");
            query.setParameter("date", date);
            courses = query.list();
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
        return courses;
    }
    
    /*Liste les cours de la base selon le lieu d'une session*/
    public List listCoursesLoc(String loc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List courses = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("select distinct S.course from Session S inner join S.location location where :loc=location.city");
            query.setParameter("loc", loc);
            courses = query.list();
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
        return courses;
    }
    
}
