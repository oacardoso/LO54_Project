/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole;

import fr.utbm.ecole.service.ClientService;
import fr.utbm.ecole.service.CourseService;
import fr.utbm.ecole.service.SessionService;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author mperrot
 */
public class App {
    public static void main(String[] args) {
 
        ClientService Cs = new ClientService();
        SessionService Ss = new SessionService();
        List<SessionService> LSs = Ss.listSessions("IF41");
        HashSet S = new HashSet();
        S.add(LSs.get(0));
        Cs.addClient("Hitler", "Adolphe", "Allemagne", "0658759865", "SS@g.com", S);

        
    }
}
