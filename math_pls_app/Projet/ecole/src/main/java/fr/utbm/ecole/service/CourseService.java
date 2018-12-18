/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import static com.codahale.metrics.MetricRegistry.name;
import com.codahale.metrics.Timer;
import fr.utbm.ecole.repository.CourseDao;
import static fr.utbm.ecole.tools.MetricsRegistry.METRIC_REGISTRY;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mperrot
 */
public class CourseService {
    
    private final Timer listCourses = METRIC_REGISTRY.timer(name(CourseService.class,"listCourses"));

    public CourseService() {
    }
    
    /*Nouveau cours*/
    public String addCourse(String code, String titre) {
        CourseDao dao = new CourseDao();
        return dao.addCourse(code, titre);
    }

    /*Liste des cours*/
    public List listCourses() {
        final Timer.Context context = listCourses.time();
        try {
            CourseDao dao = new CourseDao();
        return dao.listCourses();
        } finally {
            context.stop();
        }
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
    
    /*Liste les cours selon un lieu*/
    public List listCoursesLoc(String loc) {
        CourseDao dao = new CourseDao();
        return dao.listCoursesLoc(loc);
    }
}
