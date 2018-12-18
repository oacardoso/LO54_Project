/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import com.codahale.metrics.Timer;
import fr.utbm.ecole.entity.Course;
import fr.utbm.ecole.repository.SessionDao;
import java.util.List;
import static com.codahale.metrics.MetricRegistry.name;
import fr.utbm.ecole.entity.Session;
import static fr.utbm.ecole.tools.MetricsRegistry.METRIC_REGISTRY;

/**
 *
 * @author mperrot
 */
public class SessionService {

    private final Timer listSessions = METRIC_REGISTRY.timer(name(SessionService.class, "listSessions"));
    private final Timer numParticipants = METRIC_REGISTRY.timer(name(SessionService.class, "numParticipants"));

    public SessionService() {
    }

    /*Liste les sessions selon un cours donné*/
    public List listSessions(Course course) {
        SessionDao dao = new SessionDao();
        return dao.listSessions(course);
    }

    /*Liste les sessions selon le code d'un cours*/
    public List listSessions(String code) {
        final Timer.Context context = listSessions.time();
        try {
            SessionDao dao = new SessionDao();
            return dao.listSessions(code);
        } finally {
            context.stop();
        }
    }
    
    /*Donne une session selon id*/
    public Session getSession(int id) {
        SessionDao dao = new SessionDao();
        return dao.getSession(id);
    }

    /*Nombre de participants à une session*/
    public long numParticipants(int id) {
        final Timer.Context context = numParticipants.time();
        try {
            SessionDao dao = new SessionDao();
            return dao.numParticipants(id);
        } finally {
            context.stop();
        }
    }
}
