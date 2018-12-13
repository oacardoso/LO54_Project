/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import fr.utbm.ecole.repository.CourseDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mperrot
 */
public class CourseService {

    public CourseService() {
    }
    
    /*Nouveau un cours*/
    public String addCourse(String code, String titre) {
        CourseDao dao = new CourseDao();
        return dao.addCourse(code, titre);
    }

    /*Liste des cours*/
    public List listCourses() {
        CourseDao dao = new CourseDao();
        return dao.listCourses();
    }
    
    /*Liste les cours selon un mot du titre*/
    public List listCourses(String mot_cle) {
        CourseDao dao = new CourseDao();
        return dao.listCourses(mot_cle);
    }
    
    /*Liste les cours selon une date*/
    public List listCourses(Date date) {
        CourseDao dao = new CourseDao();
        return dao.listCourses(date);
    }
}
