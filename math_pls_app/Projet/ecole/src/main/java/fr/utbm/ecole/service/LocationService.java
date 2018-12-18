/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import static com.codahale.metrics.MetricRegistry.name;
import com.codahale.metrics.Timer;
import fr.utbm.ecole.repository.LocationDao;
import static fr.utbm.ecole.tools.MetricsRegistry.METRIC_REGISTRY;
import java.util.List;

/**
 *
 * @author mperrot
 */
public class LocationService {

    private final Timer listLocations = METRIC_REGISTRY.timer(name(CourseService.class, "listLocations"));

    public LocationService() {
    }

    /*Liste les locations*/
    public List listLocations() {
        final Timer.Context context = listLocations.time();
        try {
            LocationDao dao = new LocationDao();
            return dao.listLocations();
        } finally {
            context.stop();
        }
    }
}
