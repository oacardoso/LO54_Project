/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole;

import fr.utbm.ecole.entity.Course;
import fr.utbm.ecole.entity.Session;
import fr.utbm.ecole.service.ClientService;
import fr.utbm.ecole.service.CourseService;
import fr.utbm.ecole.service.SessionService;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author mperrot
 */
public class App {
    public static void main(String[] args) {
 
        CourseService css = new CourseService();
        
        css.listCourses("test");
    }
}
