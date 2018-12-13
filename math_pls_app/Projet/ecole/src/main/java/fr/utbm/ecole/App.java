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
import com.codahale.metrics.*;
import fr.utbm.ecole.entity.Client;
import fr.utbm.ecole.tools.HibernateUtil;
import java.util.concurrent.TimeUnit;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.Statistics;

/**
 *
 * @author mperrot
 */
public class App {
    
    static final MetricRegistry metrics = new MetricRegistry();
    
    public static void main(String[] args) {
 
        HibernateUtil.getSessionFactory().getStatistics().setStatisticsEnabled(true);
        CourseService css = new CourseService();
        css.listCourses("test");
        css.addCourse("GE02", "Gestion");
        test();
        
        /*startReport();
        Meter requests = metrics.meter("requests");
        requests.mark();
        wait5Seconds();*/
    }
    
    static void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();
        reporter.start(1, TimeUnit.SECONDS);
    }

    static void wait5Seconds() {
        try {
            Thread.sleep(5*1000);
        }
        catch(InterruptedException e) {}
    }
    
    static void test() {
        Statistics stats = HibernateUtil.getSessionFactory().getStatistics();

        double queryCacheHitCount  = stats.getQueryCacheHitCount();
        double queryCacheMissCount = stats.getQueryCacheMissCount();
        double queryCacheHitRatio =
          queryCacheHitCount / (queryCacheHitCount + queryCacheMissCount);

        System.out.println("Query Hit ratio:" + queryCacheHitRatio);

        EntityStatistics entityStats = stats.getEntityStatistics(Course.class.getName());
        long changes =
                entityStats.getInsertCount()
                 + entityStats.getUpdateCount()
                + entityStats.getDeleteCount();
        System.out.println(Course.class.getName() + " changed " + changes + "times"  );
    }

}
