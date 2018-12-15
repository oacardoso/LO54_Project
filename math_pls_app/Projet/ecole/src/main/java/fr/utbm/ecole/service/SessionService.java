/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import fr.utbm.ecole.entity.Course;
import fr.utbm.ecole.repository.SessionDao;
import java.util.List;

/**
 *
 * @author mperrot
 */
public class SessionService {

    public SessionService() {
    }
    
    /*Liste les sessions selon un cours donné*/
    public List listSessions(Course course) {
        SessionDao dao = new SessionDao();
        return dao.listSessions(course);
    }
    
    /*Liste les sessions selon le code d'un cours*/
    public List listSessions(String code) {
        SessionDao dao = new SessionDao();
        return dao.listSessions(code);
    }
    
    /*Nombre de participants à une session*/
    public long numParticipants(int id) {
        SessionDao dao = new SessionDao();
        return dao.numParticipants(id);
    }
}
